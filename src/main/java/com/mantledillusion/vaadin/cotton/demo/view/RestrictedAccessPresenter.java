package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.vaadin.ui.Button.ClickEvent;

public class RestrictedAccessPresenter extends AbstractUserPresenter<RestrictedAccessView> {

	@Listen(RestrictedAccessView.BTN_COMPONENT_ID)
	private void handleBtnClicked(ClickEvent event) {
		WebEnv.logOut();
	}
}
