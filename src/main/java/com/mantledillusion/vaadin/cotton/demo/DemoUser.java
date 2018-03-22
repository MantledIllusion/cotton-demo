package com.mantledillusion.vaadin.cotton.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.mantledillusion.vaadin.cotton.User;

public class DemoUser implements User {
	
	public static final String ACCESS_RIGHT_ID = "access_view_right";

	private final String name;
	private final Set<String> rights;
	
	public DemoUser(String name, String... rights) {
		this.name = name;
		this.rights = new HashSet<String>(Arrays.asList(rights));
	}
	
	public String getName() {
		return name;
	}

	public boolean hasRights(Set<String> rightIds) {
		return this.rights.containsAll(rightIds);
	}
}
