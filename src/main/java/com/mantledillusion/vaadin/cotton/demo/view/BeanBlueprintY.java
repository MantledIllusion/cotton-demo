package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.Blueprint.TypedBlueprintTemplate;

public class BeanBlueprintY implements TypedBlueprintTemplate<BeanTypeY> {

	@Override
	public Class<BeanTypeY> getRootType() {
		return BeanTypeY.class;
	}
}
