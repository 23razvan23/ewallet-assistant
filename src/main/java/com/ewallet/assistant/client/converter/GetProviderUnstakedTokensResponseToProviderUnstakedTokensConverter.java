package com.ewallet.assistant.client.converter;

import com.ewallet.assistant.client.domain.ProviderUnstakedTokens;
import com.ewallet.assistant.client.model.GetProviderUnstakedTokensResponse;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static com.ewallet.assistant.client.model.GetProviderUnstakedTokensResponse.GetProviderUnstakedTokenResponse;
import static com.ewallet.assistant.client.domain.ProviderUnstakedTokens.ProviderUnstakedToken;

public class GetProviderUnstakedTokensResponseToProviderUnstakedTokensConverter {

    public static ProviderUnstakedTokens toDomain(GetProviderUnstakedTokensResponse response) {
        if (response == null) {
            return null;
        }

        return ProviderUnstakedTokens.builder()
                .providerUnstakedTokens(toDomain(response.getUnstakedTokens()))
                .build();
    }

    private static List<ProviderUnstakedTokens.ProviderUnstakedToken> toDomain(List<GetProviderUnstakedTokenResponse> response) {
        if (response == null) {
            return null;
        }

        return response.stream()
                .map(GetProviderUnstakedTokensResponseToProviderUnstakedTokensConverter::toDomain)
                .collect(toList());
    }

    private static ProviderUnstakedToken toDomain(GetProviderUnstakedTokenResponse response) {
        return ProviderUnstakedToken.builder()
                .availableTokens(response.getAmount())
                .availableFrom(response.getExpires())
                .build();
    }
}
