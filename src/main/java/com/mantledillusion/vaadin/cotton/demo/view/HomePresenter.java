package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Inject;
import com.mantledillusion.injection.hura.annotation.Process;
import com.mantledillusion.vaadin.cotton.demo.model.Model;
import com.mantledillusion.vaadin.cotton.demo.validators.DividableBy3Validator;
import com.mantledillusion.vaadin.cotton.demo.validators.DividableBy7Validator;
import com.mantledillusion.vaadin.cotton.demo.validators.SumOver17Validator;
import com.mantledillusion.vaadin.cotton.model.ModelContainer;
import com.mantledillusion.vaadin.cotton.model.ValidationContext;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;

public class HomePresenter extends Presenter<HomeView> {

	private static final ValidationContext<Model> VALIDATIONCONTEXT = ValidationContext.of(DividableBy3Validator.class)
			.and(DividableBy7Validator.class).and(SumOver17Validator.class).build();

	@Inject(ModelContainer.DEFAULT_SINGLETON_ID)
	private ModelContainer<Model> container;

	@Process
	private void init() {
		Model model = new Model();
		model.setDividableBy3(0);
		model.setDividableBy7(0);
		this.container.setModel(model);
	}

	@Listen(HomeView.VALIDATE_BTN_COMPONENT_ID)
	private void handleValidateClick(ClickEvent event) {
		switch (this.container.validate(VALIDATIONCONTEXT)) {
		case VALID:
			Notification.show("Valid!");
			break;
		case WARNING:
			Notification.show("Some Warnings, but Valid!");
			break;
		case ERROR:
			Notification.show("Invalid!");
			break;
		}
	}
}
