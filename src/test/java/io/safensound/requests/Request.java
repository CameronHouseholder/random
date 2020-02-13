package io.safensound.requests;

import org.aeonbits.owner.ConfigFactory;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.Map;

import io.safensound.configs.EnvironmentConfig;

public class Request {

    // configs
    private EnvironmentConfig environmentConfig;

    // constructor
    public Request(String basePath) {
        environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
        RestAssured.baseURI = environmentConfig.baseUri();
        RestAssured.basePath = basePath;
    }

    // get requests
    public Response retrieve(String path) {
        return given().contentType("application/json").filter(new AllureRestAssured())
            .when().get(path);
    }

    public Response retrieve(String path, Map<String, ?> pathParams) {
        return given().contentType("application/json").pathParams(pathParams).filter(new AllureRestAssured())
            .when().get(path);
    }

    // post requests
    public Response create(String path, Object body) {
        return given().contentType("application/json").filter(new AllureRestAssured())
            .when().body(body).post(path);
    }

    public Response create(String path, Object body, Map<String, ?> pathParams) {
        return given().contentType("application/json").pathParams(pathParams).filter(new AllureRestAssured())
            .when().body(body).post(path);
    }
}