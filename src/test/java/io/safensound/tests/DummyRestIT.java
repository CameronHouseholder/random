package io.safensound.tests;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import io.restassured.response.Response;
import io.safensound.requests.UsersRequest;

public class DummyRestIT {

    @Test
    public void getUser() {
        Response res = UsersRequest.init().getUser(2);
        assertThat(res.getStatusCode()).as("status code").isEqualTo(200);
    }
}