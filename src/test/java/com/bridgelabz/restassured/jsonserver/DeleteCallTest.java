package com.bridgelabz.restassured.jsonserver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCallTest {
    @Test
    public void deleteHostDetails(){
        Response response = RestAssured.delete("http://localhost:3000/posts/6");
        System.out.println("status code: "+ response.getStatusCode());
        System.out.println("Time: " + response.getTime());
        System.out.println("Json Body: "+ response.asPrettyString());
        //System.out.println("Json Body: "+ response.asString());
        Assert.assertEquals(response.statusCode(),200);
    }
}
