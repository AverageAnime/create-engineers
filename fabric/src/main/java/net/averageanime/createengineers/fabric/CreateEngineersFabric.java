package net.averageanime.createengineers.fabric;

import net.averageanime.createengineers.init.ModPOIFabric;
import net.averageanime.createengineers.init.ModProfessionsFabric;
import net.averageanime.createengineers.platform.fabric.DefaultTradeOfferResourceListener;
import net.averageanime.createengineers.platform.fabric.TradeOfferResourceListener;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;

public class CreateEngineersFabric implements ModInitializer {

    @Override
    public void onInitialize() {

        ModPOIFabric.postInit();
        ModProfessionsFabric.init();


        net.averageanime.createengineers.CreateEngineers.init();
        net.averageanime.createengineers.CreateEngineers.postInit();

        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new DefaultTradeOfferResourceListener());
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(new TradeOfferResourceListener());
    }

}
