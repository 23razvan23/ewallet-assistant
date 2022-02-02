package com.ewallet.assistant.client.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
public class Economics {
    private Double price;
    private Long totalSupply;
    private Long circulatingSupply;
    private Long marketCapitalization;
    private Long staked;
    private Double apr;
    private Double topUpApr;
    private Double baseApr;
    private int marketPairsCount;
}
