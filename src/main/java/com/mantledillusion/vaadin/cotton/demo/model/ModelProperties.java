package com.mantledillusion.vaadin.cotton.demo.model;

import com.mantledillusion.data.epiphy.DefiniteModelProperty;
import com.mantledillusion.data.epiphy.ModelProperty;

public interface ModelProperties {

	public static final DefiniteModelProperty<Model, Model> MODEL = ModelProperty.rootChild("model");

	public static final DefiniteModelProperty<Model, Integer> DIVIDABLEBY3 = MODEL.registerChild("dividableBy3",
			model -> model.getDividableBy3(), (model, integer) -> model.setDividableBy3(integer));
	public static final DefiniteModelProperty<Model, Integer> DIVIDABLEBY7 = MODEL.registerChild("dividableBy7",
			model -> model.getDividableBy7(), (model, integer) -> model.setDividableBy7(integer));
}
