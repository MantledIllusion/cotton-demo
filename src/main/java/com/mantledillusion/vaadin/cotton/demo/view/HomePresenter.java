package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.Cookie;
import com.mantledillusion.vaadin.cotton.RequiredCookie;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.vaadin.data.HasValue.ValueChangeEvent;

public class HomePresenter extends Presenter<HomeView> {

	@RequiredCookie(value = "freetext")
	private Cookie cookie;

	@Listen(HomeView.FIELD_COMPONENT_ID)
	private void handleValueChange(ValueChangeEvent<String> event) {
		this.cookie.setValue(event.getValue());
		getView().refreshField();
	}
}
