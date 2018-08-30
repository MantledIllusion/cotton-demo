package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.environment.events.user.UserChangeEvent;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.vaadin.ui.Button.ClickEvent;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.mantledillusion.vaadin.cotton.viewpresenter.Subscribe;

public abstract class AbstractUserPresenter<V extends AbstractUserView> extends Presenter<V> {

	@Listen(AbstractUserView.USER_BTN_COMPONENT_ID)
	private void handleUserBtnClicked(ClickEvent event) {
		if (WebEnv.isLoggedIn()) {
			WebEnv.logOut();
		} else {
			WebEnv.triggerlogIn();
		}
	}
	
	@Subscribe
	private void handleUserChange(UserChangeEvent event) {
		getView().refreshUserBtnCaption();
	}
}
