package com.assignment.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.model.Videos;

/**
 * ContentProvider reads the json data from the address provided by the provider
 *
 */
@Service
public class ContentProvider {
	
	@Autowired
	RestTemplate restTemplate;
	Logger logger = LoggerFactory.getLogger(ContentProvider.class);

	public Videos getProviderDetails() {
		String url = "http://feed.entertainment.tv.theplatform.eu/f/hGKjSC/peg_dev_dynamic2_testing/42759720403,29216808163,24706088272,33829928299";
		logger.info("inside get provider details method");
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		Videos videos = restTemplate.getForObject(
				url,
				Videos.class);;
		return videos;
	}

}
