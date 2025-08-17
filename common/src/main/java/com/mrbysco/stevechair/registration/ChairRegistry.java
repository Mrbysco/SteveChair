package com.mrbysco.stevechair.registration;

import com.mrbysco.stevechair.Constants;
import com.mrbysco.stevechair.block.ChairBlock;
import com.mrbysco.stevechair.block.entity.SteveChairBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.PushReaction;

/**
 * Example class for item registration
 */
public class ChairRegistry {

	/**
	 * The provider for items
	 */
	public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(BuiltInRegistries.BLOCK, Constants.MOD_ID);
	public static final RegistrationProvider<BlockEntityType<?>> BLOCK_ENTITIES = RegistrationProvider.get(BuiltInRegistries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);
	public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(BuiltInRegistries.ITEM, Constants.MOD_ID);

	public static final RegistryObject<ChairBlock> STEVE_CHAIR = BLOCKS.register("steve_chair", () -> new ChairBlock(
			Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY))
	);
	public static final RegistryObject<BlockItem> STEVE_CHAIR_ITEM = ITEMS.register("steve_chair", () -> new BlockItem(STEVE_CHAIR.get(), new Item.Properties()));

	public static final RegistryObject<BlockEntityType<SteveChairBlockEntity>> STEVE_CHAIR_BLOCK_ENTITY = BLOCK_ENTITIES.register("steve_chair", () ->
			BlockEntityType.Builder.of(SteveChairBlockEntity::new, ChairRegistry.STEVE_CHAIR.get()).build(null));

	// Called in the mod initializer / constructor in order to make sure that items are registered
	public static void loadClass() {
	}
}
