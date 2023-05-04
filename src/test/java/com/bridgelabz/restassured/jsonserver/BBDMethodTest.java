package com.bridgelabz.restassured.jsonserver;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BBDMethodTest {
    /*
    *given()---> heder, body
    * when()---> method
    * then()---> statuscode
    * and()
     */

    @Test
    public void getHostDetails(){
        String hostBody = given().
         when().get("http://localhost:3000/posts").asPrettyString();

        System.out.println(hostBody);
    }

    @Test
    public void postHostDetails(){
        JSONObject json = new JSONObject();
        json.put("id","8");
        json.put("title", "json-server");
        json.put("author", "shiv");

        given().header("Content-Type", "application/json").body(json.toJSONString()).
                when().post("http://localhost:3000/posts").
                then().statusCode(200);
    }

    @Test
    public void putHostDetails(){
        JSONObject json = new JSONObject();

        json.put("author","veer");
        json.put("title", "json-server");

        given().header("Content-Type", "application/json").body(json.toJSONString()).
                when().put("http://localhost:3000/posts/8").
                then().statusCode(200);

    }
    @Test
    public void deleteHostDetails(){
        given().when().delete("http://localhost:3000/posts/8").then().statusCode(200);
    }
    @Test
    public void patchHostDetails(){
        JSONObject json = new JSONObject();

        json.put("author","veer");


        given().header("Content-Type", "application/json").body(json.toJSONString()).
                when().patch("http://localhost:3000/posts/7").
                then().statusCode(200);

    }

}
