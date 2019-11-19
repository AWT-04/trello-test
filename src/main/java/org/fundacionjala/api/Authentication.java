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
                .build();
        return requestSpecification.log().all();
    }
}

