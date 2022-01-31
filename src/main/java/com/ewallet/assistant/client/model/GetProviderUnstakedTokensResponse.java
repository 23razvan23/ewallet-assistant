package com.ewallet.assistant.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
public class GetProviderUnstakedTokensResponse {
    private List<GetProviderUnstakedTokenResponse> unstakedTokens;

    @Data
    @Builder
    public static class GetProviderUnstakedTokenResponse {
        private BigInteger amount;
        private long expires;
    }
}
