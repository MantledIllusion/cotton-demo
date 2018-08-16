package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.Injector;
import com.mantledillusion.injection.hura.annotation.Adjust.PropertyDef;
import com.mantledillusion.injection.hura.annotation.Adjust;
import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Addressed(value = "CottonDemo/Home", redirects = { @Redirect("") })
public class HomeView extends View {

	private static final long serialVersionUID = 1L;

	@Inject
	private PropertiedBean predefined;
	@Inject
	@Adjust(properties=@PropertyDef(key=PropertiedBean.PROPERTY_KEY, value="spontaneous value"))
	private PropertiedBean spontaneous;
	@Inject
	@Adjust(properties=@PropertyDef(key=PropertiedBean.PROPERTY_KEY, value="0"))
	private PropertiedBean nonMatching;
	
	@Inject
	private Injector injector;

	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setSizeFull();

		VerticalLayout layout = new VerticalLayout();
		mainLayout.addComponent(layout);
		mainLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

		layout.addComponent(new Label("Predefined value: " + this.predefined.property));
		layout.addComponent(new Label("Spontaneous value: " + this.spontaneous.property));
		layout.addComponent(new Label("Non-matching value: " + this.nonMatching.property));

		return mainLayout;
	}
}
