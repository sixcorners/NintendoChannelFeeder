package com.djr4488.wiichannelfeeder.cdi;

import org.apache.commons.codec.language.DoubleMetaphone;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * User: djr4488
 * Date: 1/6/14
 * Time: 9:04 AM
 */
@ApplicationScoped
public class PropertyProducer {
	@Inject
	private Logger logger;
	private static final String propertyFile = "/app/channels/conf/channels.properties";
	private Properties properties;
	private static final DoubleMetaphone dm = new DoubleMetaphone();

	@PostConstruct
	public void loadProperties() {
		logger.debug("loadProperties() - loading propertyFile:{}", propertyFile);
		try {
			properties = new Properties();
			properties.load(new FileInputStream(propertyFile));
		} catch (IOException ioEx) {
			logger.error("loadProperties() - ", ioEx);
			throw new RuntimeException(ioEx);
		}
	}

	@Produces
	public String getStringProperty(InjectionPoint injectionPoint) {
		logger.debug("getProperty()");
		String className = injectionPoint.getMember().getDeclaringClass().getSimpleName();
		String member = injectionPoint.getMember().getName();
		logger.debug("getStringProperty() - {}.{}={}", className, member,
				properties.getProperty(className + "." + member));
		return properties.getProperty(className + "." + member);
	}

	@Produces
	public boolean getBooleanProperty(InjectionPoint injectionPoint) {
		logger.debug("getProperty()");
		String className = injectionPoint.getMember().getDeclaringClass().getSimpleName();
		String member = injectionPoint.getMember().getName();
		logger.debug("getStringProperty() - {}.{}={}", className, member,
				properties.getProperty(className + "." + member));
		return Boolean.valueOf(properties.getProperty(className + "." + member));
	}

	@Produces
	public Integer getIntegerProperty(InjectionPoint injectionPoint) {
		logger.debug("getProperty()");
		String className = injectionPoint.getMember().getDeclaringClass().getSimpleName();
		String member = injectionPoint.getMember().getName();
		logger.debug("getStringProperty() - {}.{}={}", className, member,
				properties.getProperty(className + "." + member));
		return Integer.parseInt(properties.getProperty(className + "." + member));
	}

	@Produces
	public DoubleMetaphone getDoubleMetaphone(InjectionPoint injectionPoint) {
		logger.debug("getDoubleMetaphone()");
		String className = injectionPoint.getMember().getDeclaringClass().getSimpleName();
		String member = injectionPoint.getMember().getName();
		logger.debug("getDoubleMetaphone() - {}.{}={}", className, member,
				properties.getProperty(className + "." + member));
		dm.setMaxCodeLen(6);
		return dm;
	}

}
