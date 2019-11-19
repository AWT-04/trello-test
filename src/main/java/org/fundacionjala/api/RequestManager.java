package org.fundacionjala.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public final class RequestManager {
    private RequestManager() { }
    /**
     * Sets get method path.
     *
     * @param requestSpec validation spefication (username, password)
     * @param path  string path to use url.
     * @return response object
     */
    public static Response get(final RequestSpecification requestSpec, final String path) {
        Response response = given()
                .spec(requestSpec)
                .log().all()
                .when()
                .get(path);
        response.then().log().all();
        return response;
    }

    /**
     * Sets post method path.
     *
     * @param requestSpec validation spefication (username, password)
     * @param path string path to use url.
     * @param json json object in string format.
     * @return response object.
     */

    public static Response post(final RequestSpecification requestSpec, final String path,
                                final String json) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .contentType(ContentType.JSON)
                .body(json)
                .post(path);
        response.then().log().all();
        return response;
    }

    public static Response post(final RequestSpecification requestSpec, final String path,
                                final Map<String, String> json) {
        Response response = given()
                .spec(requestSpec)
                .params(json)
                .when()
                .post(path);
        response.then().log().all();
        return response;
    }

    /**
     * Sets put method path.
     *
     * @param requestSpec validation spefication (username, password)
     * @param path string path to use url.
     * @param json json object in string format.
     * @return response object.
     */

    public static Response put(final RequestSpecification requestSpec, final String path, final String json) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .contentType(ContentType.JSON)
                .body(json)
                .put(path);
        response.then().log().all();
        return response;
    }

    /**
     * Sets delete method path.
     *
     * @param requestSpec validation spefication (username, password)
     * @param path string path to use url.
     * @return response object.
     */
    public static Response delete(final RequestSpecification requestSpec, final String path) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .delete(path);
        response.then().log().all();
        return response;
    }

    /**
     * Sets patch method path.
     *
     * @param requestSpec validation spefication (username, password)
     * @param path string path to use url.
     * @return response object.
     */
    public static Response patch(final RequestSpecification requestSpec, final String path) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .patch(path);
        response.then().log().all();
        return response;
    }
}
