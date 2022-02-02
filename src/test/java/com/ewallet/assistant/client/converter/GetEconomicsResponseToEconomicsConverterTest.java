package com.ewallet.assistant.client.converter;

import com.ewallet.assistant.client.model.GetEconomicsResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetEconomicsResponseToEconomicsConverterTest {

    @Test
    public void testToDomainNullGetEconomicsResponse() {
        assertNull(GetEconomicsResponseToEconomicsConverter.toDomain(null));
    }

    @Test
    public void testToDomainValidGetEconomicsResponse() {
        var result = GetEconomicsResponseToEconomicsConverter.toDomain(getEconomicsResponse());

        assertNotNull(result);
        assertEquals(1.1, result.getApr());
        assertEquals(1.2, result.getBaseApr());
        assertEquals(1.3, result.getTopUpApr());
        assertEquals(123L, result.getCirculatingSupply());
        assertEquals(1234L, result.getMarketCapitalization());
        assertEquals(12345L, result.getStaked());
        assertEquals(123456L, result.getTotalSupply());
        assertEquals(5, result.getMarketPairsCount());
        assertEquals(1.12, result.getPrice());
    }

    private GetEconomicsResponse getEconomicsResponse() {
        return GetEconomicsResponse.builder()
                .apr(1.1)
                .baseApr(1.2)
                .topUpApr(1.3)
                .circulatingSupply(123L)
                .marketCap(1234L)
                .staked(12345L)
                .totalSupply(123456L)
                .marketPairs(5)
                .price(1.12)
                .build();
    }
}
