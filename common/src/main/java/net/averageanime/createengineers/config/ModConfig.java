package net.averageanime.createengineers.config;

import net.averageanime.createengineers.config.annotations.Description;

public class ModConfig implements Config {

    @Override
    public String getName() {
        return "delightful-trades-config";
    }

    @Override
    public String getExtension() {
        return "json5";
    }

    @Override
    public String getDirectory() {
        return "delightfulchefs";
    }

    @Description("Amount of new trades per level a villager can have at max. (Default: 2)")
    public int trade_offers_per_level = 2;
    @Description("Amount of trades the wandering trader can have at max. (Default: 5)")
    public int trade_offers_wandering_trader = 5;

}


