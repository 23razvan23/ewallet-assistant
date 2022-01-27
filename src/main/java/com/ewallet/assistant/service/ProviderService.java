package com.ewallet.assistant.service;

import com.ewallet.assistant.client.ApiClientImpl;
import com.ewallet.assistant.client.converter.GetProviderResponseToProviderConverter;
import com.ewallet.assistant.client.domain.Provider;
import com.ewallet.assistant.client.model.GetProviderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

import static com.ewallet.assistant.client.ApiResourceUri.PROVIDER_BY_ADDRESS;
import static java.lang.String.format;

@Component
public class ProviderService {
    private final ApiClientImpl apiClient;

    @Autowired
    public ProviderService(ApiClientImpl apiClient) {
        this.apiClient = apiClient;
    }

    public Mono<Provider> getProvider(String address) {
        return apiClient.get(format(PROVIDER_BY_ADDRESS.getUri(), address), GetProviderResponse.class)
                .map(GetProviderResponseToProviderConverter::toDomain);
    }
}
