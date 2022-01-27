package com.ewallet.assistant.client.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;

@Data
@Builder
public class Provider {
    private String address;
    private String identity;
    private double apr;
    private double fee;
    private String delegationCap;
    private BigInteger cumulatedRewards;
    private BigInteger stake;
    private BigInteger topUp;
    private BigInteger locked;
    private int usersCount;
    private int nodesCount;
    private boolean featured;
}
