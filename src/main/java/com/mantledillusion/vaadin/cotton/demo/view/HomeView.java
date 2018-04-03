package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.data.epiphy.index.PropertyIndex;
import com.mantledillusion.injection.hura.Injector;
import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.vaadin.cotton.component.ComponentFactory;
import com.mantledillusion.vaadin.cotton.component.SizingPattern;
import com.mantledillusion.vaadin.cotton.demo.model.ModelProperties;
import com.mantledillusion.vaadin.cotton.model.IndexContext;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presented;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.VerticalLayout;

@Addressed(value = "CottonDemo/Home", redirects = { @Redirect("") })
@Presented(HomePresenter.class)
public class HomeView extends View {

	private static final long serialVersionUID = 1L;

	static final String INDEX_SELECT_COMPONENT_ID = "indexSelect";

	@Inject
	private Injector injector;

	private Panel indexPanel;
	private IndexedView current;

	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();

		RadioButtonGroup<Integer> buttonGroup = ComponentFactory.buildRadioButtonGroup();
		buttonGroup.setItems(0, 1);
		reg.registerActiveComponent(INDEX_SELECT_COMPONENT_ID, buttonGroup);
		layout.addComponent(buttonGroup);
		layout.setComponentAlignment(buttonGroup, Alignment.BOTTOM_CENTER);

		this.indexPanel = ComponentFactory.buildPanel(SizingPattern.ofUndefinedSize());
		layout.addComponent(this.indexPanel);
		layout.setComponentAlignment(this.indexPanel, Alignment.TOP_CENTER);
		
		return layout;
	}

	void showForIndex(int i) {
		if (this.current != null) {
			this.injector.destroy(this.current);
		}
		this.current = this.injector.instantiate(IndexedView.class,
				IndexContext.of(PropertyIndex.of(ModelProperties.SUBOBJECTLIST, i)).asSingleton());
		this.indexPanel.setContent(this.current);
	}
}
