package com.mrbysco.stevechair.registry;

import com.mrbysco.stevechair.SteveChairMod;
import com.mrbysco.stevechair.block.ChairBlock;
import com.mrbysco.stevechair.block.entity.SteveChairBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ChairRegistry {
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(SteveChairMod.MOD_ID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, SteveChairMod.MOD_ID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SteveChairMod.MOD_ID);

	public static final DeferredBlock<ChairBlock> STEVE_CHAIR = BLOCKS.register("steve_chair", () -> new ChairBlock(
			Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY))
	);
	public static final DeferredItem<BlockItem> STEVE_CHAIR_ITEM = ITEMS.registerSimpleBlockItem(STEVE_CHAIR);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SteveChairBlockEntity>> STEVE_CHAIR_BLOCK_ENTITY = BLOCK_ENTITIES.register("steve_chair", () ->
			BlockEntityType.Builder.of(SteveChairBlockEntity::new, ChairRegistry.STEVE_CHAIR.get()).build(null));

}
