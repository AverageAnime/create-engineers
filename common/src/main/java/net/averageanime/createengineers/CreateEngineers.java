package net.averageanime.createengineers;

import net.averageanime.createengineers.config.OmegaConfig;
import net.averageanime.createengineers.config.ModConfig;

import net.averageanime.createengineers.init.*;
import net.averageanime.createengineers.tradeoffers.TradeOfferManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateEngineers {
	public static final String MOD_ID = "createengineers";
	public static final ModConfig CONFIG = OmegaConfig.register(ModConfig.class);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ModConfig getConfig() {
		return CONFIG;
	}

	public static void init() {

		ModItems.init();
		ModBlocks.init();
		ModItemGroups.init();

		TradeOfferManager.registerTradeOffers();

	}

	public static void postInit() {
		ModItems.addItemsToGroup();
	}

	public static String createStringID(String name) {
		return MOD_ID + ":" + name;
	}

}
