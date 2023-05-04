package com.bridgelabz.restassured.jsonserver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetCallTest {
       @Test
    public void getLocalHostTest(){
           Response response = RestAssured.get(" http://localhost:3000/posts");
           System.out.println("status code: "+ response.getStatusCode());
           System.out.println("Time: " + response.getTime());
           System.out.println("Json Body: "+ response.asPrettyString());
       }
}
