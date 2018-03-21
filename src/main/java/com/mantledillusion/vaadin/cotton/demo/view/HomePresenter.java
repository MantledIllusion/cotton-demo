package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.CottonUI.NavigationAnnouncementEvent;
import com.mantledillusion.vaadin.cotton.NavigationTarget;
import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.mantledillusion.vaadin.cotton.viewpresenter.Subscribe;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen.ActiveComponent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

public class HomePresenter extends Presenter<HomeView> {

	@Listen(@ActiveComponent(HomeView.BTN_COMPONENT_ID))
	private void handleBtnClicked(ClickEvent event) {
		WebEnv.navigateTo(NavigationTarget.of(DeepView.class));
	}
	
	@Subscribe
	private void handleNavigationAnnouncementEvent(NavigationAnnouncementEvent event) {
		if (getView().doDeny()) {
			event.decline();
			Notification.show("Nope! Denied.");
		}
	}
}
