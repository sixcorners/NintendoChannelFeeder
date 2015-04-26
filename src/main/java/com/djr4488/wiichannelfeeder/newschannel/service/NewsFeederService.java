package com.djr4488.wiichannelfeeder.newschannel.service;

import org.slf4j.Logger;
import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;

/**
 * Service which will be used to schedule when to check for updated news and create the static files
 * to be served by the NewsFeederApi
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
