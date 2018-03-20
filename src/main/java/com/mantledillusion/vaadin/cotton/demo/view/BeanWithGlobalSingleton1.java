package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.injection.hura.annotation.Inject.SingletonMode;

public class BeanWithGlobalSingleton1 {

	 @Inject(value=GlobalSingleton.SINGLETON_ID_1, singletonMode=SingletonMode.GLOBAL)
	 GlobalSingleton globalSingleton1;
}
