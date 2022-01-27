package com.ewallet.assistant.config;

import com.ewallet.assistant.exception.ApiException;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static java.lang.String.format;

@ConfigurationProperties(prefix = "spring.elrond.api")
@Data
public class ApiClientConfig {
    private String url;
    private long readTimeoutMillis = 5000L;
    private long writeTimeoutMillis = 5000L;

    public void setUrl(String value) {
        switch (value.toLowerCase().trim()) {
            case "devnet" -> this.url = toUrl("devnet-api");
            case "testnet" -> this.url = toUrl("testnet-api");
            case "mainnet" -> this.url = toUrl("api");
            default -> throw new ApiException();
        }
    }

    private String toUrl(String apiValue) {
        return format("https://%s.elrond.com", apiValue);
    }
}
