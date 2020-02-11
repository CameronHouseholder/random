package io.safensound.requests;

import io.restassured.response.Response;

public class EmployeesRequest extends Request {

    private static final String basePath = "/employees";

    // constructor
    private EmployeesRequest() {
        super(basePath);
    }

    public static EmployeesRequest init() {
        return new EmployeesRequest();
    }

    // requests
    public Response getEmployees() {
        return retrieve("");
    }
}