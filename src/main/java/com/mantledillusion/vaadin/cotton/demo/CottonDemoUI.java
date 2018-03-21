package com.mantledillusion.vaadin.cotton.demo;

import com.mantledillusion.vaadin.cotton.CottonUI;
import com.mantledillusion.vaadin.cotton.UrlResourceRegistry;
import com.mantledillusion.vaadin.cotton.demo.view.DeepView;
import com.mantledillusion.vaadin.cotton.demo.view.HomeView;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.spring.annotation.SpringUI;

@SpringUI(path="*")
@PreserveOnRefresh
public class CottonDemoUI extends CottonUI {

	private static final long serialVersionUID = 1L;
	
	private static final UrlResourceRegistry URL_REGISTRY = new UrlResourceRegistry();
	
	static {
		URL_REGISTRY.registerViewResource(HomeView.class);
		URL_REGISTRY.registerViewResource(DeepView.class);
	}

	@Override
	protected UrlResourceRegistry configure(TemporalUIConfiguration configuration) {
		return URL_REGISTRY;
	}
}
