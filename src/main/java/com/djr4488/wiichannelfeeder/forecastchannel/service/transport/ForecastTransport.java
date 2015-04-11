package com.djr4488.wiichannelfeeder.forecastchannel.service.transport;

import com.djr4488.wiichannelfeeder.forecastchannel.service.transport.model.Forecast;

/**
 * Created by IMac on 4/10/2015.
 */
public interface ForecastTransport {
	public Forecast getForecastAndCurrent();
}
