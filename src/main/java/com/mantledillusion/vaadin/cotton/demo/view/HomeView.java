package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.Blueprint;
import com.mantledillusion.injection.hura.Injector;
import com.mantledillusion.injection.hura.Processor.Phase;
import com.mantledillusion.injection.hura.annotation.Adjust;
import com.mantledillusion.injection.hura.annotation.Adjust.PropertyDef;
import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.injection.hura.annotation.Process;
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

	@Inject
	private BeanTypeA a;
	@Inject
	private BeanTypeB b;
	@Inject
	private BeanWrapperC c;
	@Inject
	private BeanTypeD d;
	@Inject
	@Adjust(properties=@PropertyDef(key="bean.text", value="E"))
	private GenericBeanType e;
	
	@Inject
	private Injector injector;
	
	private HorizontalLayout layout;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setSizeFull();

		layout = new HorizontalLayout();
		mainLayout.addComponent(layout);
		mainLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		
		layout.addComponent(new Label(a.text));
		layout.addComponent(new Label(b.text));
		layout.addComponent(new Label(c.wrapped.text));
		layout.addComponent(new Label(d.getText()));
		layout.addComponent(new Label(e.text));
		
		return mainLayout;
	}
	
	@Process(Phase.FINALIZE)
	private void addLater() {
		layout.addComponent(new Label(injector.instantiate(BeanTypeX.class).text));
		layout.addComponent(new Label(injector.instantiate(Blueprint.from(new BeanBlueprintY())).text));
	}
}
