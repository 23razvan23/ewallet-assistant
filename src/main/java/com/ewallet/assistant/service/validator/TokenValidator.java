package com.ewallet.assistant.service.validator;

import com.ewallet.assistant.exception.ApiException;
import com.ewallet.assistant.service.model.Token;

public class TokenValidator {

    public static void validateTokenName(String token) {
        try {
            Token.valueOf(token.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ApiException();
        }
    }
}
