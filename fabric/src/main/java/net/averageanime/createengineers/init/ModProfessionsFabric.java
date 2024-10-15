package net.averageanime.createengineers.init;

import com.google.common.collect.ImmutableSet;
import net.averageanime.createengineers.platform.RegistryHelper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static net.averageanime.createengineers.init.ModPOIFabric.*;

public class ModProfessionsFabric {

    public static void init() {
    }

    public static Supplier<VillagerProfession> RAILWAY_ENGINEER;

    public static final Predicate<RegistryEntry<PointOfInterestType>> RAILWAY_ENGINEER_PREDICATE = (registryEntry) -> registryEntry.value() == RAILWAY_ENGINEER_TABLE_POI.get();

    static {

        RAILWAY_ENGINEER = RegistryHelper.registerVillagerProfession("railway_engineer", () -> new VillagerProfession(
                net.averageanime.createengineers.CreateEngineers.createStringID("railway_engineer"), RAILWAY_ENGINEER_PREDICATE, RAILWAY_ENGINEER_PREDICATE, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_FARMER
        ));

    }
}
