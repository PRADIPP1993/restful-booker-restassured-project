package com.restful.booker.testsuite;

import com.restful.booker.model.PostsPojo;
import com.restful.booker.model.UserPojo;
import com.restful.booker.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Post extends TestBase {


    @Test
    public void postRestful() {
        UserPojo userPojo = new UserPojo();
        userPojo.setUsername("admin");
        userPojo.setPassword("password123");

        RestAssured.basePath = "/auth";
        Response response = given().log().all()
                .header("content-Type", "application/json")
                .when()
                .body(userPojo)
                .post();
        response.prettyPrint();
        response.then().log().all().statusCode(200);

    }

    @Test
    public void postbooking() {

        List<String> bookList = new ArrayList<>();

        bookList.add("2018-01-15");
        bookList.add("2019-01-16");

        PostsPojo postPojo = new PostsPojo();
        postPojo.setFirstname("pradip");
        postPojo.setLastname("kakadiya");
        postPojo.setTotalprice("111");
        postPojo.setDepositpaid("true");
        postPojo.setBookingdates(bookList);
        postPojo.setAdditionalneeds("Breakfast");
        RestAssured.basePath = "/booking";
        Response response = given().log().all()
                .header("content-Type", "application/json")
                .when()
                .body(postPojo)
                .post();
        response.prettyPrint();
        response.then().log().all().statusCode(500);
    }





}
