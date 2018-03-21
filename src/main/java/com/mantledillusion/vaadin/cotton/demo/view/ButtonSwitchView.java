package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Property;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;

@Presented(ButtonSwitchPresenter.class)
public class ButtonSwitchView extends View {

	private static final long serialVersionUID = 1L;

	static final String BTN_COMPONENT_ID = "btn";
	
	@Property(ButtonSwitchPresenter.ID_PROPERTY_KEY)
	private String id;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		Button b = new Button("Switch "+this.id+"'s");
		reg.registerActiveComponent(BTN_COMPONENT_ID, b);
		return b;
	}
}
