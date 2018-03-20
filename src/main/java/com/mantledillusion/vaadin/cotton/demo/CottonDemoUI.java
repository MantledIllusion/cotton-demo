package com.mantledillusion.vaadin.cotton.demo;

import com.mantledillusion.injection.hura.Predefinable.Singleton;
import com.mantledillusion.vaadin.cotton.CottonUI;
import com.mantledillusion.vaadin.cotton.UrlResourceRegistry;
import com.mantledillusion.vaadin.cotton.demo.view.GlobalSingleton;
import com.mantledillusion.vaadin.cotton.demo.view.HomeView;
import com.vaadin.spring.annotation.SpringUI;

@SpringUI(path="*")
public class CottonDemoUI extends CottonUI {

	private static final long serialVersionUID = 1L;
	
	private static final UrlResourceRegistry URL_REGISTRY = new UrlResourceRegistry();
	
	static {
		URL_REGISTRY.registerViewResource(HomeView.class);
	}

	@Override
	protected UrlResourceRegistry configure(TemporalUIConfiguration configuration) {
		configuration.registerPredefinables(Singleton.of(GlobalSingleton.SINGLETON_ID_2, new GlobalSingleton("globally defined!")));
		
		return URL_REGISTRY;
	}
}
