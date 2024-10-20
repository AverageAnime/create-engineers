package net.averageanime.createengineers.init;

import net.averageanime.createengineers.blocks.*;
import net.averageanime.createengineers.platform.RegistryHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;

import java.util.function.Supplier;

public class ModBlocks {

    public static final Supplier<Block> RAILWAY_ENGINEER_TABLE_BLOCK = RegistryHelper.registerBlock("railway_engineer_table_block", () -> new RailwayEngineerTableBlock(AbstractBlock.Settings.create().strength(0.5F).luminance((state) -> 1).nonOpaque()));

    public static final Supplier<Block> MECHANICAL_ENGINEER_TABLE_BLOCK = RegistryHelper.registerBlock("mechanical_engineer_table_block", () -> new MechanicalEngineerTableBlock(AbstractBlock.Settings.create().strength(0.5F).luminance((state) -> 1).nonOpaque()));

    public static final Supplier<Block> HYDRAULIC_ENGINEER_TABLE_BLOCK = RegistryHelper.registerBlock("hydraulic_engineer_table_block", () -> new HydraulicEngineerTableBlock(AbstractBlock.Settings.create().strength(0.5F).luminance((state) -> 1).nonOpaque()));

    public static final Supplier<Block> WORKER_TABLE_BLOCK = RegistryHelper.registerBlock("worker_table_block", () -> new WorkerTableBlock(AbstractBlock.Settings.create().strength(0.5F).luminance((state) -> 1).nonOpaque()));

    public static void init() {

    }

}
