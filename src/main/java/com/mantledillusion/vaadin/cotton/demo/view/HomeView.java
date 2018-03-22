package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.vaadin.cotton.component.NamingPattern;
import com.mantledillusion.vaadin.cotton.WebEnv;
import com.mantledillusion.vaadin.cotton.component.ComponentFactory;
import com.mantledillusion.vaadin.cotton.component.PresetPattern;
import com.mantledillusion.vaadin.cotton.component.SizingPattern;
import com.mantledillusion.vaadin.cotton.component.StylingPattern;
import com.mantledillusion.vaadin.cotton.component.ComponentFactory.OptionPattern;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed;
import com.mantledillusion.vaadin.cotton.viewpresenter.Addressed.Redirect;
import com.mantledillusion.vaadin.cotton.viewpresenter.View;
import com.vaadin.server.ClassResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

@Addressed(value = "CottonDemo/Home", redirects = { @Redirect("") })
public class HomeView extends View {

	private static final long serialVersionUID = 1L;
	
	private static final Resource VAADIN_LOGO = new ClassResource("/vaadin_logo.png");
	
	private static final OptionPattern<TextField> TEXTFIELD_PATTERN = OptionPattern.of(
			SizingPattern.withExactWidth(200).andExactHeight(30).build(),
			PresetPattern.forTextField().withMaxLength(10).withPlaceholder("textfield.placeholder").build(),
			NamingPattern.withCaption("textfield.caption.factorized", true).andDescription("textfield.description").build(),
			StylingPattern.withIcon(VAADIN_LOGO).andStyle(ValoTheme.TEXTFIELD_BORDERLESS).build());

	@Override
	protected Component buildUI(TemporalActiveComponentRegistry reg) throws Throwable {
		HorizontalLayout layout = ComponentFactory.buildHorizontalLayout(SizingPattern.ofFullSize(),
				PresetPattern.forOrderedLayout().withAllGaps());
		
		// Manual
		TextField manualTextField = new TextField(WebEnv.localize("textfield.caption.manual"));
		manualTextField.setWidth(200, Unit.PIXELS);
		manualTextField.setHeight(30, Unit.PIXELS);
		manualTextField.setMaxLength(10);
		manualTextField.setPlaceholder(WebEnv.localize("textfield.placeholder"));
		manualTextField.setDescription(WebEnv.localize("textfield.description"));
		manualTextField.setCaptionAsHtml(true);
		manualTextField.setIcon(VAADIN_LOGO);
		manualTextField.addStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

		layout.addComponent(manualTextField);
		layout.setComponentAlignment(manualTextField, Alignment.MIDDLE_CENTER);
		
		// Factorized
		TextField factorizedTextfield = ComponentFactory.buildTextField(TEXTFIELD_PATTERN);
		
		layout.addComponent(factorizedTextfield);
		layout.setComponentAlignment(factorizedTextfield, Alignment.MIDDLE_CENTER);

		return layout;
	}
}
