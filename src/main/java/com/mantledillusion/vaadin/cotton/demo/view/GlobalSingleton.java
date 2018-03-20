package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Construct;

public class GlobalSingleton {
	
	static final String SINGLETON_ID_1 = "GlobalSingleton1";
	public static final String SINGLETON_ID_2 = "GlobalSingleton2";
	
	public final String id;
	
	@Construct
	private GlobalSingleton() {
		this("Constructed by injection");
	}

	public GlobalSingleton(String id) {
		this.id = id;
	}
}
