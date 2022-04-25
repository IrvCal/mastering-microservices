package com.irv.restaurantservice.proxy.http_client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Component
public class HttpClientUsersRestClient {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private HttpClientUsers restClient;
    private static final String userEndpoint =
            "http://localhost:8765/user-service/v1/users";

    public void getUser() throws Exception {
        HttpRequest request = restClient.requestBuilder(
                URI.create(userEndpoint ), Optional.empty()).GET().build();
        HttpResponse<String> response = restClient.send(request);
        if (response.statusCode() == 200) {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                    false);

            System.out.println(response.body());
        } }

}
