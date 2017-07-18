package com.assignment.Controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.Model.Videos;
import com.assignment.Provider.ContentProvider;
import com.assignment.Service.MediaServiceInterface;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * MediaController class which handles Get request.
 * getProviderDetails() method retrieve json data from the provider.
 * filterMedia() method retrieve filtered censored and uncensored data from the MediaService class
 */
@RestController
public class MediaController {

	@Autowired
	MediaServiceInterface mediaServiceInterface;
	@Autowired
	ContentProvider contentProvider;

	Logger logger = LoggerFactory.getLogger(MediaController.class);

	@RequestMapping(value = "/media", method = RequestMethod.GET)
	public @ResponseBody Videos mediaDataRetriever(@RequestParam("filter") String filter,
			@RequestParam("level") String level) throws JsonParseException, JsonMappingException, IOException {
		logger.info("Inside Media filter controller");
		Videos contentData = contentProvider.getProviderDetails();
		contentData = mediaServiceInterface.filterMedia(filter, level, contentData);

		return contentData;
	}
}
