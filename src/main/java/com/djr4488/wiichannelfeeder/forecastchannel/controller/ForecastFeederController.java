package com.djr4488.wiichannelfeeder.forecastchannel.controller;

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

	@Lock(LockType.READ)
	public File getForecastFile(String region, String file) {
		//for now just return the existing file
		log.debug("getForecastFile() region:{}, file:{}", region, file);
		return new File("c:/app/wiichannels/" + file);
	}
}
