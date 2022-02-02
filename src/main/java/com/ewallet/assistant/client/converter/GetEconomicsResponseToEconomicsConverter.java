package com.ewallet.assistant.client.converter;

import com.ewallet.assistant.client.domain.Economics;
import com.ewallet.assistant.client.model.GetEconomicsResponse;

public class GetEconomicsResponseToEconomicsConverter {

    public static Economics toDomain(GetEconomicsResponse response) {
        if (response == null) {
            return null;
        }

        return Economics.builder()
                .apr(response.getApr())
                .baseApr(response.getBaseApr())
                .topUpApr(response.getTopUpApr())
                .circulatingSupply(response.getCirculatingSupply())
                .totalSupply(response.getTotalSupply())
                .marketCapitalization(response.getMarketCap())
                .price(response.getPrice())
                .staked(response.getStaked())
                .marketPairsCount(response.getMarketPairs())
                .build();
    }
}
