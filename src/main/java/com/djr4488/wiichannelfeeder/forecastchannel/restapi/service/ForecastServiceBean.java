package com.djr4488.wiichannelfeeder.forecastchannel.restapi.service;

import javax.enterprise.context.ApplicationScoped;
import java.io.File;

/**
 * Implementation of ForecastService interface
 *
 * returns short.bin file
 * returns forecast.bin file
 *
 */
@ApplicationScoped
public class ForecastServiceBean {
	public File getShortBin(String region) {
		return new File("c:/app/wiichannels/forecast/short.bin");
	}

	public File getForecastBin(String region) {
		return new File("c:/app/wiichannels/forecast/forecast.bin");
	}
}
