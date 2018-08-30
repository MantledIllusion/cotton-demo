package com.mantledillusion.vaadin.cotton.demo.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mantledillusion.data.epiphy.index.PropertyIndex;
import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.injection.hura.annotation.Process;
import com.mantledillusion.vaadin.cotton.demo.model.Address;
import com.mantledillusion.vaadin.cotton.demo.model.Contact;
import com.mantledillusion.vaadin.cotton.demo.model.ModelProperties;
import com.mantledillusion.vaadin.cotton.demo.model.Person;
import com.mantledillusion.vaadin.cotton.model.BindableGrid.BindableGridSelectionEvent;
import com.mantledillusion.vaadin.cotton.model.IndexContext;
import com.mantledillusion.vaadin.cotton.model.ModelContainer;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.vaadin.ui.Button.ClickEvent;

public class HomePresenter extends Presenter<HomeView> {

	private static final String[] EXCHANGE_MIDDLE_NAMES = {"\"Voldekiller\"", "\"Seeker\"", "\"Redhead-Fan\"", "\"Dumble-Darling\"", "\"Undesireable#1\""};
	
	private static Contact createNew() {
		Contact hp = new Contact();
		
		Person hp_p = new Person();
		hp.setPerson(hp_p);
		hp_p.setForename("Harry");
		hp_p.setMiddlename("James");
		hp_p.setSurname("Potter");
		
		Address hp_a = new Address();
		hp.setAddress(hp_a);
		hp_a.setStreet("Privet Drive");
		hp_a.setHousenr("4");
		hp_a.setCity("Little Whinging");
		
		return hp;
	}
	
	@Inject(ModelContainer.DEFAULT_SINGLETON_ID)
	private ModelContainer<List<Contact>> container;
	
	@Process
	private void init() {
		this.container.setModel(new ArrayList<>(Arrays.asList(createNew())));
		getView().refreshBtnEnablement();
	}
	
	@Listen(HomeView.GRID_COMPONENT_ID)
	private void handleItemSelected(BindableGridSelectionEvent<Contact> event) {
		getView().refreshBtnEnablement();
	}
	
	@Listen(HomeView.ADD_BTN_COMPONENT_ID)
	private void handleAddBtnClicked(ClickEvent event) {
		this.container.addProperty(ModelProperties.CONTACT_LIST, createNew());
	}
	
	@Listen(HomeView.RENAME_BTN_COMPONENT_ID)
	private void handleRenameBtnClicked(ClickEvent event) {
		String middlename = EXCHANGE_MIDDLE_NAMES[(int) Math.round(Math.random()*(EXCHANGE_MIDDLE_NAMES.length-1))];
		this.container.setProperty(ModelProperties.MIDDLENAME, middlename, getSelectedIdxContext());
	}
	
	@Listen(HomeView.DELETE_BTN_COMPONENT_ID)
	private void handleDeleteBtnClicked(ClickEvent event) {
		this.container.removeProperty(ModelProperties.CONTACT_LIST, getSelectedIdxContext());
	}
	
	private IndexContext getSelectedIdxContext() {
		return IndexContext.of(PropertyIndex.of(ModelProperties.CONTACT_LIST, getView().getSelectedIndex()));
	}
}
