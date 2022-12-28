package com.restful.booker.testsuite;

import com.restful.booker.model.PostsPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Put {

    @Test
    public void putbooking() {

        List<String> bookList = new ArrayList<>();

        bookList.add("2018-01-13");
        bookList.add("2019-01-14");

        PostsPojo postPojo = new PostsPojo();
        postPojo.setFirstname("pradip");
        postPojo.setLastname("kakadiya");
        postPojo.setTotalprice("111");
        postPojo.setDepositpaid("true");
        postPojo.setBookingdates(bookList);
        postPojo.setAdditionalneeds("Dinner");
        RestAssured.basePath = "/booking/425";
        Response response = given().log().all()
                .header("content-Type", "application/json")
                .when()
                .body(postPojo)
                .put();
        response.prettyPrint();
        response.then().log().all().statusCode(200);
    }

}
