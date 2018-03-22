package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen.ActiveComponent;
import com.vaadin.ui.Button.ClickEvent;

public class RestrictedAccessPresenter extends AbstractUserPresenter<RestrictedAccessView> {

	@Listen(@ActiveComponent(RestrictedAccessView.BTN_COMPONENT_ID))
	private void handleBtnClicked(ClickEvent event) {
		WebEnv.logOut();
	}
}
