package com.assignment.test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.assignment.Model.Entries;
import com.assignment.Model.Media;
import com.assignment.Model.Videos;
import com.assignment.Service.MediaService;
import com.assignment.App;
import static org.hamcrest.CoreMatchers.*;

/**
 * Integartion test for the application
 *
 */
@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class IntegrationTest {

	@Autowired
	MediaService mediaService;

	@Test
	public void EntryCountTest() {

		Videos video = new Videos();
		List<Entries> entryList = new ArrayList<Entries>();
		List<Media> mediaList = new ArrayList<Media>();
		Media media = new Media();
		Entries entry = new Entries();
		media.setGuid("123C");
		media.setGuid("123m");
		mediaList.add(media);
		entry.setPeg$contentClassification("Censored");
		entry.setMedia(mediaList);
		entryList.add(entry);
		video.setEntries(entryList);
		video.setEntryCount(1l);

		Videos videos = mediaService.filterMedia("censoring", "UnCensored", video);
		assertThat(videos.getEntryCount().toString(), is("1"));
		assertNotEquals(videos.getEntries().get(0).getMedia().get(0).getGuid(), "123c");

	}

}
