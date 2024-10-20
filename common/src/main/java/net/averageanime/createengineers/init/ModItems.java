package net.averageanime.createengineers.init;

import net.averageanime.createengineers.platform.RegistryHelper;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import java.util.function.Supplier;

public class ModItems {

    public static final Supplier<Item> RAILWAY_ENGINEER_TABLE_BLOCK = RegistryHelper.registerItem("railway_engineer_table_block", () -> new BlockItem(ModBlocks.RAILWAY_ENGINEER_TABLE_BLOCK.get(), new Item.Settings()));
    public static final Supplier<Item> HYDRAULIC_ENGINEER_TABLE_BLOCK = RegistryHelper.registerItem("hydraulic_engineer_table_block", () -> new BlockItem(ModBlocks.HYDRAULIC_ENGINEER_TABLE_BLOCK.get(), new Item.Settings()));
    public static final Supplier<Item> MECHANICAL_ENGINEER_TABLE_BLOCK = RegistryHelper.registerItem("mechanical_engineer_table_block", () -> new BlockItem(ModBlocks.MECHANICAL_ENGINEER_TABLE_BLOCK.get(), new Item.Settings()));
    public static final Supplier<Item> WORKER_TABLE_BLOCK = RegistryHelper.registerItem("worker_table_block", () -> new BlockItem(ModBlocks.WORKER_TABLE_BLOCK.get(), new Item.Settings()));


    public static void init() {}

    public static void addItemsToGroup() {

        RegistryHelper.addToItemGroup(ModItemGroups.ITEM_GROUP, WORKER_TABLE_BLOCK.get());

        RegistryHelper.addToItemGroup(ModItemGroups.ITEM_GROUP, MECHANICAL_ENGINEER_TABLE_BLOCK.get());

        RegistryHelper.addToItemGroup(ModItemGroups.ITEM_GROUP, HYDRAULIC_ENGINEER_TABLE_BLOCK.get());

        RegistryHelper.addToItemGroup(ModItemGroups.ITEM_GROUP, RAILWAY_ENGINEER_TABLE_BLOCK.get());

    }
}
