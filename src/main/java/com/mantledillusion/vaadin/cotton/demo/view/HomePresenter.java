package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.CottonUI.NavigationEvent;
import com.mantledillusion.vaadin.cotton.CottonUI.NavigationType;
import com.mantledillusion.vaadin.cotton.QueryParam;
import com.mantledillusion.vaadin.cotton.RequiredQueryParam;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen.ActiveComponent;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.mantledillusion.vaadin.cotton.viewpresenter.Subscribe;
import com.vaadin.ui.Button.ClickEvent;

public class HomePresenter extends Presenter<HomeView> {
	
	private static final String[] SOME_NAMES = {"Julius", "Tammy", "Andre"};
	
	@RequiredQueryParam(value="name")
	private QueryParam param;

	@Listen(@ActiveComponent(HomeView.BTN_COMPONENT_ID))
	private void handleBtnClicked(ClickEvent event) {
		this.param.setValues(SOME_NAMES[(int) Math.round(Math.random()*2)]);
	}
	
	@Subscribe
	private void handleQueryParamChanged(NavigationEvent event) {
		if (event.getNavigationType() == NavigationType.QUERY_PARAM_CHANGE) {
			getView().refreshBtnCaption();
		}
	}
}
