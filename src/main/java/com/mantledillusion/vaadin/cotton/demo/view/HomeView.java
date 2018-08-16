package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.Blueprint;
import com.mantledillusion.injection.hura.Injector;
import com.mantledillusion.injection.hura.Predefinable.Singleton;
import com.mantledillusion.injection.hura.Processor.Phase;
import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.injection.hura.annotation.Process;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@Addressed(value = "CottonDemo/Home", redirects = { @Redirect("") })
public class HomeView extends View {

	private static final long serialVersionUID = 1L;

	@Inject(SequenceSingleton.SINGLETON_ID_1)
	private SequenceSingleton sequenceSingleton;
	@Inject
	private BeanWithSequenceSingleton1 bean;

	@Inject
	private Injector injector;
	
	private VerticalLayout layout;

	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout mainLayout = new HorizontalLayout();
		mainLayout.setSizeFull();

		layout = new VerticalLayout();
		mainLayout.addComponent(layout);
		mainLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		
		return mainLayout;
	}
	
	@Process(Phase.FINALIZE)
	private void fillUI() {
		layout.addComponent(
				new Label("Sequence singleton1 # in this view: " + System.identityHashCode(sequenceSingleton)
						+ "; Sequence singleton1 # in sub bean: " + System.identityHashCode(bean.sequenceSingleton1)));

		BeanWithSequenceSingleton1and2 a = this.injector.instantiate(BeanWithSequenceSingleton1and2.class);
		BeanWithSequenceSingleton1and2 b = this.injector.instantiate(BeanWithSequenceSingleton1and2.class);
		layout.addComponent(new Label(
				"Sequence singleton1 # in manually injected bean a: " + System.identityHashCode(a.sequenceSingleton1)
						+ "; Sequence singleton1 # in manually injected bean b: "
						+ System.identityHashCode(b.sequenceSingleton1)));
		layout.addComponent(new Label(
				"Sequence singleton2 # in manually injected bean a: " + System.identityHashCode(a.sequenceSingleton2)
						+ "; Sequence singleton2 # in manually injected bean b: "
						+ System.identityHashCode(b.sequenceSingleton2)));

		SequenceSingleton singleton = new SequenceSingleton();
		a = this.injector.instantiate(Blueprint.of(BeanWithSequenceSingleton1and2.class,
				Singleton.of(SequenceSingleton.SINGLETON_ID_2, singleton)));
		b = this.injector.instantiate(Blueprint.of(BeanWithSequenceSingleton1and2.class,
				Singleton.of(SequenceSingleton.SINGLETON_ID_2, singleton)));
		layout.addComponent(new Label("The manually created singleton # is: " + System.identityHashCode(singleton)));
		layout.addComponent(new Label(
				"Sequence singleton2 # in manually injected bean a2: " + System.identityHashCode(a.sequenceSingleton2)
						+ "; Sequence singleton2 # in manually injected bean b2: "
						+ System.identityHashCode(b.sequenceSingleton2)));

		BeanWithGlobalSingleton1 c = this.injector.instantiate(BeanWithGlobalSingleton1.class);
		BeanWithGlobalSingleton1 d = this.injector.instantiate(BeanWithGlobalSingleton1.class);
		layout.addComponent(new Label(
				"Global singleton1 # in manually injected bean c: " + System.identityHashCode(c.globalSingleton1)
						+ "; Global singleton1 # in manually injected bean d: "
						+ System.identityHashCode(d.globalSingleton1)));

		BeanWithGlobalSingleton2 e = this.injector.instantiate(BeanWithGlobalSingleton2.class);
		layout.addComponent(new Label("The predefined Global singleton has the id '"+e.globalSingleton2.id+"'"));
	}
}
