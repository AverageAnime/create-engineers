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

    public static Supplier<VillagerProfession> WORKER;

    public static Supplier<VillagerProfession> MECHANICAL_ENGINEER;

    public static Supplier<VillagerProfession> HYDRAULIC_ENGINEER;

    public static Supplier<VillagerProfession> RAILWAY_ENGINEER;

    public static final Predicate<RegistryEntry<PointOfInterestType>> WORKER_PREDICATE = (registryEntry) -> registryEntry.value() == WORKER_TABLE_POI.get();

    public static final Predicate<RegistryEntry<PointOfInterestType>> MECHANICAL_ENGINEER_PREDICATE = (registryEntry) -> registryEntry.value() == MECHANICAL_ENGINEER_TABLE_POI.get();

    public static final Predicate<RegistryEntry<PointOfInterestType>> HYDRAULIC_ENGINEER_PREDICATE = (registryEntry) -> registryEntry.value() == HYDRAULIC_ENGINEER_TABLE_POI.get();

    public static final Predicate<RegistryEntry<PointOfInterestType>> RAILWAY_ENGINEER_PREDICATE = (registryEntry) -> registryEntry.value() == RAILWAY_ENGINEER_TABLE_POI.get();

    static {
        WORKER = RegistryHelper.registerVillagerProfession("worker", () -> new VillagerProfession(
                net.averageanime.createengineers.CreateEngineers.createStringID("worker"), WORKER_PREDICATE, WORKER_PREDICATE, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_ARMORER
        ));

        MECHANICAL_ENGINEER = RegistryHelper.registerVillagerProfession("mechanical_engineer", () -> new VillagerProfession(
                net.averageanime.createengineers.CreateEngineers.createStringID("mechanical_engineer"), MECHANICAL_ENGINEER_PREDICATE, MECHANICAL_ENGINEER_PREDICATE, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_ARMORER
        ));

        HYDRAULIC_ENGINEER = RegistryHelper.registerVillagerProfession("hydraulic_engineer", () -> new VillagerProfession(
                net.averageanime.createengineers.CreateEngineers.createStringID("hydraulic_engineer"), HYDRAULIC_ENGINEER_PREDICATE, HYDRAULIC_ENGINEER_PREDICATE, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_ARMORER
        ));

        RAILWAY_ENGINEER = RegistryHelper.registerVillagerProfession("railway_engineer", () -> new VillagerProfession(
                net.averageanime.createengineers.CreateEngineers.createStringID("railway_engineer"), RAILWAY_ENGINEER_PREDICATE, RAILWAY_ENGINEER_PREDICATE, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_ARMORER
        ));

    }
}
