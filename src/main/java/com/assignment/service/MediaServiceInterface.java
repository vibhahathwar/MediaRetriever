package com.assignment.service;

import com.assignment.model.Videos;

/**
 * Interface
 *
 */
public interface MediaServiceInterface {

	public Videos filterMedia(String filter, String level, Videos videos);

}
