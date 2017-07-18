package com.assignment.Provider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/*import java.util.Collections;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import org.springframework.web.client.RestTemplate;*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.assignment.Model.Videos;
import com.assignment.Service.MediaService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ContentProvider reads the json data from the address provided by the provider
 *
 */
@Service
public class ContentProvider {
	Logger logger = LoggerFactory.getLogger(ContentProvider.class);

	/*
	 * public static void clientService(){ HttpHeaders requestHeaders = new
	 * HttpHeaders(); requestHeaders.setAccept(Collections.singletonList(new
	 * MediaType("application","json"))); HttpEntity<?> requestEntity = new
	 * HttpEntity<Object>(requestHeaders);
	 * 
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * restTemplate.getMessageConverters().add(new
	 * MappingJackson2HttpMessageConverter()); //Videos videos =
	 * restTemplate.getForObject(
	 * "https://drive.google.com/file/d/0BxVV3wqQ8NkLNE1wX0lubWZYSWM/view",
	 * Videos.class); //System.out.println(videos.getEntryCount());
	 * 
	 * ResponseEntity<Videos> responseEntity = restTemplate.exchange(
	 * "https://drive.google.com/file/d/0BxVV3wqQ8NkLNE1wX0lubWZYSWM/view",
	 * HttpMethod.GET, requestEntity, Videos.class); Videos events =
	 * responseEntity.getBody(); }
	 * 
	 * @Override public void run(String... arg0) throws Exception {
	 * clientService();
	 * 
	 * }
	 */

	public Videos getProviderDetails() throws JsonParseException, JsonMappingException, IOException {
		Videos readJson = new Videos();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		TypeReference<Videos> typeReference = new TypeReference<Videos>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/content.json");
		try {
			readJson = objectMapper.readValue(inputStream, typeReference);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(" Exception occured ehilr reading json " + e.getMessage());
		}
		return readJson;
	}
}
