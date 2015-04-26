package com.djr4488.wiichannelfeeder.newschannel.scheduler;

import org.slf4j.Logger;
import javax.ejb.*;
import javax.inject.Inject;

/**
 * Created by IMac on 4/26/2015.
 */
@Startup
@Singleton
public class NewsFeederScheduler {
	@Inject
	private Logger log;

	/**
	 * Run daily at 3am call out to some news service and create the news.bin.* files is ultimately the goal here
	 * Right now, just log.
	 */
	@Schedule(second="0", minute="0", hour="3")
	public void getUpdatededNews() {
		log.info("getUpdatedNews() started");
		log.info("getUpdatedNews() completed");
	}
}
