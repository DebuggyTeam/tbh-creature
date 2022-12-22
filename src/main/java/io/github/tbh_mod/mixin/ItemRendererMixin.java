package io.github.tbh_mod.mixin;

import io.github.tbh_mod.ClientInitializer;
import io.github.tbh_mod.TbhRegistry;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/**
 * A Mixin to the ItemRenderer,
 * in order to provide an alternate model for when the cola item is held
 *
 * @author Oliver-makes-code
 * @since 1.0.0
 * */
@Mixin(ItemRenderer.class)
public class ItemRendererMixin {

	@Shadow
	@Final
	private ItemModels models;

	@ModifyVariable(method = "renderItem", at = @At("HEAD"), argsOnly = true)
	private BakedModel tbh_creature$getColaModel(BakedModel base, ItemStack stack, ModelTransformation.Mode mode) {
		if (!stack.isOf(TbhRegistry.COLA_BOTTLE_ITEM)) return base;
		if (mode == ModelTransformation.Mode.GUI) return base;
		return models.getModelManager().getModel(ClientInitializer.COLA_BOTTLE_INVENTORY);
	}
}
