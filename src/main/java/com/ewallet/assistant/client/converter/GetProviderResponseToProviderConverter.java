package com.ewallet.assistant.client.converter;

import com.ewallet.assistant.client.domain.Provider;
import com.ewallet.assistant.client.model.GetProviderResponse;

public class GetProviderResponseToProviderConverter {

    public static Provider toDomain(GetProviderResponse response) {
        if (response == null) {
            return null;
        }
        return Provider.builder()
                .apr(response.getApr())
                .address(response.getProvider())
                .identity(response.getIdentity())
                .fee(response.getServiceFee())
                .delegationCap(response.getDelegationCap())
                .cumulatedRewards(response.getCumulatedRewards())
                .featured(response.isFeatured())
                .locked(response.getLocked())
                .nodesCount(response.getNumNodes())
                .usersCount(response.getNumUsers())
                .stake(response.getStake())
                .topUp(response.getTopUp())
                .build();
    }
}
