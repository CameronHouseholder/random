package io.safensound.tests;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import io.restassured.response.Response;
import io.safensound.requests.EmployeeRequest;
import io.safensound.requests.EmployeesRequest;

import static io.restassured.RestAssured.*;

public class DummyRestIT {

    @Test
    public void getEmployees() {
        Response res = EmployeeRequest.init().getEmployee(3);
        assertThat(res.getStatusCode()).as("status code").isEqualTo(200);
    }
}