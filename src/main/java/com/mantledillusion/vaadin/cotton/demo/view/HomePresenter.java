package com.mantledillusion.vaadin.cotton.demo.view;

import java.util.ArrayList;

import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.injection.hura.annotation.Process;
import com.mantledillusion.vaadin.cotton.demo.model.Model;
import com.mantledillusion.vaadin.cotton.demo.model.SubObject;
import com.mantledillusion.vaadin.cotton.model.ModelContainer;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.vaadin.data.HasValue.ValueChangeEvent;

public class HomePresenter extends Presenter<HomeView> {

	@Inject(ModelContainer.DEFAULT_SINGLETON_ID)
	private ModelContainer<Model> container;
	
	@Process
	private void init() {
		Model model = new Model();
		model.setSubObjects(new ArrayList<>());
		
		SubObject zero = new SubObject();
		zero.setStringValue("zero");
		model.getSubObjects().add(zero);

		SubObject one = new SubObject();
		one.setStringValue("one");
		model.getSubObjects().add(one);
		
		this.container.setModel(model);
	}
	
	@Listen(HomeView.INDEX_SELECT_COMPONENT_ID)
	private void handleIndexClicked(ValueChangeEvent<Integer> event) {
		getView().showForIndex(event.getValue());
	}
}
