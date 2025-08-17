package com.mrbysco.stevechair.registration;

import com.mrbysco.stevechair.Constants;
import com.mrbysco.stevechair.block.ChairBlock;
import com.mrbysco.stevechair.block.entity.SteveChairBlockEntity;
import com.mrbysco.stevechair.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class ChairRegistry {

	public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(BuiltInRegistries.BLOCK, Constants.MOD_ID);
	public static final RegistrationProvider<BlockEntityType<?>> BLOCK_ENTITIES = RegistrationProvider.get(BuiltInRegistries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);
	public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(BuiltInRegistries.ITEM, Constants.MOD_ID);

	public static final RegistryObject<ChairBlock> STEVE_CHAIR = registerBlock("steve_chair", ChairBlock::new, Properties.of().strength(1.0F).pushReaction(PushReaction.DESTROY)
	);
	public static final RegistryObject<BlockItem> STEVE_CHAIR_ITEM = registerItem("steve_chair", (properties) ->
			new BlockItem(STEVE_CHAIR.get(), properties), new Item.Properties().useBlockDescriptionPrefix());

	public static final RegistryObject<BlockEntityType<SteveChairBlockEntity>> STEVE_CHAIR_BLOCK_ENTITY = BLOCK_ENTITIES.register("steve_chair", Services.PLATFORM::createBlockEntity);

	public static<B extends Block> RegistryObject<B> registerBlock(String name, Function<Properties, B> func, BlockBehaviour.Properties props) {
		return BLOCKS.register(name, () -> func.apply(props.setId(ResourceKey.create(Registries.BLOCK, Constants.modLoc(name)))));
	}

	public static<I extends Item> RegistryObject<I> registerItem(String name, Function<Item.Properties, I> func, Item.Properties props) {
		return ITEMS.register(name, () -> func.apply(props.setId(ResourceKey.create(Registries.ITEM, Constants.modLoc(name)))));
	}

	// Called in the mod initializer / constructor in order to make sure that items are registered
	public static void loadClass() {
	}
}
