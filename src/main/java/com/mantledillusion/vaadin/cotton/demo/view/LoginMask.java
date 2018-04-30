package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.demo.DemoUser;
import com.mantledillusion.vaadin.cotton.environment.views.LoginView;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

@Presented(LoginPresenter.class)
public class LoginMask extends LoginView {

	private static final long serialVersionUID = 1L;

	static final String USR1_BTN_COMPONENT_ID = "usr1";
	static final String USR2_BTN_COMPONENT_ID = "usr2";
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		
		VerticalLayout btnLayout = new VerticalLayout();
		btnLayout.setSizeUndefined();
		layout.addComponent(btnLayout);
		layout.setComponentAlignment(btnLayout, Alignment.MIDDLE_CENTER);
		
		Button usr1 = new Button("Login user without sufficient rights");
		usr1.setData(new String[0]);
		reg.registerActiveComponent(USR1_BTN_COMPONENT_ID, usr1);
		btnLayout.addComponent(usr1);
		btnLayout.setComponentAlignment(usr1, Alignment.TOP_CENTER);
		
		Button usr2 = new Button("Login user with sufficient rights");
		usr2.setData(new String[] {DemoUser.ACCESS_RIGHT_ID});
		reg.registerActiveComponent(USR2_BTN_COMPONENT_ID, usr2);
		btnLayout.addComponent(usr2);
		btnLayout.setComponentAlignment(usr2, Alignment.TOP_CENTER);
		
		return layout;
	}
	
	void login(DemoUser user) {
		WebEnv.logIn(user);
	}
}
