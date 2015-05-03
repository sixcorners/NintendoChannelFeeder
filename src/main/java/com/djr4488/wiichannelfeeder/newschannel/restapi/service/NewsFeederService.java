package com.djr4488.wiichannelfeeder.newschannel.restapi.service;

import org.slf4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;

/**
 * Used to sign and return the requested file to the controller
 */
@ApplicationScoped
public class NewsFeederService {
	@Inject
	private Logger log;

	public File getNewsFile(String file) {
		//for now just return existing files
		log.debug("getNewsFile() file:{}", file);
		return new File("c:/app/wiichannels/news/"+file);
	}
}
