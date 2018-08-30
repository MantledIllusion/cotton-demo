package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.demo.DemoUser;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.vaadin.ui.Button.ClickEvent;

public class LoginPresenter extends Presenter<LoginMask> {

	@Listen
	private void handleBtnClicked(ClickEvent event) {
		String[] rights = (String[]) event.getButton().getData();
		WebEnv.logIn(new DemoUser(rights.length > 0 ? "Priviledged_User" : "Unpriviledged_User", rights));
	}
}
