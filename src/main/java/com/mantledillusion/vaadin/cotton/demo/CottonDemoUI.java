package com.mantledillusion.vaadin.cotton.demo;

import com.mantledillusion.vaadin.cotton.CottonUI;
import com.mantledillusion.vaadin.cotton.UrlResourceRegistry;
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
		return URL_REGISTRY;
	}
}
