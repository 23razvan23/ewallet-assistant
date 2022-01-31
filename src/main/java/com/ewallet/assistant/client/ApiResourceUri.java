package com.ewallet.assistant.client;

public enum ApiResourceUri {
    PROVIDERS("providers"), PROVIDER_BY_ADDRESS("providers/%s"), PROVIDER_UNSTAKED_TOKENS_BY_ADDRESS("accounts/%s/stake");

    private final String uri;

    ApiResourceUri(final String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return this.uri;
    }
}
