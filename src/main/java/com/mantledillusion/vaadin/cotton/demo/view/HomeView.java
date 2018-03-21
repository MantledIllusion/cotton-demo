package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.QueryParam;
import com.mantledillusion.vaadin.cotton.RequiredQueryParam;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

@Addressed(value="CottonDemo/Home", redirects={@Redirect("")})
public class HomeView extends View {
	
	private static final long serialVersionUID = 1L;
	
	@RequiredQueryParam(value="name", valueCount=1, matcher="\\D{2,10}", forced=true, defaultValues={"Visitor"})
	private QueryParam param;

	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();
		
		Label label = new Label("Welcome, "+this.param.getValue(0));
		layout.addComponent(label);
		layout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
		
		return layout;
	}
}
