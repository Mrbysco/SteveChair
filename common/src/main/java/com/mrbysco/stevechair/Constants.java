package com.mrbysco.stevechair;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "steve_chair";
	public static final String MOD_NAME = "Steve Chair";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	public static Identifier modLoc(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}