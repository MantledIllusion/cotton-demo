package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.QueryParam;
import com.mantledillusion.vaadin.cotton.RequiredQueryParam;
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
	
	@RequiredQueryParam(value="name", valueCount=1, matcher="[A-Z][a-z]{1,9}", forced=true, defaultValues={"Visitor"})
	private QueryParam param;

	private Button b;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();
		
		this.b = new Button();
		reg.registerActiveComponent(BTN_COMPONENT_ID, this.b);
		layout.addComponent(this.b);
		layout.setComponentAlignment(this.b, Alignment.MIDDLE_CENTER);
		
		refreshBtnCaption();
		
		return layout;
	}
	
	void refreshBtnCaption() {
		this.b.setCaption("Welcome, "+this.param.getValue(0));
	}
}
