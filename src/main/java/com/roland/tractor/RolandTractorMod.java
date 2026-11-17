package com.roland.tractor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

public class RolandTractorMod implements ModInitializer {

    public static final String MOD_ID = "roland";

    public static final Identifier TRACTOR_ID = Identifier.fromNamespaceAndPath(MOD_ID, "roland_tractor");

    public static EntityType<EntityTractorRolandH> TRACTOR_ENTITY;
    public static Item TRACTOR_ITEM;

    @Override
    public void onInitialize() {
        // Registrar la entidad del tractor
        TRACTOR_ENTITY = Registry.register(
                BuiltInRegistries.ENTITY_TYPE,
                TRACTOR_ID,
                FabricEntityTypeBuilder.create(MobCategory.MISC, EntityTractorRolandH::new)
                        .dimensions(EntityDimensions.fixed(1.8f, 1.4f))
                        .trackRangeBlocks(64)
                        .trackedUpdateRate(3)
                        .build()
        );

        // Crear el item (huevo de spawn) para colocar el tractor
        TRACTOR_ITEM = new SpawnEggItem(
                TRACTOR_ENTITY,
                0xC8102E, // rojo
                0xFFD700, // amarillo
                new Item.Properties()
                        .stacksTo(1)
        );

        Registry.register(BuiltInRegistries.ITEM, TRACTOR_ID, TRACTOR_ITEM);
    }
}
