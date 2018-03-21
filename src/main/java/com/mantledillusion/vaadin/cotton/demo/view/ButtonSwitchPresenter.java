package com.mantledillusion.vaadin.cotton.demo.view;

import com.mantledillusion.injection.hura.annotation.Property;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen;
import com.mantledillusion.vaadin.cotton.viewpresenter.Listen.ActiveComponent;
import com.mantledillusion.vaadin.cotton.viewpresenter.Presenter;
import com.mantledillusion.vaadin.cotton.viewpresenter.Subscribe;
import com.vaadin.ui.Button.ClickEvent;

public class ButtonSwitchPresenter extends Presenter<ButtonSwitchView> {

	static final String ID_PROPERTY_KEY = "id";
	
	private static final class SwitchEvent extends BusEvent {
		
		public SwitchEvent(String id) {
			super(ID_PROPERTY_KEY, id);
		}
	}
	
	@Property(ID_PROPERTY_KEY)
	private String id;
	
	@Listen(@ActiveComponent(ButtonSwitchView.BTN_COMPONENT_ID))
	private void handleBtnClicked(ClickEvent event) {
		dispatch(new SwitchEvent(this.id));
	}
	
	@Subscribe(isSelfObservant=false)
	private void handleSwitchEvent(SwitchEvent event) {
		if (event.equalProperty(ID_PROPERTY_KEY, this.id)) {
			getView().setEnabled(!getView().isEnabled());
		}
	}
}
