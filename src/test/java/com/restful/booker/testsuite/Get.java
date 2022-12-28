package com.restful.booker.testsuite;

import com.restful.booker.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get extends TestBase {

    @Test
    public void getAllBookingIDs() {
        RestAssured.basePath = "/booking";
        Response response = given()
                .when().get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleBookingID() {
        RestAssured.basePath = "/booking";
        Response response = given()
                .pathParam("id", 1165)
                .when().get("{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getPingHealthCheck() {
        RestAssured.basePath = "/ping";
        Response response = given()
                // .pathParam("id",1165)
                .when().get();
        response.then().statusCode(201);
        response.prettyPrint();
    }


}
