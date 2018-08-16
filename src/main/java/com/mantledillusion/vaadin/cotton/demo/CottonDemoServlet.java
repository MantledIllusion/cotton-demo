package com.mantledillusion.vaadin.cotton.demo;

import javax.servlet.annotation.WebServlet;

import com.mantledillusion.injection.hura.Predefinable.Property;
import com.mantledillusion.vaadin.cotton.CottonServlet;
import com.mantledillusion.vaadin.cotton.demo.view.HomeView;
import com.mantledillusion.vaadin.cotton.demo.view.PropertiedBean;

@WebServlet("/*")
public class CottonDemoServlet extends CottonServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void configure(TemporalCottonServletConfiguration config) {
		config.registerPredefinables(Property.of(PropertiedBean.PROPERTY_KEY, "predefined value"));
		config.registerViewResource(HomeView.class);
	}
}
