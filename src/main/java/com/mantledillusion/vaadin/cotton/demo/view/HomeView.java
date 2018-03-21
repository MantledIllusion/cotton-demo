package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.Injector;
import com.mantledillusion.injection.hura.Predefinable.Property;
import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

@Addressed(value="CottonDemo/Home", redirects={@Redirect("")})
public class HomeView extends View {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private Injector injector;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setSizeFull();
		
		HorizontalLayout layout = new HorizontalLayout();
		mainLayout.addComponent(layout);
		mainLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		
		layout.addComponent(this.injector.instantiate(ButtonSwitchView.class, Property.of(ButtonSwitchPresenter.ID_PROPERTY_KEY, "one")));
		layout.addComponent(this.injector.instantiate(ButtonSwitchView.class, Property.of(ButtonSwitchPresenter.ID_PROPERTY_KEY, "two")));
		layout.addComponent(this.injector.instantiate(ButtonSwitchView.class, Property.of(ButtonSwitchPresenter.ID_PROPERTY_KEY, "one")));
		layout.addComponent(this.injector.instantiate(ButtonSwitchView.class, Property.of(ButtonSwitchPresenter.ID_PROPERTY_KEY, "two")));
		
		return mainLayout;
	}
}
