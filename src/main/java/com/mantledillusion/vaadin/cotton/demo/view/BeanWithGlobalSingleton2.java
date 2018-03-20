package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.injection.hura.annotation.Inject.SingletonMode;

public class BeanWithGlobalSingleton2 {

	 @Inject(value=GlobalSingleton.SINGLETON_ID_2, singletonMode=SingletonMode.GLOBAL)
	 GlobalSingleton globalSingleton2;
}