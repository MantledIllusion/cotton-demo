package com.mantledillusion.vaadin.cotton.demo;

import javax.servlet.annotation.WebServlet;

import com.mantledillusion.injection.hura.Blueprint;
import com.mantledillusion.vaadin.cotton.CottonServlet;
import com.mantledillusion.vaadin.cotton.UrlResourceRegistry;
import com.mantledillusion.vaadin.cotton.demo.view.HomeView;
import com.mantledillusion.vaadin.cotton.demo.view.LoginMask;
import com.mantledillusion.vaadin.cotton.demo.view.RestrictedAccessView;

@WebServlet("/*")
public class CottonDemoServlet extends CottonServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected UrlResourceRegistry configure(TemporalCottonServletConfiguration config) {
		config.registerLoginView(Blueprint.of(LoginMask.class));
		
		UrlResourceRegistry resourceRegistry = new UrlResourceRegistry();
		resourceRegistry.registerViewResource(HomeView.class);
		resourceRegistry.registerViewResource(RestrictedAccessView.class);
		return resourceRegistry;
	}
}
