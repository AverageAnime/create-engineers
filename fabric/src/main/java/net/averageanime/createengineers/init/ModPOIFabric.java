package net.averageanime.createengineers.init;

import net.averageanime.createengineers.platform.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;

import java.util.HashMap;
import java.util.function.Supplier;

import static net.averageanime.createengineers.init.ModBlocks.*;

public class ModPOIFabric {
    private static final HashMap<String, Supplier<PointOfInterestType>> REGISTERED_POINT_OF_INTEREST_TYPES;

    public final static Supplier<PointOfInterestType> RAILWAY_ENGINEER_TABLE_POI;

    static {

        REGISTERED_POINT_OF_INTEREST_TYPES = new HashMap<>();

        RAILWAY_ENGINEER_TABLE_POI = registerPointOfInterest("railway_engineer_table_poi", () -> new PointOfInterestType(PointOfInterestTypes.getStatesOfBlock(RAILWAY_ENGINEER_TABLE_BLOCK.get()), 1, 1));

    }

    public static void init() {
    }

    public static void postInit() {
        fillMissingPointOfInterestMapValues();
    }

    private static Supplier<PointOfInterestType> registerPointOfInterest(String name, Supplier<PointOfInterestType> pointOfInterestType) {
        REGISTERED_POINT_OF_INTEREST_TYPES.put(name, pointOfInterestType);
        return RegistryHelper.registerPointOfInterestType(name, pointOfInterestType);
    }

    private static void fillMissingPointOfInterestMapValues() {
        REGISTERED_POINT_OF_INTEREST_TYPES.forEach((name, pointOfInterestType) -> fillMissingPointOfInterestMapValueForBlock(name, pointOfInterestType.get().blockStates().iterator().next().getBlock()));
    }

    private static void fillMissingPointOfInterestMapValueForBlock(String name, Block pointOfInterestBlock) {
        var blockStates = PointOfInterestTypes.getStatesOfBlock(pointOfInterestBlock);
        blockStates.forEach((state) -> PointOfInterestTypes.POI_STATES_TO_TYPE.put(state, Registries.POINT_OF_INTEREST_TYPE.getEntry(RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(net.averageanime.createengineers.CreateEngineers.MOD_ID, name))).get()));
    }
}
