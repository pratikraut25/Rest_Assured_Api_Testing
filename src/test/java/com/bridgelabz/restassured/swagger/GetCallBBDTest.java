package com.bridgelabz.restassured.swagger;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCallBBDTest {
    @Test
    public void getPetDetails(){
        String body = given().
                when().
               get("https://petstore.swagger.io/v2/pet/103").asPrettyString();

        System.out.println("Body: " + body);
       
    }
   @Test
    public void addPetDetails(){
       JSONObject json = new JSONObject();
       json.put("id","102");
       json.put("name", "jaany");
       json.put("status", "pending");

       given().headers("Content-Type","application/json").body(json.toJSONString()).
               when().post("https://petstore.swagger.io/v2/pet").
               then().statusCode(200);
   }
   @Test
    public void modifyPetDetails(){
       RequestSpecification request = RestAssured.given();
       request.header("Content-Type","application/json");
       JSONObject json = new JSONObject();

       json.put("name", "jacky");
       json.put("status", "sold");

       given().headers("Content-Type","application/json").body(json.toJSONString()).
               when().post("https://petstore.swagger.io/v2/pet/102").
               then().statusCode(200);

   }
    @Test
    public void patchPetDetails() {
        JSONObject json = new JSONObject();

        json.put("name", "cherry");


        given().header("Content-Type", "application/json").body(json.toJSONString()).
                when().patch("https://petstore.swagger.io/v2/pet/102").
                then().statusCode(200);
    }
    @Test
    public void deleteHostDetails(){
        given().when().delete("https://petstore.swagger.io/v2/pet/102").then().statusCode(200);
    }

}
