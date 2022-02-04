package com.ewallet.assistant.client.converter;

import com.ewallet.assistant.client.domain.MexPair;
import com.ewallet.assistant.client.model.GetMexPairResponse;

public class GetMexPairResponseToMexPairConverter {

    public static MexPair toDomain(GetMexPairResponse response) {
        if (response == null) {
            return null;
        }

        return MexPair.builder()
                .baseId(response.getBaseId())
                .basePrice(response.getBasePrice())
                .baseSymbol(response.getBaseSymbol())
                .baseName(response.getBaseName())
                .quoteId(response.getQuoteId())
                .quotePrice(response.getQuotePrice())
                .quoteSymbol(response.getQuoteSymbol())
                .quoteName(response.getQuoteName())
                .totalValue(response.getTotalValue())
                .volume24h(response.getVolume24h())
                .build();
    }
}
