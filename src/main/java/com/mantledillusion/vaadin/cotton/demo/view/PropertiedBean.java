package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Property;

public class PropertiedBean {
	
	public static final String PROPERTY_KEY = "property.key";

	@Property(value=PROPERTY_KEY, matcher="\\D+", useDefault=true, defaultValue="default value")
	public String property;
}
