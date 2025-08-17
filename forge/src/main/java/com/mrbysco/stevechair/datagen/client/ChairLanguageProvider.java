package com.mrbysco.stevechair.datagen.client;

import com.mrbysco.stevechair.Constants;
import com.mrbysco.stevechair.registration.ChairRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ChairLanguageProvider extends LanguageProvider {

	public ChairLanguageProvider(PackOutput packOutput) {
		super(packOutput, Constants.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations() {
		addBlock(ChairRegistry.STEVE_CHAIR, "Steve Chair");
	}
}
