package com.roland.tractor;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class EntityTractorRolandH extends Entity {

    public EntityTractorRolandH(EntityType<? extends EntityTractorRolandH> entityType, Level level) {
        super(entityType, level);
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
    public Vec3 getPassengerRidingPosition(Entity passenger) {
        return this.position().add(0.0, 0.8, -0.3);
    }

    @Override
    public ItemStack getPickResult() {
        return new ItemStack(RolandTractorMod.TRACTOR_ITEM);
    }
}
