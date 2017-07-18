package com.assignment.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.assignment.Model.Entries;

/**
 * Videos POJO contains both entry and media
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Videos {

	public Videos() {

	}

	public Videos(List<Entries> entries, Long entryCount) {
		super();
		this.entries = entries;
		this.entryCount = entryCount;
	}

	public List<Entries> entries;
	public Long entryCount;

	public List<Entries> getEntries() {
		return entries;
	}

	public void setEntries(List<Entries> entries) {
		this.entries = entries;
	}

	public Long getEntryCount() {
		return entryCount;
	}

	public void setEntryCount(Long entryCount) {
		this.entryCount = entryCount;
	}

	@Override
	public String toString() {
		return "Videos [entries=" + entries + ", entryCount=" + entryCount + "]";
	}

}
