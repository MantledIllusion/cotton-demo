package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.Cookie;
import com.mantledillusion.vaadin.cotton.RequiredCookie;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

@Addressed(value = "CottonDemo/Home", redirects = { @Redirect("") })
@Presented(HomePresenter.class)
public class HomeView extends View {

	private static final long serialVersionUID = 1L;
	
	static final String FIELD_COMPONENT_ID = "field";

	@RequiredCookie(value = "freetext", forced = true, defaultValue = "default")
	private Cookie cookie;

	private TextField field;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();

		this.field = new TextField();
		reg.registerActiveComponent(FIELD_COMPONENT_ID, this.field);
		layout.addComponent(this.field);
		layout.setComponentAlignment(this.field, Alignment.MIDDLE_CENTER);

		refreshField();
		
		return layout;
	}
	
	void refreshField() {
		this.field.setValue(this.cookie.getValue());
	}
}
