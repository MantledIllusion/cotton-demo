package com.mantledillusion.vaadin.cotton.demo.model;

public class Model {

	private final String readOnly;
	private SubObject subObject;

	public Model(String readOnly) {
		this.readOnly = readOnly;
	}

	public SubObject getSubObject() {
		return subObject;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setSubObject(SubObject subObject) {
		this.subObject = subObject;
	}
}
