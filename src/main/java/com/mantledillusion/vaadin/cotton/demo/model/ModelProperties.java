package com.mantledillusion.vaadin.cotton.demo.model;

import com.mantledillusion.data.epiphy.ModelProperty;
import com.mantledillusion.data.epiphy.ReadOnlyModelProperty;

public interface ModelProperties {

	public static final ReadOnlyModelProperty<Model, Model> MODEL = ModelProperty.rootChild("model");

	public static final ReadOnlyModelProperty<Model, String> READONLY = MODEL.registerChild("readOnly",
			model -> model.getReadOnly());

	public static final ModelProperty<Model, SubObject> SUBOBJECT = MODEL.registerChild("subObject",
			model -> model.getSubObject(), (model, subObject) -> model.setSubObject(subObject));

	public static final ModelProperty<Model, String> STRINGVALUE = SUBOBJECT.registerChild("stringValue",
			subObject -> subObject.getStringValue(), (subObject, stringValue) -> subObject.setStringValue(stringValue));
}
