package com.assignment.model;

import java.util.List;

import com.assignment.model.Media;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * POJO class for entry elements in the json
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entries {

	public Entries() {

	}

	public Entries(List<Media> media, String peg$contentClassification, String title) {
		super();
		this.media = media;
		this.peg$contentClassification = peg$contentClassification;
		this.title = title;
	}

	public List<Media> media;
	public String peg$contentClassification;
	public String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public String getPeg$contentClassification() {
		return peg$contentClassification;
	}

	public void setPeg$contentClassification(String peg$contentClassification) {
		this.peg$contentClassification = peg$contentClassification;
	}

	@Override
	public String toString() {
		return "Entries [media=" + media + ", peg$contentClassification=" + peg$contentClassification + ", title="
				+ title + "]";
	}

}
