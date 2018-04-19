package com.mantledillusion.vaadin.cotton.demo.model;

import com.mantledillusion.data.epiphy.ModelProperty;
import com.mantledillusion.data.epiphy.ReadOnlyModelProperty;

public interface ModelProperties {

	public static final ReadOnlyModelProperty<Model, Model> MODEL = ModelProperty.rootChild("model");

	public static final ModelProperty<Model, Integer> DIVIDABLEBY3 = MODEL.registerChild("dividableBy3",
			model -> model.getDividableBy3(), (model, integer) -> model.setDividableBy3(integer));
	public static final ModelProperty<Model, Integer> DIVIDABLEBY7 = MODEL.registerChild("dividableBy7",
			model -> model.getDividableBy7(), (model, integer) -> model.setDividableBy7(integer));
}
