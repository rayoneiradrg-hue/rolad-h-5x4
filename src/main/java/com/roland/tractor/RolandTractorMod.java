package com.roland.tractor;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;

public class RolandTractorMod implements ModInitializer {

    public static final String MOD_ID = "roland";
    public static final Identifier TRACTOR_ID = Identifier.fromNamespaceAndPath(MOD_ID, "roland_tractor");
    public static final ResourceKey<EntityType<?>> TRACTOR_KEY = ResourceKey.create(Registries.ENTITY_TYPE, TRACTOR_ID);

    public static EntityType<EntityTractorRolandH> TRACTOR_ENTITY;
    public static Item TRACTOR_ITEM;

    @Override
    public void onInitialize() {
        TRACTOR_ENTITY = Registry.register(
                BuiltInRegistries.ENTITY_TYPE,
                TRACTOR_ID,
                EntityType.Builder.of(EntityTractorRolandH::new, MobCategory.MISC)
                        .sized(1.8f, 1.4f)
                        .clientTrackingRange(64)
                        .updateInterval(3)
                        .build(TRACTOR_KEY)
        );

        TRACTOR_ITEM = Registry.register(
                BuiltInRegistries.ITEM,
                TRACTOR_ID,
                new Item(new Item.Properties().stacksTo(1))
        );
    }
}
