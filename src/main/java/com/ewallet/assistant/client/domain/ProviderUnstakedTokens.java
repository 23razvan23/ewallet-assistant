package com.ewallet.assistant.client.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
