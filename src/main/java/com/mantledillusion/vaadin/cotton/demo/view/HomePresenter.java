package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen.ActiveComponent;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.vaadin.ui.Button.ClickEvent;

public class HomePresenter extends Presenter<HomeView> {

	@Listen(@ActiveComponent(HomeView.BTN_COMPONENT_ID))
	private void handleBtnClicked(ClickEvent event) {
		getView().increment();
	}
}
