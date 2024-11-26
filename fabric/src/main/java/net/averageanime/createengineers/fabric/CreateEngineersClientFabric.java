package net.averageanime.createengineers.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;;


public class CreateEngineersClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        net.averageanime.createengineers.CreateEngineersClient.init();

    }
}
