package com.bridgelabz.restassured.jsonserver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
public class PostCallTest {
    @Test
            public void addHostTest() {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
        json.put("id","6");
        json.put("title", "json-server");
        json.put("author", "pratik");

        request.body(json.toJSONString());

        Response response = request.post(" http://localhost:3000/posts");
        System.out.println("status code: "+ response.getStatusCode());
        System.out.println("Time: " + response.getTime());
        System.out.println("Json Body: "+ response.asPrettyString());

    }
}
