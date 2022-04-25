package com.irv.restaurantservice.proxy.http_client;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpRequest.Builder;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Map;
import java.util.Optional;

/**
 * Esta clase me da la impresion que se esta
 * poniendo a manera de configuracion
 */
@Component
public class HttpClientUsers {

    HttpClient httpClient = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();

    public Builder requestBuilder(URI uri, Optional<Map<String,String>> additionalHeaters){
        Builder builder = HttpRequest.newBuilder()
                .uri(uri)
                .timeout(Duration.ofMinutes(1))
                .header("Content-type","application/json")
                ;
        if(additionalHeaters.isPresent())
            additionalHeaters.get().forEach((k, v) -> builder.header(k,v));
        return builder;
    }
    public HttpResponse<String> send(HttpRequest httpRequest) throws IOException, InterruptedException {
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

}
