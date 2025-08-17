package com.mrbysco.stevechair.datagen.server;

import com.mrbysco.stevechair.registration.ChairRegistry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ChairLootProvider extends LootTableProvider {
	public ChairLootProvider(PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
		super(packOutput, Set.of(), List.of(
				new SubProviderEntry(ChairBlockLoot::new, LootContextParamSets.BLOCK)
		), lookupProvider);
	}

	private static class ChairBlockLoot extends BlockLootSubProvider {

		protected ChairBlockLoot(Provider registries) {
			super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
		}

		@Override
		protected void generate() {
			this.dropSelf(ChairRegistry.STEVE_CHAIR.get());
		}

		@Override
		protected Iterable<Block> getKnownBlocks() {
			return (Iterable<Block>) ChairRegistry.BLOCKS.getEntries().stream().map(holder -> (Block) holder.get())::iterator;
		}
	}
}
