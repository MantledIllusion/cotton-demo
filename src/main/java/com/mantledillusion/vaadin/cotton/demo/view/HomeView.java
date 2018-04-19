package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Adjust;
import com.mantledillusion.injection.hura.annotation.Adjust.MappingDef;
import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.vaadin.cotton.component.ComponentFactory;
import com.mantledillusion.vaadin.cotton.component.NamingPattern;
import com.mantledillusion.vaadin.cotton.demo.model.Model;
import com.mantledillusion.vaadin.cotton.demo.model.ModelProperties;
import com.mantledillusion.vaadin.cotton.model.ModelAccessor;
import com.mantledillusion.vaadin.cotton.model.ModelContainer;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

@Addressed(value="CottonDemo/Home", redirects={@Redirect("")})
@Presented(HomePresenter.class)
public class HomeView extends View {
	
	private static final long serialVersionUID = 1L;

	static final String CONT_SINGLETON_ID = "container";
	static final String SWITCH_CB_COMPONENT_ID = "switchCb";
	
	@Inject
	@Adjust(mappings=@MappingDef(base=ModelContainer.DEFAULT_SINGLETON_ID, target=CONT_SINGLETON_ID))
	private ModelAccessor<Model> accessor; 
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setMargin(false);
		layout.setSizeFull();
		
		TextField fieldR = this.accessor.bindTextFieldForProperty(ModelProperties.READONLY, NamingPattern.ofCaption("Field ReadOnly"));
		layout.addComponent(fieldR);
		layout.setComponentAlignment(fieldR, Alignment.MIDDLE_RIGHT);
		layout.setExpandRatio(fieldR, 1);
		
		TextField fieldA = this.accessor.bindTextFieldForProperty(ModelProperties.STRINGVALUE, NamingPattern.ofCaption("Field StringValue (A)"));
		layout.addComponent(fieldA);
		layout.setComponentAlignment(fieldA, Alignment.MIDDLE_CENTER);
		layout.setExpandRatio(fieldA, 0);
		
		TextField fieldB = this.accessor.bindTextFieldForProperty(ModelProperties.STRINGVALUE, NamingPattern.ofCaption("Field StringValue (B)"));
		layout.addComponent(fieldB);
		layout.setComponentAlignment(fieldB, Alignment.MIDDLE_CENTER);
		layout.setExpandRatio(fieldB, 0);
		
		CheckBox cb = ComponentFactory.buildCheckBox(NamingPattern.ofCaption("Switch model container placing"));
		reg.registerActiveComponent(SWITCH_CB_COMPONENT_ID, cb);
		layout.addComponent(cb);
		layout.setComponentAlignment(cb, Alignment.MIDDLE_LEFT);
		layout.setExpandRatio(cb, 1);
		
		return layout;
	}
}
