package com.assignment.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;

import com.assignment.model.Entries;
import com.assignment.model.Media;
import com.assignment.model.Videos;
import com.assignment.service.MediaService;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * MediaService Test
 *
 */
public class MediaServiceTest {
	
	@InjectMocks
	public MediaService mediaService;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void filterMediaTest(){
	Videos video = new Videos();
	List<Entries> entryList = new ArrayList<Entries>();
	List<Media> mediaList = new ArrayList<Media>();
	Media media = new Media();
	Entries entry = new Entries();
	media.setGuid("1234C");
	mediaList.add(media);
	entry.setPeg$contentClassification("censored");
	entry.setMedia(mediaList);
	entryList.add(entry);
	video.setEntries(entryList);
	video.setEntryCount(1l);
	
	Videos testvideo = mediaService.filterMedia("censoring","censored",video);
	assertThat(testvideo.toString(),is("Videos [entries=[Entries [media=[Media [guid=1234C, id=null]], peg$contentClassification=censored, title=null]], entryCount=1]"));
	
	
	
	
	}
}
