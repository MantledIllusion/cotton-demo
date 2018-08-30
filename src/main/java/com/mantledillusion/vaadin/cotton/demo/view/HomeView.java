package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.Injector;
import com.mantledillusion.injection.hura.annotation.Adjust;
import com.mantledillusion.injection.hura.annotation.Adjust.PropertyDef;
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
	@Inject
	@Adjust(properties=@PropertyDef(key=ButtonSwitchPresenter.ID_PROPERTY_KEY, value="one"))
	private ButtonSwitchView aOne;
	@Inject
	@Adjust(properties=@PropertyDef(key=ButtonSwitchPresenter.ID_PROPERTY_KEY, value="two"))
	private ButtonSwitchView aTwo;
	@Inject
	@Adjust(properties=@PropertyDef(key=ButtonSwitchPresenter.ID_PROPERTY_KEY, value="one"))
	private ButtonSwitchView bOne;
	@Inject
	@Adjust(properties=@PropertyDef(key=ButtonSwitchPresenter.ID_PROPERTY_KEY, value="two"))
	private ButtonSwitchView bTwo;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setSizeFull();
		
		HorizontalLayout layout = new HorizontalLayout(this.aOne, this.aTwo, this.bOne, this.bTwo);
		mainLayout.addComponent(layout);
		mainLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		
		return mainLayout;
	}
}
