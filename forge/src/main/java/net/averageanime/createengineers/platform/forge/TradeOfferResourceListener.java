package net.averageanime.createengineers.platform.forge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.averageanime.createengineers.tradeoffers.TradeOfferManager;
import net.averageanime.createengineers.tradeoffers.TradeOfferRegistryLoader;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.registry.Registries;
import net.minecraft.resource.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TradeOfferResourceListener extends JsonDataLoader implements ResourceReloader {

    public TradeOfferResourceListener() {
        super(new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().setLenient().create(), "villager_trades");
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> loader, ResourceManager manager, Profiler profiler) {
        for (ResourcePack pack : manager.streamResourcePacks().collect(Collectors.toList())) {
            try {
                for (VillagerProfession villager : Registries.VILLAGER_PROFESSION.stream().collect(Collectors.toList())) {
                    loadAndMergeTradeOffers(pack, villager);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadAndMergeTradeOffers(ResourcePack pack, VillagerProfession villager) throws IOException {
        String id = villager.id();
        if (id.contains(":")) id = id.split(":")[1];

        InputSupplier<InputStream> tradeInputStreamSupplier = pack.open(ResourceType.SERVER_DATA, new Identifier(net.averageanime.createengineers.CreateEngineers.MOD_ID, "villager_trades/" + id + ".json"));

        if (tradeInputStreamSupplier == null || tradeInputStreamSupplier.get() == null) {
            return;
        }

        net.averageanime.createengineers.CreateEngineers.LOGGER.info("Deserializing datapack added trades of profession: " + net.averageanime.createengineers.CreateEngineers.MOD_ID + ":" + villager + " from " + pack.getName());

        JsonObject tradeData = new Gson().fromJson(new InputStreamReader(tradeInputStreamSupplier.get()), JsonObject.class);

        TradeOfferManager.deserializeJson(tradeData);

        // trades from datapacks
        Map<VillagerProfession, Int2ObjectOpenHashMap<TradeOffers.Factory[]>> datapackTrades = TradeOfferRegistryLoader.getRegistryForLoading();

        // merge trades added from datapack with the default trades added via data-json
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.forEach((profession, defaultProfessionTrades) -> {
            Int2ObjectOpenHashMap<TradeOffers.Factory[]> datapackProfessionTrades = datapackTrades.getOrDefault(profession, new Int2ObjectOpenHashMap<>());

            datapackProfessionTrades.forEach((level, datapackLevelTrades) -> { // collect trades per level and per profession from the datapack
                TradeOffers.Factory[] defaultLevelTrades = defaultProfessionTrades.get(level);

                TradeOffers.Factory[] mergedTrades = Stream.concat( // if default trades are available, merge them with the datapack trades
                                (defaultLevelTrades != null) ? Arrays.stream(defaultLevelTrades) : Stream.empty(),
                                Arrays.stream(datapackLevelTrades))
                        .distinct()
                        .toArray(TradeOffers.Factory[]::new);

                defaultProfessionTrades.put(level, mergedTrades);
            });
        });
    }

}