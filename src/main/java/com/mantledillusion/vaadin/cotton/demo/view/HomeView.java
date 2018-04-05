package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.vaadin.cotton.component.NamingPattern;
import com.mantledillusion.vaadin.cotton.demo.model.Model;
import com.mantledillusion.vaadin.cotton.demo.model.ModelProperties;
import com.mantledillusion.vaadin.cotton.demo.validators.StringToIntegerConverter;
import com.mantledillusion.vaadin.cotton.model.ModelAccessor;
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
	
	private static final StringToIntegerConverter CONVERTER = new StringToIntegerConverter();
	static final String VALIDATE_BTN_COMPONENT_ID = "validateBtn";
	
	@Inject
	private ModelAccessor<Model> accessor;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();
		
		HorizontalLayout compLayout = new HorizontalLayout();
		compLayout.setSizeUndefined();
		layout.addComponent(compLayout);
		layout.setComponentAlignment(compLayout, Alignment.MIDDLE_CENTER);
		
		compLayout.addComponent(this.accessor.bindTextFieldForProperty(ModelProperties.DIVIDABLEBY3, CONVERTER, NamingPattern.ofCaption("Dividable by 3")));
		compLayout.addComponent(this.accessor.bindTextFieldForProperty(ModelProperties.DIVIDABLEBY7, CONVERTER, NamingPattern.ofCaption("Dividable by 7")));
		
		Button validate = new Button("Validate that sum is >= 17");
		reg.registerActiveComponent(VALIDATE_BTN_COMPONENT_ID, validate);
		compLayout.addComponent(validate);
		compLayout.setComponentAlignment(validate, Alignment.BOTTOM_LEFT);
		
		return layout;
	}
}
