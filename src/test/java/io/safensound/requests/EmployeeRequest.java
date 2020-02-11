package io.safensound.requests;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class EmployeeRequest extends Request {

    private static final String basePath = "/employee";

    // constructor
    private EmployeeRequest() {
        super(basePath);
    }

    public static EmployeeRequest init() {
        return new EmployeeRequest();
    }

    // requests
    public Response getEmployee(int employeeId) {
        Map<String, Integer> pathParams = new HashMap<String, Integer>();
        pathParams.put("employeeId", employeeId);
        return retrieve("/{employeeId}", pathParams);
    }
}