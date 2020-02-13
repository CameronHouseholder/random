package io.safensound.requests;

import java.util.Map;

import io.restassured.response.Response;

public class UsersRequest extends Request {

    private static final String basePath = "/users";

    // constructor
    private UsersRequest() {
        super(basePath);
    }

    public static UsersRequest init() {
        return new UsersRequest();
    }

    // requests
    public Response getUser(int userId) {
        var pathParams = Map.of("userId", userId);
        return retrieve("/{userId}", pathParams);
    }
}