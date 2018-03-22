package com.mantledillusion.vaadin.cotton.demo;

import com.mantledillusion.injection.hura.Blueprint;
import com.mantledillusion.vaadin.cotton.CottonUI;
import com.mantledillusion.vaadin.cotton.UrlResourceRegistry;
import com.mantledillusion.vaadin.cotton.demo.view.HomeView;
import com.mantledillusion.vaadin.cotton.demo.view.LoginMask;
import com.mantledillusion.vaadin.cotton.demo.view.RestrictedAccessView;
import com.vaadin.spring.annotation.SpringUI;

@SpringUI(path="*")
public class CottonDemoUI extends CottonUI {

	private static final long serialVersionUID = 1L;
	
	private static final UrlResourceRegistry URL_REGISTRY = new UrlResourceRegistry();
	
	static {
		URL_REGISTRY.registerViewResource(HomeView.class);
		URL_REGISTRY.registerViewResource(RestrictedAccessView.class);
	}

	@Override
	protected UrlResourceRegistry configure(TemporalUIConfiguration configuration) {
		configuration.registerLoginView(Blueprint.of(LoginMask.class));
		
		return URL_REGISTRY;
	}
}
