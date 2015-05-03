package com.djr4488.wiichannelfeeder.forecastchannel.restapi.service;

import java.io.File;

public interface ForecastService {
	File getShortBin(String region);
	File getForecastBin(String region);
}
