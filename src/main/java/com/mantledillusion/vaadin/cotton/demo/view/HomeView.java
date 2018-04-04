package com.mantledillusion.vaadin.cotton.demo.view;

import java.util.List;

import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.vaadin.cotton.component.SizingPattern;
import com.mantledillusion.vaadin.cotton.demo.model.Contact;
import com.mantledillusion.vaadin.cotton.demo.model.ModelProperties;
import com.mantledillusion.vaadin.cotton.model.BindableGrid;
import com.mantledillusion.vaadin.cotton.model.ModelAccessor;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@Addressed(value="CottonDemo/Home", redirects={@Redirect("")})
@Presented(HomePresenter.class)
public class HomeView extends View {
	
	private static final long serialVersionUID = 1L;

	static final String GRID_COMPONENT_ID = "grid";
	static final String ADD_BTN_COMPONENT_ID = "add";
	static final String RENAME_BTN_COMPONENT_ID = "rename";
	static final String DELETE_BTN_COMPONENT_ID = "delete";
	
	@Inject
	private ModelAccessor<List<Contact>> accessor;
	
	private BindableGrid<Contact, List<Contact>> grid;
	private Button add;
	private Button rename;
	private Button delete;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setSizeFull();
		
		VerticalLayout gridLayout = new VerticalLayout();
		gridLayout.setSizeUndefined();
		layout.addComponent(gridLayout);
		layout.setComponentAlignment(gridLayout, Alignment.MIDDLE_CENTER);
		
		this.grid = this.accessor.bindGridForProperty(ModelProperties.CONTACT_LIST, SizingPattern.ofExactSize(800, 250));
		this.grid.addColumn(ModelProperties.FORENAME);
		this.grid.addColumn(ModelProperties.MIDDLENAME);
		this.grid.addColumn(ModelProperties.SURNAME);
		this.grid.addColumn(ModelProperties.STREET);
		this.grid.addColumn(ModelProperties.HOUSENR);
		this.grid.addColumn(ModelProperties.CITY);
		reg.registerActiveComponent(GRID_COMPONENT_ID, this.grid);
		gridLayout.addComponent(this.grid);
		
		HorizontalLayout btnLayout = new HorizontalLayout();
		btnLayout.setSizeUndefined();
		gridLayout.addComponent(btnLayout);
		
		this.add = new Button("Add random");
		reg.registerActiveComponent(ADD_BTN_COMPONENT_ID, this.add);
		btnLayout.addComponent(this.add);
		
		this.rename = new Button("Rename selected");
		reg.registerActiveComponent(RENAME_BTN_COMPONENT_ID, this.rename);
		btnLayout.addComponent(this.rename);
		
		this.delete = new Button("Delete selected");
		reg.registerActiveComponent(DELETE_BTN_COMPONENT_ID, this.delete);
		btnLayout.addComponent(this.delete);
		
		return layout;
	}
	
	int getSelectedIndex() {
		return this.grid.getSelectedIndex();
	}
	
	void refreshBtnEnablement() {
		this.rename.setEnabled(this.grid.getSelectedIndex() != null);
		this.delete.setEnabled(this.grid.getSelectedIndex() != null);
	}
}
