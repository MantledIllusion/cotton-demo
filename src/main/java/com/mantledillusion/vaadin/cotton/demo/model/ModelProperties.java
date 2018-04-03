package com.mantledillusion.vaadin.cotton.demo.model;

import com.mantledillusion.data.epiphy.DefiniteModelProperty;
import com.mantledillusion.data.epiphy.ModelProperty;
import com.mantledillusion.data.epiphy.ModelPropertyList;

public interface ModelProperties {

	public static final DefiniteModelProperty<Model, Model> MODEL = ModelProperty.rootChild("model");

	public static final ModelPropertyList<Model, SubObject> SUBOBJECTLIST = MODEL.registerChildList("subObjects",
			model -> model.getSubObjects(), (model, subObjects) -> model.setSubObjects(subObjects));

	public static final DefiniteModelProperty<Model, SubObject> SUBOBJECT = SUBOBJECTLIST
			.defineElementAsChild("subObject");

	public static final DefiniteModelProperty<Model, String> STRINGVALUE = SUBOBJECT.registerChild("stringValue",
			subObject -> subObject.getStringValue(), (subObject, stringValue) -> subObject.setStringValue(stringValue));
}
