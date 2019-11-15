package com.max.client;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.engines.vertx.VertxClientHttpEngine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClientOptions;

@RestController
@RequestMapping("/ceps")
public class Controller {

	private final CepService cepService;

	public Controller() throws URISyntaxException, MalformedURLException {
		final int timeout = 2000;

		HttpClientOptions options = new HttpClientOptions()//
				.setHttp2MaxPoolSize(100)//
				.setMaxPoolSize(100)//
				.setConnectTimeout(timeout);

		VertxClientHttpEngine engine = new VertxClientHttpEngine(Vertx.vertx(), options);

		ResteasyClient client = ((ResteasyClientBuilder) ClientBuilder.newBuilder())//
				.httpEngine(engine)//
				.connectTimeout(timeout, TimeUnit.MILLISECONDS)//
				.readTimeout(timeout, TimeUnit.MILLISECONDS)//
				.build();

		cepService = client.target(getUri("https://viacep.com.br")).proxy(CepService.class);
	}

	@GetMapping("/{cep}")
	public String getCep(@PathVariable("cep") String cep) {
		Response response = cepService.findCep(cep);
		return response.readEntity(String.class);
	}

	private URI getUri(String urlpath) throws MalformedURLException {
		URL url = new URL(urlpath);
		int port = url.getPort();
		String protocol = url.getProtocol();

		if (port < 0) {
			port = getPort(protocol);
		}

		return UriBuilder.fromUri(urlpath).port(port).scheme(protocol).build();
	}

	private int getPort(String protocol) {
		switch (protocol) {
		case "http":
			return 80;
		case "https":
			return 443;
		default:
			return -1;
		}
	}

}
