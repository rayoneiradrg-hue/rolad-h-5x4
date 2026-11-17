package com.roland.tractor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public final class RolandTractorMod implements ModInitializer {
    public static final String MOD_ID = "roland";

    private static final Identifier TRACTOR_ID =
            Identifier.fromNamespaceAndPath(MOD_ID, "roland_tractor");

    private static final ResourceKey<Block> TRACTOR_BLOCK_KEY =
            ResourceKey.create(Registries.BLOCK, TRACTOR_ID);

    private static final ResourceKey<Item> TRACTOR_ITEM_KEY =
            ResourceKey.create(Registries.ITEM, TRACTOR_ID);

    @Override
    public void onInitialize() {
        Block tractorBlock = new Block(
                BlockBehaviour.Properties.of()
                        .strength(2.0f)
                        .noOcclusion()
                        .setId(TRACTOR_BLOCK_KEY)
        );

        Registry.register(BuiltInRegistries.BLOCK, TRACTOR_ID, tractorBlock);

        BlockItem tractorItem = new BlockItem(
                tractorBlock,
                new Item.Properties()
                        .setId(TRACTOR_ITEM_KEY)
                        .useBlockDescriptionPrefix()
        );

        Registry.register(BuiltInRegistries.ITEM, TRACTOR_ID, tractorItem);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register(entries -> entries.accept(tractorItem));
    }
}
