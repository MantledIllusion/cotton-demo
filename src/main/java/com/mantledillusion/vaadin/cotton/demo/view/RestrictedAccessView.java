package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.demo.DemoUser;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.mantledillusion.vaadin.cotton.viewpresenter.Restricted;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

@Addressed(value="CottonDemo/RestrictedAccess")
@Restricted({DemoUser.ACCESS_RIGHT_ID})
@Presented(RestrictedAccessPresenter.class)
public class RestrictedAccessView extends AbstractUserView {

	private static final long serialVersionUID = 1L;
	
	static final String BTN_COMPONENT_ID = "btn";

	@Override
	protected Component buildContent(TemporalActiveComponentRegistry reg) throws Throwable {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		
		Button b = new Button("Logout");
		reg.registerActiveComponent(BTN_COMPONENT_ID, b);
		layout.addComponent(b);
		layout.setComponentAlignment(b, Alignment.MIDDLE_CENTER);
		
		return layout;
	}
}
