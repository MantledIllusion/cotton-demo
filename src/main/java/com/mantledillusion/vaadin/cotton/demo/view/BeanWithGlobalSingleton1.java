package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Global;
import com.mantledillusion.injection.hura.annotation.Inject;

public class BeanWithGlobalSingleton1 {

	 @Global
	 @Inject(GlobalSingleton.SINGLETON_ID_1)
	 GlobalSingleton globalSingleton1;
}
