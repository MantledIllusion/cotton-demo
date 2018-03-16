package com.mantledillusion.vaadin.cotton.demo;

import javax.servlet.annotation.WebServlet;

import com.mantledillusion.vaadin.cotton.CottonSessionInitInterceptor;
import com.mantledillusion.vaadin.cotton.demo.CottonDemoUI;
import com.vaadin.server.DeploymentConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.VaadinServletService;
import com.vaadin.spring.server.SpringVaadinServlet;

@WebServlet(value = "/CottonDemo/*", asyncSupported = true)
public class CottonDemoServlet extends SpringVaadinServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected VaadinServletService createServletService(DeploymentConfiguration deploymentConfiguration)
			throws ServiceException {
		VaadinServletService serv = super.createServletService(deploymentConfiguration);
		serv.addSessionInitListener(new CottonSessionInitInterceptor(CottonDemoUI.class));
		return serv;
	}
}
