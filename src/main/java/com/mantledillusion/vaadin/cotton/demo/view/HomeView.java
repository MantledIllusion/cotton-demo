package com.mantledillusion.vaadin.cotton.demo.view;

import java.util.Locale;

import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Addressed(value="CottonDemo/Home", redirects={@Redirect("")})
@Presented(HomePresenter.class)
public class HomeView extends View {
	
	private static final long serialVersionUID = 1L;

	static final String BTN_COMPONENT_ID = "btn";
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setSizeFull();
		
		VerticalLayout layout = new VerticalLayout();
		mainLayout.addComponent(layout);
		mainLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		
		Label l = new Label(WebEnv.localize("welcome.message", ", dear Visitor!"));
		layout.addComponent(l);
		layout.setComponentAlignment(l, Alignment.TOP_CENTER);
		
		Button b = new Button(getOtherLocale().getDisplayName());
		reg.registerActiveComponent(BTN_COMPONENT_ID, b);
		layout.addComponent(b);
		layout.setComponentAlignment(b, Alignment.BOTTOM_CENTER);
		
		return mainLayout;
	}
	
	Locale getOtherLocale() {
		return WebEnv.getCurrentLocale().getISO3Language().equals(Locale.ENGLISH.getISO3Language()) ? Locale.FRENCH : Locale.ENGLISH;
	}
}
