package org.fundacionjala.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.core.utils.ConfigVariableHandler;

/**
 * This classes permit the authentication, using a singleton pattern.
 */
public final class Authentication {

    private Authentication() {    }

    /**
     * Gets the request specification.
     *
     * @param account (username, password)
     * @return request specification.
     */
    public static RequestSpecification getRequestSpecification(final String account) {
        ConfigVariableHandler configVariableHandler = new ConfigVariableHandler();

        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri((String) configVariableHandler.getUri().get("uri"))
                .addQueryParam("key", configVariableHandler.getKeyToken(account).get("keyToken"))
                .addQueryParam("token", configVariableHandler.getApiToken(account).get("apiToken"))
                .build();
        return requestSpecification.log().all();
    }
}

