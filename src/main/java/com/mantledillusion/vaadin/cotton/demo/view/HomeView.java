package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

@Addressed(value="CottonDemo/Home", redirects={@Redirect("")})
@Presented(HomePresenter.class)
public class HomeView extends View {
	
	private static final long serialVersionUID = 1L;

	static final String BTN_COMPONENT_ID = "btn";
	
	private Button b;
	private int count = 0;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();
		
		this.b = new Button("Unpressed");
		reg.registerActiveComponent(BTN_COMPONENT_ID, this.b);
		layout.addComponent(b);
		layout.setComponentAlignment(b, Alignment.MIDDLE_CENTER);
		
		return layout;
	}
	
	void increment() {
		this.count++;
		this.b.setCaption("Pressed "+this.count+" time(s)");
	}
}
