package com.ewallet.assistant.client.converter;

import com.ewallet.assistant.client.model.GetMexPairResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetMexPairResponseToMexPairConverterTest {

    @Test
    public void testToDomainNullGetEconomicsResponse() {
        assertNull(GetMexPairResponseToMexPairConverter.toDomain(null));
    }

    @Test
    public void testToDomainValidGetEconomicsResponse() {
        var result = GetMexPairResponseToMexPairConverter.toDomain(getEconomicsResponse());

        assertNotNull(result);
        assertEquals("ABC-abc789", result.getBaseId());
        assertEquals("123", result.getBasePrice());
        assertEquals("ABC", result.getBaseSymbol());
        assertEquals("A b c", result.getBaseName());
        assertEquals("DEF-def789", result.getQuoteId());
        assertEquals("456", result.getQuotePrice());
        assertEquals("DEF", result.getQuoteSymbol());
        assertEquals("D E F", result.getQuoteName());
        assertEquals("123456789", result.getTotalValue());
        assertEquals("789", result.getVolume24h());
    }

    private GetMexPairResponse getEconomicsResponse() {
        return GetMexPairResponse.builder()
                .baseId("ABC-abc789")
                .basePrice("123")
                .baseSymbol("ABC")
                .baseName("A b c")
                .quoteId("DEF-def789")
                .quotePrice("456")
                .quoteSymbol("DEF")
                .quoteName("D E F")
                .totalValue("123456789")
                .volume24h("789")
                .build();
    }
}
