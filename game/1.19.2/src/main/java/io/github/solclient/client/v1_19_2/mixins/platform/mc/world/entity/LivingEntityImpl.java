package io.github.solclient.client.v1_19_2.mixins.platform.mc.world.entity;


import java.util.Collection;
import java.util.List;

import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import com.google.common.collect.Ordering;

import io.github.solclient.client.platform.mc.world.entity.LivingEntity;
import io.github.solclient.client.platform.mc.world.entity.LivingEntityType;
import io.github.solclient.client.platform.mc.world.entity.effect.StatusEffect;
import io.github.solclient.client.platform.mc.world.entity.effect.StatusEffectType;
import io.github.solclient.client.platform.mc.world.item.ItemStack;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.effect.StatusEffectInstance;

@Mixin(net.minecraft.entity.LivingEntity.class)
@Implements(@Interface(iface = LivingEntity.class, prefix = "platform$"))
public abstract class LivingEntityImpl {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<StatusEffect> platform$getStatusEffects() {
		// yes, vanilla does actually create a list copy every frame
		// who thought that was a good idea?
		return (List) Ordering.natural().sortedCopy(getStatusEffects());
	}

	@Shadow
	public abstract Collection<StatusEffectInstance> getStatusEffects();

	public boolean platform$hasStatusEffect(StatusEffectType effect) {
		return hasStatusEffect((net.minecraft.entity.effect.StatusEffect) effect);
	}

	@Shadow
	public abstract boolean hasStatusEffect(net.minecraft.entity.effect.StatusEffect effect);

	public boolean platform$isEntityClimbing() {
		return isClimbing();
	}

	@Shadow
	public abstract boolean isClimbing();

	public ItemStack platform$getMainHandItem() {
		return (ItemStack) (Object) getMainHandStack();
	}

	@Shadow
	public abstract net.minecraft.item.ItemStack getMainHandStack();

	public LivingEntityType platform$getLivingEntityType() {
		return (LivingEntityType) getGroup();
	}

	@Shadow
	public abstract EntityGroup getGroup();

	public boolean platform$isEntityUsingItem() {
		// TODO Auto-generated method stub
		return false;
	}

	public int platform$getItemUsageRemaining() {
		// TODO Auto-generated method stub
		return 0;
	}

}
