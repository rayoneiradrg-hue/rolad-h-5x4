package com.roland.tractor;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public final class RolandTractorMod implements ModInitializer {
    public static final String MOD_ID = "roland";
    public static final Block ROLAND_TRACTOR = new Block(
        AbstractBlock.Settings.create().strength(2.0f).nonOpaque()
    );

    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, Identifier.of(MOD_ID, "roland_tractor"), ROLAND_TRACTOR);
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, "roland_tractor"),
            new BlockItem(ROLAND_TRACTOR, new Item.Settings()));
    }
}
