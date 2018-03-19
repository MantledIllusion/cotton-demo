package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.BeanAllocation;
import com.mantledillusion.injection.hura.Blueprint.TypedBlueprintTemplate;
import com.mantledillusion.injection.hura.annotation.Define;

public class HomeViewBlueprint implements TypedBlueprintTemplate<HomeView> {

	@Override
	public Class<HomeView> getRootType() {
		return HomeView.class;
	}

	@Define
	private BeanAllocation<BeanPlaceholder> define() {
		return BeanAllocation.allocateToType(BeanTypeF.class);
	}
}
