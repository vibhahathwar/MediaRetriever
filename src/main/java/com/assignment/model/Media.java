package com.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO class for Media element in the json String
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Media {

	public Media() {

	}

	public Media(String guid, String id) {
		super();
		this.guid = guid;
		this.id = id;
	}

	public String guid;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	@Override
	public String toString() {
		return "Media [guid=" + guid + ", id=" + id + "]";
	}

}
