package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.demo.DemoUser;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

abstract class AbstractUserView extends View {

	private static final long serialVersionUID = 1L;

	static final String USER_BTN_COMPONENT_ID = "userBtn";

	private Button b;

	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();

		this.b = new Button();
		reg.registerActiveComponent(USER_BTN_COMPONENT_ID, b);
		layout.addComponent(this.b);
		layout.setExpandRatio(this.b, 0);
		layout.setComponentAlignment(this.b, Alignment.TOP_RIGHT);

		refreshUserBtnCaption();

		Component content = buildContent(reg);
		layout.addComponent(content);
		layout.setExpandRatio(content, 1);

		return layout;
	}

	void refreshUserBtnCaption() {
		this.b.setCaption(
				WebEnv.isLoggedIn() ? "Logout " + ((DemoUser) WebEnv.getLoggedInUser()).getName() : "No User: Login");
	}

	protected abstract Component buildContent(TemporalActiveComponentRegistry reg) throws Throwable;
}
