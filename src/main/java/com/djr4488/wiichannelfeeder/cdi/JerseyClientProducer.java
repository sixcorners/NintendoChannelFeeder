package com.djr4488.wiichannelfeeder.cdi;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/**
 * Created by IMac on 4/10/2015.
 */
@ApplicationScoped
public class JerseyClientProducer {
	@Inject
	private boolean logTraffic;

	@Produces
	@RequestScoped
	protected Client createClient() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		if (logTraffic) {
			client.addFilter(new LoggingFilter(System.out));
		}
		return client;
	}
}
