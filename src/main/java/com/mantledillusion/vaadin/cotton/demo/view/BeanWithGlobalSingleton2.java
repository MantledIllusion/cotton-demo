package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Global;
import com.mantledillusion.injection.hura.annotation.Inject;

public class BeanWithGlobalSingleton2 {

	@Global
	@Inject(GlobalSingleton.SINGLETON_ID_2)
	GlobalSingleton globalSingleton2;
}