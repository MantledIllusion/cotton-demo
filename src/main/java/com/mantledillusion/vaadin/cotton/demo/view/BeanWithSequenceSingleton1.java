package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Inject;

public class BeanWithSequenceSingleton1 {

	 @Inject(SequenceSingleton.SINGLETON_ID_1)
	 SequenceSingleton sequenceSingleton1;
}
