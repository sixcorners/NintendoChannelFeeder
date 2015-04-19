package com.djr4488.wiichannelfeeder.forecastchannel.service.transport.openweather.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by IMac on 4/10/2015.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class OpenWeatherCurrentConditions implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement
	public Date time;
	@XmlElement
	public String summary;
	@XmlElement
	public String icon;
	@XmlElement
	public Float precipIntensity;
	@XmlElement
	public Float precipProbability;
	@XmlElement
	public Float temperature;
	@XmlElement
	public Float humidity;
	@XmlElement
	public Float dewpoint;
	@XmlElement
	public Float windspeed;
	@XmlElement
	public Float bearing;
	@XmlElement
	public Float visibility;
	@XmlElement
	public Float cloudCover;
	@XmlElement
	public Float pressure;
	@XmlElement
	public Float ozone;
}
