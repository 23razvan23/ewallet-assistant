package com.ewallet.assistant.client.converter;

import com.ewallet.assistant.client.model.GetProviderUnstakedTokensResponse;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;
import static com.ewallet.assistant.client.model.GetProviderUnstakedTokensResponse.GetProviderUnstakedTokenResponse;

public class GetProviderUnstakedTokensResponseToProviderUnstakedTokensConverterTest {

    private static final long UNSTAKED_TOKEN_AVAILABLE_FROM_VALUE = 100;
    private static final String UNSTAKED_TOKEN_AVAILABLE_TOKENS_VALUE = "505";

    @Test
    public void testToDomainNullGetProviderUnstakedTokensResponse() {
        assertNull(GetProviderUnstakedTokensResponseToProviderUnstakedTokensConverter.toDomain(null));
    }

    @Test
    public void testToDomainNullProviderUnstakedTokensResponse() {
        var response = GetProviderUnstakedTokensResponse.builder()
                .unstakedTokens(null)
                .build();

        var result = GetProviderUnstakedTokensResponseToProviderUnstakedTokensConverter.toDomain(response);

        assertNotNull(result);
        assertNull(result.getProviderUnstakedTokens());
    }

    @Test
    public void testToDomainEmptyProviderUnstakedTokensResponse() {
        var response = GetProviderUnstakedTokensResponse.builder()
                .unstakedTokens(emptyList())
                .build();

        var result = GetProviderUnstakedTokensResponseToProviderUnstakedTokensConverter.toDomain(response);

        assertNotNull(result);
        assertNotNull(result.getProviderUnstakedTokens());
        assertTrue(result.getProviderUnstakedTokens().isEmpty());
    }

    @Test
    public void testToDomainValidProviderUnstakedTokensResponse() {
        var response = GetProviderUnstakedTokensResponse.builder()
                .unstakedTokens(singletonList(getUnstakedTokenResponse()))
                .build();

        var result = GetProviderUnstakedTokensResponseToProviderUnstakedTokensConverter.toDomain(response);

        assertNotNull(result);
        assertNotNull(result.getProviderUnstakedTokens());
        assertEquals(1, result.getProviderUnstakedTokens().size());
        assertEquals(UNSTAKED_TOKEN_AVAILABLE_TOKENS_VALUE, result.getProviderUnstakedTokens().get(0).getAvailableTokens().toString());
        assertEquals(UNSTAKED_TOKEN_AVAILABLE_FROM_VALUE, result.getProviderUnstakedTokens().get(0).getAvailableFrom());
    }

    private GetProviderUnstakedTokenResponse getUnstakedTokenResponse() {
        return GetProviderUnstakedTokenResponse.builder()
                .amount(new BigInteger(UNSTAKED_TOKEN_AVAILABLE_TOKENS_VALUE))
                .expires(UNSTAKED_TOKEN_AVAILABLE_FROM_VALUE)
                .build();
    }
}
