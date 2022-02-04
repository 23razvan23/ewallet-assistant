package com.ewallet.assistant.client.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
public class MexPair {
    private String baseId;
    private String basePrice;
    private String baseSymbol;
    private String baseName;
    private String quoteId;
    private String quotePrice;
    private String quoteSymbol;
    private String quoteName;
    private String totalValue;
    private String volume24h;
}
