package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.Blueprint.TypedBlueprintTemplate;

public class BeanBlueprintE implements TypedBlueprintTemplate<BeanTypeE> {

	@Override
	public Class<BeanTypeE> getRootType() {
		return BeanTypeE.class;
	}
}
