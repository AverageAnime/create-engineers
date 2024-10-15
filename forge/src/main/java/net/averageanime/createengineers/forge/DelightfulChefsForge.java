package net.averageanime.delightfulchefs.forge;

import net.averageanime.delightfulchefs.platform.forge.DefaultTradeOfferResourceListener;
import net.averageanime.delightfulchefs.platform.forge.RegistryHelperImpl;
import net.averageanime.delightfulchefs.platform.forge.TradeOfferResourceListener;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(net.averageanime.delightfulchefs.CreateEngineers.MOD_ID)
public class DelightfulChefsForge {

    public DelightfulChefsForge() {

        net.averageanime.delightfulchefs.CreateEngineers.init();

        if (FMLEnvironment.dist == Dist.CLIENT) {
            net.averageanime.delightfulchefs.CreateEngineersClient.init();
        }

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        RegistryHelperImpl.BLOCKS.register(bus);
        RegistryHelperImpl.ITEMS.register(bus);
        RegistryHelperImpl.TILE_ENTITIES.register(bus);
        RegistryHelperImpl.PARTICLES.register(bus);
        RegistryHelperImpl.CREATIVE_TABS.register(bus);
        RegistryHelperImpl.MENUS.register(bus);
        RegistryHelperImpl.POINT_OF_INTEREST_TYPES.register(bus);
        RegistryHelperImpl.VILLAGER_PROFESSIONS.register(bus);

        bus.addListener(DelightfulChefsForge::addItemsToTabs);

        forgeBus.register(this);
        forgeBus.addListener(DelightfulChefsForge::registerResourceReloader);
    }

    @SubscribeEvent
    public static void registerResourceReloader(AddReloadListenerEvent event) {
        event.addListener(new DefaultTradeOfferResourceListener());
        event.addListener(new TradeOfferResourceListener());
    }

    @SubscribeEvent
    public static void addItemsToTabs(BuildCreativeModeTabContentsEvent event) {
        RegistryHelperImpl.ITEMS_TO_ADD.forEach((itemGroup, itemPairs) -> {
            if (event.getTabKey() == itemGroup) {
                itemPairs.forEach(item -> {
                    event.getEntries().put(item.getDefaultStack(), ItemGroup.StackVisibility.PARENT_AND_SEARCH_TABS);
                });
            }
        });
    }
}
