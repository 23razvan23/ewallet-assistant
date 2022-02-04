package com.ewallet.assistant.service;

import com.ewallet.assistant.client.ApiClientImpl;
import com.ewallet.assistant.client.converter.GetEconomicsResponseToEconomicsConverter;
import com.ewallet.assistant.client.converter.GetMexPairResponseToMexPairConverter;
import com.ewallet.assistant.client.domain.Economics;
import com.ewallet.assistant.client.domain.MexPair;
import com.ewallet.assistant.client.model.GetEconomicsResponse;
import com.ewallet.assistant.client.model.GetMexPairResponse;
import com.ewallet.assistant.service.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.ewallet.assistant.client.ApiResourceUri.ECONOMICS;
import static com.ewallet.assistant.client.ApiResourceUri.ECONOMICS_MEX_PAIRS;
import static com.ewallet.assistant.service.model.Token.EGLD;
import static com.ewallet.assistant.service.validator.TokenValidator.validateTokenName;
import static java.util.stream.Collectors.toList;

@Component
public class EconomicsService {
    private static final String ECONOMICS_URI_SEPARATOR = "-";
    private final ApiClientImpl apiClient;

    @Autowired
    public EconomicsService(ApiClientImpl apiClient) {
        this.apiClient = apiClient;
    }

    public Mono<Economics> getEconomics(String token) {
        validateTokenName(token);
        return apiClient.get(tokenToEconomicsUri(token), GetEconomicsResponse.class)
                .map(GetEconomicsResponseToEconomicsConverter::toDomain);
    }

    public Mono<List<MexPair>> getMexPairs() {
        return apiClient.getCollection(ECONOMICS_MEX_PAIRS.getUri(), GetMexPairResponse.class)
                .map(List::stream)
                .map(stream -> stream.map(GetMexPairResponseToMexPairConverter::toDomain))
                .map(stream -> stream.collect(toList()));
    }

    private String tokenToEconomicsUri(String tokenName) {
        Token token = Token.fromName(tokenName);
        return token != EGLD
                ? token.name() + ECONOMICS_URI_SEPARATOR + ECONOMICS.getUri()
                : ECONOMICS.getUri();
    }
}
