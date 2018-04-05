package com.mantledillusion.vaadin.cotton.demo.validators;

import com.mantledillusion.vaadin.cotton.demo.model.Model;
import com.mantledillusion.vaadin.cotton.demo.model.ModelProperties;
import com.mantledillusion.vaadin.cotton.model.ModelHandler;
import com.mantledillusion.vaadin.cotton.model.PreEvaluated;
import com.mantledillusion.vaadin.cotton.model.PreEvaluated.Prerequisite;
import com.mantledillusion.vaadin.cotton.model.PropertyValidator;
import com.mantledillusion.vaadin.cotton.model.ValidationErrorRegistry;

@PreEvaluated({ @Prerequisite(DividableBy3Validator.class), @Prerequisite(DividableBy7Validator.class) })
public class SumOver17Validator implements PropertyValidator<Model> {

	@Override
	public void validate(ModelHandler<Model> handler, ValidationErrorRegistry<Model> errorRegistry) {
		int sum = handler.getProperty(ModelProperties.DIVIDABLEBY3) + handler.getProperty(ModelProperties.DIVIDABLEBY7);
		if (sum < 17) {
			errorRegistry.addError("The sum of both values is " + sum + ", which is < 17!", ModelProperties.DIVIDABLEBY3,
					ModelProperties.DIVIDABLEBY7);
		}
	}
}
