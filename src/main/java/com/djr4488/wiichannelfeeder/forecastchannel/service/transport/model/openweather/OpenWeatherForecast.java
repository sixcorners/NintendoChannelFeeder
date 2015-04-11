package com.djr4488.wiichannelfeeder.forecastchannel.service.transport.model.openweather;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by IMac on 4/10/2015.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class OpenWeatherForecast implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement
	public Float latitude;
	@XmlElement
	public Float longitude;
	@XmlElement
	public String timezone;
	@XmlElement
	public Integer offset;
	@XmlElement(name = "currently")
	public OpenWeatherCurrentConditions openWeatherCurrent;
}
