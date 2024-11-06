package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.SteveChairMod;
import com.mrbysco.stevechair.registry.ChairRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ChairLanguageProvider extends LanguageProvider {

	public ChairLanguageProvider(PackOutput packOutput) {
		super(packOutput, SteveChairMod.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addBlock(ChairRegistry.STEVE_CHAIR, "Steve Chair");
	}
}
