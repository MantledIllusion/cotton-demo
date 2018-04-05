package com.mantledillusion.vaadin.cotton.demo.validators;

import com.mantledillusion.vaadin.cotton.demo.model.Model;
import com.mantledillusion.vaadin.cotton.demo.model.ModelProperties;
import com.mantledillusion.vaadin.cotton.model.ModelHandler;
import com.mantledillusion.vaadin.cotton.model.PropertyValidator;
import com.mantledillusion.vaadin.cotton.model.ValidationErrorRegistry;

public class DividableBy7Validator implements PropertyValidator<Model> {

	@Override
	public void validate(ModelHandler<Model> handler, ValidationErrorRegistry<Model> errorRegistry) {
		if (handler.getProperty(ModelProperties.DIVIDABLEBY7) % 7 != 0) {
			errorRegistry.addError("The value is not dividable by 7", ModelProperties.DIVIDABLEBY7);
		}
	}
}
