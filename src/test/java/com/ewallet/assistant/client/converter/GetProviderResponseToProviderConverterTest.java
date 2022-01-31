package com.ewallet.assistant.client.converter;

import com.ewallet.assistant.client.domain.Provider;
import com.ewallet.assistant.client.model.GetProviderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;


public class GetProviderResponseToProviderConverterTest {

    private static final String DEFAULT_LOCKED_VALUE = "11";
    private static final String DEFAULT_CUMULATED_REWARDS_VALUE = "10";
    private static final String DEFAULT_STAKE_VALUE = "12";
    private static final String DEFAULT_TOP_UP_VALUE = "13";
    private static final String DEFAULT_DELEGATION_CAP_VALUE = "12345";
    private static final double DEFAULT_SERVICE_FEE_VALUE = 2.15;
    private static final int DEFAULT_NUM_NODES_VALUE = 2;
    private static final int DEFAULT_NUM_USERS_VALUE = 3;
    private static final boolean DEFAULT_FEATURED_VALUE = true;
    private static final double DEFAULT_APR_VALUE = 5.05;
    private static final String DEFAULT_PROVIDER_IDENTITY_VALUE = "provider_identity";
    private static final String DEFAULT_ADDRESS_VALUE = "erd1qqqqxxxxxxx";

    @Test
    public void testToDomainNullGetProviderResponse() {
        assertNull(GetProviderResponseToProviderConverter.toDomain(null));
    }

    @Test
    public void testToDomainValidGetProviderResponse() {
        var result = GetProviderResponseToProviderConverter.toDomain(getProviderResponse());

        assertNotNull(result);
        assertEquals(new BigInteger(DEFAULT_CUMULATED_REWARDS_VALUE), result.getCumulatedRewards());
        assertEquals(new BigInteger(DEFAULT_LOCKED_VALUE), result.getLocked());
        assertEquals(new BigInteger(DEFAULT_STAKE_VALUE), result.getStake());
        assertEquals(new BigInteger(DEFAULT_TOP_UP_VALUE), result.getTopUp());
        assertEquals(DEFAULT_DELEGATION_CAP_VALUE, result.getDelegationCap());
        assertEquals(DEFAULT_APR_VALUE, result.getApr());
        assertEquals(DEFAULT_SERVICE_FEE_VALUE, result.getFee());
        assertEquals(DEFAULT_PROVIDER_IDENTITY_VALUE, result.getIdentity());
        assertEquals(DEFAULT_ADDRESS_VALUE, result.getAddress());
        assertEquals(DEFAULT_FEATURED_VALUE, result.isFeatured());
        assertEquals(DEFAULT_NUM_NODES_VALUE, result.getNodesCount());
        assertEquals(DEFAULT_NUM_USERS_VALUE, result.getUsersCount());
    }

    private GetProviderResponse getProviderResponse() {
        return GetProviderResponse.builder()
                .apr(DEFAULT_APR_VALUE)
                .cumulatedRewards(new BigInteger(DEFAULT_CUMULATED_REWARDS_VALUE))
                .delegationCap(DEFAULT_DELEGATION_CAP_VALUE)
                .featured(DEFAULT_FEATURED_VALUE)
                .identity(DEFAULT_PROVIDER_IDENTITY_VALUE)
                .provider(DEFAULT_ADDRESS_VALUE)
                .locked(new BigInteger(DEFAULT_LOCKED_VALUE))
                .numNodes(DEFAULT_NUM_NODES_VALUE)
                .numUsers(DEFAULT_NUM_USERS_VALUE)
                .serviceFee(DEFAULT_SERVICE_FEE_VALUE)
                .stake(new BigInteger(DEFAULT_STAKE_VALUE))
                .topUp(new BigInteger(DEFAULT_TOP_UP_VALUE))
                .build();
    }
}
