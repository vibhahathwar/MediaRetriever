package com.assignment.Provider;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.assignment.Model.Videos;

/**
 * ContentProvider reads the json data from the address provided by the provider
 *
 */
@Service
public class ContentProvider {
	Logger logger = LoggerFactory.getLogger(ContentProvider.class);

	public Videos getProviderDetails() {
		logger.info("inside get provider details method");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		Videos videos = restTemplate.getForObject(
				"http://feed.entertainment.tv.theplatform.eu/f/hGKjSC/peg_dev_dynamic2_testing/42759720403,29216808163,24706088272,33829928299",
				Videos.class);;
		return videos;
	}

}
