package com.assignment.Service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.assignment.Model.Entries;
import com.assignment.Model.Media;
import com.assignment.Model.Videos;

/**
 * filterMedia() method accepts the variables 'filter','level','jsonobjects' 
 * if filter = censoring and level=censored removes uncensored data from media
 * if filter = censoring and level=uncensored removes censored data from media
 */
@Service
public class MediaService implements MediaServiceInterface {

	Logger logger = LoggerFactory.getLogger(MediaService.class);

	@Override
	public Videos filterMedia(String filter, String level, Videos videos) {

		logger.info("indise the media service");
		List<Entries> entryList = new ArrayList<Entries>();
		List<Media> mediaList = new ArrayList<Media>();
		int j = 0;
		for (int i = 0; i < videos.getEntryCount(); i++) {
			entryList = videos.getEntries();
			mediaList = entryList.get(i).getMedia();
			if (!(" ".equals(filter)) && MediaConstant.CENSORING.equals(filter)
					&& MediaConstant.CONTENTCLASSIFICATION.equals(entryList.get(i).getPeg$contentClassification())) {
				for (j = 0; j < mediaList.size(); j++) {
					if (!(" ".equals(level)) && MediaConstant.CENSOREDLEVEL.equals(level)) {
						if (!(mediaList.get(j).getGuid().endsWith("C"))) {
							mediaList.remove(j);
						}

					}
					if (!(" ".equals(level)) && MediaConstant.UNCENSOREDLEVEL.equals(level)) {
						if ((mediaList.get(j).getGuid().endsWith("C"))) {
							mediaList.remove(j);
						}

					}

				}
			}

		}

		return videos;
	}

}
