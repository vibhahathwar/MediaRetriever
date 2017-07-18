package com.assignment.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;

import com.assignment.Controller.MediaController;
import com.assignment.Model.Entries;
import com.assignment.Model.Media;
import com.assignment.Model.Videos;
import com.assignment.Provider.ContentProvider;
import com.assignment.Service.MediaService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * testing MediaController
 *
 */
public class MediaControllerTest {
	@InjectMocks
	MediaController mediacontroller;

	@Mock
	private MediaService mediaService;
	@Mock
	private ContentProvider contentProvider;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("null")
	@Test
	public void mediaControllerTest() throws JsonParseException, JsonMappingException, IOException {
		Videos video = new Videos();
		List<Entries> entryList = new ArrayList<Entries>();
		List<Media> mediaList = new ArrayList<Media>();
		Media media = new Media();
		media.setGuid("123c");
		mediaList.add(media);
		Entries entry = new Entries();
		entry.setPeg$contentClassification("censored");
		entry.setMedia(mediaList);
		entryList.add(entry);
		video.setEntryCount(1l);
		video.setEntries(entryList);

		Mockito.when(contentProvider.getProviderDetails()).thenReturn(video);
		Mockito.when(mediaService.filterMedia("censoring", "censored", video)).thenReturn(video);

		Videos testVideo = mediacontroller.mediaDataRetriever("censoring", "censored");

		assertEquals("123c", testVideo.getEntries().get(0).getMedia().get(0).getGuid());

	}
}
