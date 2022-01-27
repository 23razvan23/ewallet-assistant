package com.ewallet.assistant.client;

public enum ApiResourceUri {
    PROVIDERS("providers"), PROVIDER_BY_ADDRESS("providers/%s");

    private final String uri;

    private ApiResourceUri(final String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return this.uri;
    }
}
