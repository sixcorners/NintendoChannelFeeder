package com.djr4488.wiichannelfeeder.forecastchannel.service;

import com.djr4488.wiichannelfeeder.forecastchannel.service.transport.Forecast;
import com.djr4488.wiichannelfeeder.forecastchannel.service.transport.ForecastTransport;
import org.slf4j.Logger;
import javax.ejb.*;
import javax.inject.Inject;
import java.io.File;

/**
 * djr4488
 * Service to get forecast data and build forecast files as required by Wii Forecast channel
 *
 */
@Startup
@Singleton
public class ForecastFeederService {
	@Inject
	private Logger log;
	@Inject
	private ForecastTransport forecastTransport;

	@Schedule(second="0", minute="10/10", hour="*")
	@Lock(LockType.WRITE)
	public void getUpdatedForecastsByRegions() {
		log.info("getUpdateForecastByRegions() started");
		Forecast forecast = forecastTransport.getForecastAndCurrent();
		log.debug("getUpdateForecastByRegions() completed forecast:{}", forecast);
	}

	@Lock(LockType.READ)
	public File getForecastFile(String region, String file) {
		//for now just return the existing file
		log.debug("getForecastFile() region:{}, file:{}", region, file);
		return new File("c:/app/wiichannels/" + file);
	}
}
