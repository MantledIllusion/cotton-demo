package com.mantledillusion.vaadin.cotton.demo.model;

import com.mantledillusion.data.epiphy.ModelProperty;
import com.mantledillusion.data.epiphy.ModelPropertyList;
import com.mantledillusion.data.epiphy.ReadOnlyModelProperty;

public interface ModelProperties {

	public static final ReadOnlyModelProperty<Model, Model> MODEL = ModelProperty.rootChild("model");

	public static final ModelPropertyList<Model, SubObject> SUBOBJECTLIST = MODEL.registerChildList("subObjects",
			model -> model.getSubObjects(), (model, subObjects) -> model.setSubObjects(subObjects));

	public static final ModelProperty<Model, SubObject> SUBOBJECT = SUBOBJECTLIST
			.defineElementAsChild("subObject");

	public static final ModelProperty<Model, String> STRINGVALUE = SUBOBJECT.registerChild("stringValue",
			subObject -> subObject.getStringValue(), (subObject, stringValue) -> subObject.setStringValue(stringValue));
}
