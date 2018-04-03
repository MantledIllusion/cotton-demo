package com.mantledillusion.vaadin.cotton.demo.model;

import com.mantledillusion.data.epiphy.DefiniteModelProperty;
import com.mantledillusion.data.epiphy.ModelProperty;

public interface ModelProperties {

	public static final DefiniteModelProperty<Model, Model> MODEL = ModelProperty.rootChild("model");
	
	public static final DefiniteModelProperty<Model, SubObject> SUBOBJECT = MODEL.registerChild("subObject",
			model -> model.getSubObject(), (model, subObject) -> model.setSubObject(subObject));
	
	public static final DefiniteModelProperty<Model, String> STRINGVALUE = SUBOBJECT.registerChild("stringValue",
			subObject -> subObject.getStringValue(), (subObject, stringValue) -> subObject.setStringValue(stringValue));
}
