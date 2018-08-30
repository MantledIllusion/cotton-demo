package com.mantledillusion.vaadin.cotton.demo;

import java.nio.charset.Charset;
import java.util.Locale;

import javax.servlet.annotation.WebServlet;

import com.mantledillusion.vaadin.cotton.CottonServlet;
import com.mantledillusion.vaadin.cotton.demo.view.HomeView;

@WebServlet("/*")
public class CottonDemoServlet extends CottonServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void configure(TemporalCottonServletConfiguration config) {
		config.registerViewResource(HomeView.class);
		config.registerLocalization("text", "properties", Charset.forName("UTF-8"), Locale.ENGLISH);
	}
}
