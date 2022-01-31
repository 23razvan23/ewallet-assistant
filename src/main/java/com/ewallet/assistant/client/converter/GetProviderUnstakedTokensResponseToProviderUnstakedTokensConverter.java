package com.ewallet.assistant.client.converter;

import com.ewallet.assistant.client.domain.ProviderUnstakedTokens;
import com.ewallet.assistant.client.model.GetProviderUnstakedTokensResponse;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class GetProviderUnstakedTokensResponseToProviderUnstakedTokensConverter {

    public static ProviderUnstakedTokens toDomain(GetProviderUnstakedTokensResponse response) {
        if (response == null) {
            return null;
        }

        List<GetProviderUnstakedTokensResponse.GetProviderUnstakedTokenResponse> providerUnstakedTokens = response.getUnstakedTokens();
        return ProviderUnstakedTokens.builder()
                .providerUnstakedTokens(toDomain(providerUnstakedTokens))
                .build();
    }

    private static List<ProviderUnstakedTokens.ProviderUnstakedToken> toDomain(List<GetProviderUnstakedTokensResponse.GetProviderUnstakedTokenResponse> response) {
        if (response == null) {
            return null;
        }

        return response.stream()
                .map(GetProviderUnstakedTokensResponseToProviderUnstakedTokensConverter::toDomain)
                .collect(toList());
    }

    private static ProviderUnstakedTokens.ProviderUnstakedToken toDomain(GetProviderUnstakedTokensResponse.GetProviderUnstakedTokenResponse response) {
        return ProviderUnstakedTokens.ProviderUnstakedToken.builder()
                .availableTokens(response.getAmount())
                .availableFrom(response.getExpires())
                .build();
    }
}
