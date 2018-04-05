package com.mantledillusion.vaadin.cotton.demo.validators;

import com.mantledillusion.vaadin.cotton.demo.model.Model;
import com.mantledillusion.vaadin.cotton.demo.model.ModelProperties;
import com.mantledillusion.vaadin.cotton.model.ModelHandler;
import com.mantledillusion.vaadin.cotton.model.PropertyValidator;
import com.mantledillusion.vaadin.cotton.model.ValidationErrorRegistry;

public class DividableBy3Validator implements PropertyValidator<Model> {

	@Override
	public void validate(ModelHandler<Model> handler, ValidationErrorRegistry<Model> errorRegistry) {
		if (handler.getProperty(ModelProperties.DIVIDABLEBY3) % 3 != 0) {
			errorRegistry.addError("The value is not dividable by 3", ModelProperties.DIVIDABLEBY3);
		}
	}
}
