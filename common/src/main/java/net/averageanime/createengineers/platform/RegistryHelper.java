package net.averageanime.createengineers.platform;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.function.Supplier;

public class RegistryHelper {

    @ExpectPlatform
    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        throw new AssertionError();
    }


    @ExpectPlatform
    public static void registerItemGroup(RegistryKey<ItemGroup> registryKey, String name, String literalName, Supplier<Item> item) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void addToItemGroup(RegistryKey<ItemGroup> itemGroup, Item item) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends PointOfInterestType> Supplier<T> registerPointOfInterestType(String name, Supplier<T> pointOfInterestType) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends VillagerProfession> Supplier<T> registerVillagerProfession(String name, Supplier<T> villagerProfession) {
        throw new AssertionError();
    }
}
