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
	public void firstControllerTest() throws JsonParseException, JsonMappingException, IOException {
		Videos vd = new Videos();
		List<Entries> en = new ArrayList<Entries>();
		List<Media> me = new ArrayList<Media>();
		Media m = new Media();
		m.setGuid("123c");
		me.add(m);
		Entries e = new Entries();
		e.setPeg$contentClassification("censored");
		e.setMedia(me);
		en.add(e);
		vd.setEntryCount(1l);
		vd.setEntries(en);

		Mockito.when(contentProvider.getProviderDetails()).thenReturn(vd);
		Mockito.when(mediaService.filterMedia("censoring", "censored", vd)).thenReturn(vd);

		Videos v = mediacontroller.mediaDataRetriever("censoring", "censored");

		assertEquals("123c", v.getEntries().get(0).getMedia().get(0).getGuid());

	}
}
