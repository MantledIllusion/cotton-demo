package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Construct;
import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.vaadin.cotton.demo.model.Model;
import com.mantledillusion.vaadin.cotton.demo.model.SubObject;
import com.mantledillusion.vaadin.cotton.model.ModelContainer;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen.ActiveComponent;
import com.vaadin.data.HasValue.ValueChangeEvent;

public class HomePresenter extends Presenter<HomeView> {

	@Inject(HomeView.CONT_SINGLETON_ID)
	private ModelContainer<Model> container;
	
	private final Model model;
	
	@Construct
	public HomePresenter() {
		this.model = new Model();
		
		SubObject subObject = new SubObject();
		this.model.setSubObject(subObject);
		
		subObject.setStringValue("foobar");
	}
	
	@Listen(@ActiveComponent(HomeView.SWITCH_CB_COMPONENT_ID))
	private void handleSwitch(ValueChangeEvent<Boolean> event) {
		this.container.setModel(event.getValue() ? this.model : null);
	}
}
