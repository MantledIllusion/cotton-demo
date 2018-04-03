package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.vaadin.cotton.demo.model.Model;
import com.mantledillusion.vaadin.cotton.demo.model.ModelProperties;
import com.mantledillusion.vaadin.cotton.model.ModelAccessor;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Component;

public class IndexedView extends View {

	private static final long serialVersionUID = 1L;

	@Inject
	private ModelAccessor<Model> accessor;
	
	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		return this.accessor.bindTextFieldForProperty(ModelProperties.STRINGVALUE);
	}
}
