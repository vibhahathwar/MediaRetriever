package com.assignment.Service;

import com.assignment.Model.Videos;

/**
 * Inteface
 *
 */
public interface MediaServiceInterface {

	public Videos filterMedia(String filter, String level, Videos videos);

}
