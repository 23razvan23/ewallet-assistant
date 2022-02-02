package com.ewallet.assistant.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
public class GetEconomicsResponse {
    private Long totalSupply;
    private Long circulatingSupply;
    private Long staked;
    private Double price;
    private Long marketCap;
    private Double apr;
    private Double topUpApr;
    private Double baseApr;
    private int marketPairs;
}
