package com.mantledillusion.vaadin.cotton.demo.validators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mantledillusion.vaadin.cotton.model.Converter;
import com.mantledillusion.vaadin.cotton.model.ValidationError;
import com.vaadin.shared.ui.ErrorLevel;

public class StringToIntegerConverter implements Converter<String, Integer> {

	private static final String NULL = "null";
	private static final String NUMBER_REGEX = "\\d+";
	
	@Override
	public String toField(Integer value) {
		return value == null ? null : String.valueOf(value);
	}

	@Override
	public Integer toProperty(String value) {
		return value == null ? null : (value.equals(NULL) ? 0 : Integer.parseInt(value));
	}

	@Override
	public Collection<ValidationError> validateInput(String value) {
		List<ValidationError> errors = new ArrayList<>();
		if (value != null) {
			if (value.matches(NUMBER_REGEX)) {
				Long val = Long.parseLong(value);
				if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
					errors.add(ValidationError.of("Number is to big for an Integer"));
				}
			} else if (value.equals(NULL)) {
				errors.add(ValidationError.of("Numbers should be written numerically.", ErrorLevel.WARNING));
			} else {
				errors.add(ValidationError.of("The given value is no parsable number."));
			}
		}
		return errors;
	}
}
