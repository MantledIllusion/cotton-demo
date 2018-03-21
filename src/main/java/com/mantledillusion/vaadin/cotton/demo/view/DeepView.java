package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

@Addressed("CottonDemo/Deep")
public class DeepView extends View {

	private static final long serialVersionUID = 1L;

	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();
		
		Label label = new Label("That's deep.");
		layout.addComponent(label);
		layout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);
		
		return layout;
	}
}
