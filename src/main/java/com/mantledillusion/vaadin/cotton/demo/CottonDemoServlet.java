package com.mantledillusion.vaadin.cotton.demo;

import javax.servlet.annotation.WebServlet;

import com.mantledillusion.vaadin.cotton.CottonServlet;
import com.mantledillusion.vaadin.cotton.LoginProvider;
import com.mantledillusion.vaadin.cotton.demo.view.HomeView;
import com.mantledillusion.vaadin.cotton.demo.view.LoginMask;
import com.mantledillusion.vaadin.cotton.demo.view.RestrictedAccessView;

@WebServlet("/*")
public class CottonDemoServlet extends CottonServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void configure(TemporalCottonServletConfiguration config) {
		config.registerViewResource(HomeView.class);
		config.registerViewResource(RestrictedAccessView.class);
		config.registerLoginProvider(LoginProvider.byView(LoginMask.class));
	}
}
