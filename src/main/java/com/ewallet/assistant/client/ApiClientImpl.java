package com.ewallet.assistant.client;

import com.ewallet.assistant.config.ApiClientConfig;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.springframework.http.HttpMethod.GET;

@Component
public class ApiClientImpl {
    private final WebClient webClient;
    private static final Gson GSON = new Gson();

    @Autowired
    public ApiClientImpl(ApiClientConfig clientProperties) {
        this.webClient = WebClient.builder()
                .baseUrl(clientProperties.getUrl())
                .clientConnector(new ReactorClientHttpConnector(httpClient(clientProperties)))
                .build();
    }

    public <T> Mono<T> get(String uri, Class<T> responseType) {
        return processRequest(uri, responseType);
    }

    public <T> Mono<List<T>> getCollection(String uri, Class<T> responseType) {
        return processRequest(uri, collectionType(responseType));
    }

    private <T> Mono<T> processRequest(String uri, Type responseType) {
        return webClient.method(GET).uri(uri)
                .exchangeToMono(this::bodyToMono)
                .map(response -> deserializeResponse(responseType, response));
    }

    private Mono<String> bodyToMono(ClientResponse responseHolder) {
        return responseHolder.bodyToMono(String.class);
    }

    private <T> T deserializeResponse(Type responseType, String response) {
        return GSON.fromJson(response, responseType);
    }

    private <T> Type collectionType(Class<T> responseType) {
        return TypeToken.getParameterized(ArrayList.class, responseType).getType();
    }

    private HttpClient httpClient(ApiClientConfig clientProperties) {
        return HttpClient.create().doOnConnected(conn ->
                conn.addHandler(new ReadTimeoutHandler(clientProperties.getReadTimeoutMillis(), MILLISECONDS))
                        .addHandler(new WriteTimeoutHandler(clientProperties.getWriteTimeoutMillis(), MILLISECONDS))
        );
    }
}
