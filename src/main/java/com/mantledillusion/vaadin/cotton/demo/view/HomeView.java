package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.Blueprint;
import com.mantledillusion.injection.hura.Injector;
import com.mantledillusion.injection.hura.annotation.Inject;
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
	private BeanPlaceholder placeHolder;
	
	@Inject
	private Injector injector;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setSizeFull();

		HorizontalLayout layout = new HorizontalLayout();
		mainLayout.addComponent(layout);
		mainLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		
		layout.addComponent(new Label(a.text));
		layout.addComponent(new Label(b.text));
		layout.addComponent(new Label(c.wrapped.text));
		layout.addComponent(new Label(injector.instantiate(BeanTypeD.class).text));
		layout.addComponent(new Label(injector.instantiate(Blueprint.from(new BeanBlueprintE())).text));
		layout.addComponent(new Label(placeHolder.getText()));
		
		return mainLayout;
	}
}
