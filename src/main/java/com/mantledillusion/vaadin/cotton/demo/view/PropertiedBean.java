package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.DefaultValue;
import com.mantledillusion.injection.hura.annotation.Matches;
import com.mantledillusion.injection.hura.annotation.Property;

public class PropertiedBean {
	
	public static final String PROPERTY_KEY = "property.key";

	@Property(PROPERTY_KEY)
	@Matches("\\D+")
	@DefaultValue("default value")
	public String property;
}
