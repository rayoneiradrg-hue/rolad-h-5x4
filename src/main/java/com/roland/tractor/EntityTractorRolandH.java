package com.roland.tractor;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class EntityTractorRolandH extends Entity {

    public EntityTractorRolandH(EntityType<? extends EntityTractorRolandH> type, Level level) {
        super(type, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        if (!player.level().isClientSide() && !player.isShiftKeyDown()) {
            if (this.getPassengers().isEmpty()) {
                player.startRiding(this);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(RolandTractorMod.TRACTOR_ITEM);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        return false;
    }
}
