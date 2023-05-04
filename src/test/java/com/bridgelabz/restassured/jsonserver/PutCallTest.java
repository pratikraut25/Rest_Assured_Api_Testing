package com.bridgelabz.restassured.jsonserver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutCallTest {
    @Test
    public void modifyHostDetails(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        JSONObject json = new JSONObject();

        json.put("author","Arjun");
        json.put("title","Automation");

        request.body(json.toJSONString());

        Response response = request.put("http://localhost:3000/posts/7");
        System.out.println("status code: "+ response.getStatusCode());
        System.out.println("Time: " + response.getTime());
        System.out.println("Json Body: "+ response.asPrettyString());

        Assert.assertEquals(response.statusCode(),200);


    }
}
