package net.averageanime.createengineers.config;

import net.averageanime.createengineers.config.annotations.Description;

public class ModConfig implements Config {

    @Override
    public String getName() {
        return "create-engineers-config";
    }

    @Override
    public String getExtension() {
        return "json5";
    }

    @Override
    public String getDirectory() {
        return "createengineers";
    }

}


