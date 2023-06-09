package com.equitas.sms.config;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import javax.net.ssl.SSLException;

@Configuration
public class WebClientConfigs {

    @Value("${web.client.max-connection}")
    private Integer maxConnection;

    @Bean
    public HttpClient tipcoHttpClient() throws SSLException {

        SslContext sslContext = SslContextBuilder.forClient()
                .trustManager(InsecureTrustManagerFactory.INSTANCE)
                .build();
        return HttpClient.create(ConnectionProvider.builder("tipco")
                        .maxConnections(maxConnection).build())
                .secure(t -> t.sslContext(sslContext));
    }

    @Configuration
    public static class tipcoWebClientConfig {

        @Value("${tipco-api.baseUrl}")
        private String baseUrl;

        @Bean
        public WebClient tipcoWebClient(HttpClient tipcoHttpClient) {
            WebClient.Builder builder = WebClient.builder()
                    .clientConnector(new ReactorClientHttpConnector(tipcoHttpClient))
                    .baseUrl(baseUrl)
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            return builder.build();
        }
    }
}
