package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.Blueprint;
import com.mantledillusion.injection.hura.Injector;
import com.mantledillusion.injection.hura.Predefinable.Property;
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
	private Injector injector;

	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setSizeFull();

		VerticalLayout layout = new VerticalLayout();
		mainLayout.addComponent(layout);
		mainLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

		layout.addComponent(new Label("Predefined value: " + this.injector.instantiate(PropertiedBean.class).property));
		layout.addComponent(new Label("Spontaneous value: " + this.injector.instantiate(Blueprint
				.of(PropertiedBean.class, Property.of(PropertiedBean.PROPERTY_KEY, "spontaneous value"))).property));
		layout.addComponent(new Label("Non-matching value: " + this.injector.instantiate(Blueprint
				.of(PropertiedBean.class, Property.of(PropertiedBean.PROPERTY_KEY, "0"))).property));

		return mainLayout;
	}
}
