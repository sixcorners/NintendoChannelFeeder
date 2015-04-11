package com.djr4488.wiichannelfeeder.forecastchannel.service.transport;

import com.djr4488.wiichannelfeeder.forecastchannel.service.transport.model.Forecast;
import com.djr4488.wiichannelfeeder.forecastchannel.service.transport.model.openweather.OpenWeatherCurrentConditions;
import com.djr4488.wiichannelfeeder.forecastchannel.service.transport.model.openweather.OpenWeatherForecast;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.slf4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * TODO: probably need to get a bulk of cities current and forecast conditions but for now we'll just test with one
 * TODO: log an error put it in a jms queue to be delayed and tried again just a bit later(say 10 minutes)
 */
@ApplicationScoped
@Default
public class OpenWeatherForecastTransport implements ForecastTransport {
	@Inject
	private Logger log;
	@Inject
	private String apiKey;
	@Inject
	private String apiUrl;
	@Inject
	private Client client;
	private static final String FORECAST = "forecast";
	private static final String WEATHER = "weather";

	public Forecast getForecastAndCurrent() {
		log.debug("getForecastAndCurrent() started");

		return null;
	}

	private OpenWeatherCurrentConditions getCurrentConditions() {
		log.debug("getCurrentConditions() started");
		return (OpenWeatherCurrentConditions)getOpenWeatherResponse(WEATHER);
	}

	private OpenWeatherForecast getForecast() {
		log.debug("getForecast() started");
		return (OpenWeatherForecast)getOpenWeatherResponse(FORECAST);
	}

	private Object getOpenWeatherResponse(String weatherType) {
		log.debug("getOpenWeatherResposne() weatherType:{}", weatherType);
		WebResource openWeather = client.resource(apiUrl + weatherType);
		ClientResponse response = openWeather.queryParams(getRequestParameters())
				.header("x-api-key", apiKey)
				.accept(MediaType.APPLICATION_JSON)
				.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if (isValidStatus(response.getStatus())) {
			switch (weatherType) {
				case FORECAST: {
					return response.getEntity(OpenWeatherForecast.class);
				}
				case WEATHER: {
					return response.getEntity(OpenWeatherCurrentConditions.class);
				}
			}
		} else {
			// TODO: log an error put it in a jms queue to be delayed and tried again just a bit later(say 10 minutes)
		}
		return response;
	}

	private boolean isValidStatus(int status) {
		return status >=200 && status < 300;
	}

	/**
	 * Creates the request parameters for call to OpenWeather API.
	 * @return MultivaluedMap of request parameters
	 */
	public MultivaluedMap<String, String> getRequestParameters() {
		MultivaluedMap<String, String> requestParameters = new MultivaluedMapImpl();
		requestParameters.add("q", "Olathe, ks");
		requestParameters.add("units", "imperial");
		return requestParameters;
	}
}
