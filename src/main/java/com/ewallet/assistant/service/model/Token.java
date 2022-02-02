package com.ewallet.assistant.service.model;

public enum Token {
    EGLD, MEX;

    public static Token fromName(String value) {
        return Token.valueOf(value.toUpperCase());
    }
}
