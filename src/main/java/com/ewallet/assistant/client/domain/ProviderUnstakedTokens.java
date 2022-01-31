package com.ewallet.assistant.client.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
@Builder
public class ProviderUnstakedTokens {
    private List<ProviderUnstakedToken> providerUnstakedTokens;

    @Data
    @Builder
    public static class ProviderUnstakedToken {
        private BigInteger availableTokens;
        private long availableFrom;
    }
}
