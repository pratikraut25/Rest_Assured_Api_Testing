package com.bridgelabz.restassured.jsonserver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchCallTest {
    @Test
    public void patchHostDetails(){
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type","application/json");
        JSONObject json = new JSONObject();
        json.put("author","Raghav");


        request.body(json.toJSONString());

        Response response = request.patch("http://localhost:3000/posts/7");
        System.out.println("status code: "+ response.getStatusCode());
        System.out.println("Time: " + response.getTime());
        System.out.println("Json Body: "+ response.asPrettyString());

        Assert.assertEquals(response.statusCode(),200);



    }

}
