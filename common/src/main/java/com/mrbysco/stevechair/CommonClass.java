package com.mrbysco.stevechair;

import com.mrbysco.stevechair.registration.ChairRegistry;

public class CommonClass {

	public static void init() {
		ChairRegistry.loadClass();
	}
}