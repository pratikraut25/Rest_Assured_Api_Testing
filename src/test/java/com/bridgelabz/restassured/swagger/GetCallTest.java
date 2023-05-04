package com.bridgelabz.restassured.swagger;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class GetCallTest {

    @Test
           public void getTest(){
       Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println("status code: "+ response.getStatusCode());
        System.out.println("Time: " + response.getTime());
        System.out.println("Json Body: "+ response.asPrettyString());
        //System.out.println("Json Body: "+ response.asString());
        Assert.assertEquals(response.statusCode(),201);


    }

   @Test
    public void Test(){
        Response response = RestAssured.get("https://petstore.swagger.io/v2/pet");
        System.out.println("status code: "+ response.getStatusCode());
        System.out.println("Time: " + response.getTime());
        System.out.println("Json Body: "+ response.asPrettyString());
        //System.out.println("Json Body: "+ response.asString());
        Assert.assertEquals(response.statusCode(),200);


    }

}
