package com.djr4488.wiichannelfeeder.forecastchannel.scheduler;

import org.slf4j.Logger;
import javax.ejb.*;
import javax.inject.Inject;

/**
 * Scheduled service to call the forecast service of choice in order to create the forecast.bin
 * and short.bin files
 */
@Startup
@Singleton
public class ForecastScheduler {
	@Inject
	private Logger log;

	@Schedule(second="0", minute="1/1", hour="*")
	@Lock(LockType.WRITE)
	public void getUpdatedForecastsByRegions() {
		log.info("getUpdateForecastByRegions() started");
		log.debug("getUpdateForecastByRegions() completed");
	}
}
