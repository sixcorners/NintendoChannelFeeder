package com.djr4488.wiichannelfeeder.forecastchannel;

import com.djr4488.wiichannelfeeder.forecastchannel.controller.ForecastFeederApi;
import com.djr4488.wiichannelfeeder.forecastchannel.exceptionmapper.ForecastFeederExceptionMapper;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * djr4488
 * application to feed data to Wii starved Forecast Channel
 *
 */
@ApplicationPath("1")
public class ForecastFeederApp extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<>(Arrays.asList(ForecastFeederApi.class, ForecastFeederExceptionMapper.class));
	}
}