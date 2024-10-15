package net.averageanime.createengineers.fabric;

import net.fabricmc.api.ClientModInitializer;;


public class CreateEngineersClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        net.averageanime.createengineers.CreateEngineersClient.init();

    }
}
