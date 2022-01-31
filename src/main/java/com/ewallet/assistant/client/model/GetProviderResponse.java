package com.ewallet.assistant.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
public class GetProviderResponse {
    private String provider;
    private String identity;
    private double serviceFee;
    private String delegationCap;
    private double apr;
    private int numUsers;
    private BigInteger cumulatedRewards;
    private int numNodes;
    private BigInteger stake;
    private BigInteger topUp;
    private BigInteger locked;
    private boolean featured;
}
