package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.vaadin.ui.Button.ClickEvent;

public class HomePresenter extends Presenter<HomeView> {

	@Listen(HomeView.BTN_COMPONENT_ID)
	private void handleBtnClick(ClickEvent event) {
		WebEnv.setCurrentLocale(getView().getOtherLocale());
	}
}
