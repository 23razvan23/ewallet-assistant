package com.ewallet.assistant.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
public class GetMexPairResponse {
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
