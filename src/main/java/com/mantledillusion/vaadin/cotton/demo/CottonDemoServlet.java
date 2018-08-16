package com.mantledillusion.vaadin.cotton.demo;

import javax.servlet.annotation.WebServlet;

import com.mantledillusion.injection.hura.Blueprint;
import com.mantledillusion.vaadin.cotton.CottonServlet;
import com.mantledillusion.vaadin.cotton.demo.view.HomeViewBlueprint;

@WebServlet("/*")
public class CottonDemoServlet extends CottonServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void configure(TemporalCottonServletConfiguration config) {
		config.registerViewResource(Blueprint.from(new HomeViewBlueprint()));
	}
}
