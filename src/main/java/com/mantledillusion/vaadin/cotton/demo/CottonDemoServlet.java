package com.mantledillusion.vaadin.cotton.demo;

import javax.servlet.annotation.WebServlet;

import com.mantledillusion.vaadin.cotton.CottonServlet;
import com.mantledillusion.vaadin.cotton.UrlResourceRegistry;
import com.mantledillusion.vaadin.cotton.demo.view.HomeView;

@WebServlet("/*")
public class CottonDemoServlet extends CottonServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected UrlResourceRegistry configure(TemporalCottonServletConfiguration config) {
		UrlResourceRegistry resourceRegistry = new UrlResourceRegistry();
		resourceRegistry.registerViewResource(HomeView.class);
		return resourceRegistry;
	}
}
