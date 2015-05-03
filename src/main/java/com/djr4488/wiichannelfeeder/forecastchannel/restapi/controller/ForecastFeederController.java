package com.djr4488.wiichannelfeeder.forecastchannel.restapi.controller;

import com.djr4488.wiichannelfeeder.forecastchannel.restapi.service.ForecastServiceBean;
import org.slf4j.Logger;
import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.File;

/**
 * djr4488
 * Service to get forecast data and build forecast files as required by Wii Forecast channel
 *
 */
@ApplicationScoped
public class ForecastFeederController {
	@Inject
	private Logger log;
	@Inject
	private ForecastServiceBean forecastService;

	@Lock(LockType.READ)
	public File getForecastFile(String region, String file) {
		//for now just return the existing file
		log.debug("getForecastFile() region:{}, file:{}", region, file);
		File returnFile = null;
		switch(file) {
			case "short.bin": {
				returnFile = forecastService.getShortBin(region);
				break;
			}
			case "forecast.bin": {
				returnFile = forecastService.getForecastBin(region);
				break;
			}
			default: {
				log.error("getForecastFile() unexpected file name requested:{}", file);
			}
		}
		return returnFile;
	}
}
