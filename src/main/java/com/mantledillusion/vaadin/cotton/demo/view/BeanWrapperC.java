package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Inject;

public class BeanWrapperC {

	final BeanTypeC wrapped;
	
	public BeanWrapperC(@Inject BeanTypeC wrapped) {
		this.wrapped = wrapped;
	}
}
