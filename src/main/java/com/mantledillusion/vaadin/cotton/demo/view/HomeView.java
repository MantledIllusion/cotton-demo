package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

@Addressed(value="CottonDemo/Home", redirects={@Redirect("")})
@Presented(HomePresenter.class)
public class HomeView extends View {
	
	private static final long serialVersionUID = 1L;
	
	static final String BTN_COMPONENT_ID = "btn";

	private CheckBox cb;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setSizeFull();
		
		HorizontalLayout layout = new HorizontalLayout();
		mainLayout.addComponent(layout);
		mainLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		
		Button b = new Button("Deeper!");
		reg.registerActiveComponent(BTN_COMPONENT_ID, b);
		layout.addComponent(b);
		
		this.cb = new CheckBox("Deny navigation.");
		layout.addComponent(this.cb);
		
		return mainLayout;
	}
	
	boolean doDeny() {
		return this.cb.getValue();
	}
}
