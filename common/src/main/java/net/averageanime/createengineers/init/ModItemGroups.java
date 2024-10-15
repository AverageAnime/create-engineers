package net.averageanime.createengineers.init;

import net.averageanime.createengineers.platform.RegistryHelper;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(net.averageanime.createengineers.CreateEngineers.MOD_ID, "group"));

    public static void init() {
        RegistryHelper.registerItemGroup(ITEM_GROUP, "group", "logo", ModItems.RAILWAY_ENGINEER_TABLE_BLOCK);
    }

}
