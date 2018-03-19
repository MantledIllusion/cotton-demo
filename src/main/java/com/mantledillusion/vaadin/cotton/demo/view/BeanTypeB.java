package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Construct;

public class BeanTypeB {

	final String text;
	
	@Construct
	private BeanTypeB() {
		this.text = "B";
	}
}
