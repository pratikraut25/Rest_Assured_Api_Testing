package com.bridgelabz.restassured.twitterapi;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static com.github.scribejava.core.model.OAuthConstants.ACCESS_TOKEN;
import static io.restassured.RestAssured.given;

public class TwitterApiTest {
       //oauth("API Key", "API Secret","Access token", "Access secret")

    @Test

    public void postTweetTest(){

        Response response = RestAssured.given().auth().
                oauth(
                        "mErlcTEUCPrOP5y0SuBWuyQJV",
                        "cnfRcUezMSKR5gKrG7aPM7tt5Ei9ON7GyrX3AwDpFPSv60tByQ",
                        "4003503614-Kewo5cPjq0SokbPrjpd8E7vq5p6Q2t4CY2OnjCp",
                        "WnRlWOtPshGMvJMVtNbZZDi73T1AgtX1kGvbtZnj25Q86").
                post("https://api.twitter.com/1.1/statuses/update.json?status=This my first tweet");
        System.out.println("Status code: "+ response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }


    @Test
    public void reTweet() {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("tweet_id", "1652336066337337346");
        RequestSpecification request = given().auth().oauth(
                "mErlcTEUCPrOP5y0SuBWuyQJV",
                "cnfRcUezMSKR5gKrG7aPM7tt5Ei9ON7GyrX3AwDpFPSv60tByQ",
                "4003503614-Kewo5cPjq0SokbPrjpd8E7vq5p6Q2t4CY2OnjCp",
                "WnRlWOtPshGMvJMVtNbZZDi73T1AgtX1kGvbtZnj25Q86");
        request.body(jsonBody.toString());
        Response response = request.post("https://api.twitter.com/1.1/statuses/retweet/1652336066337337346.json");
        System.out.println("Response Body: " + response.asPrettyString());

        System.out.println("Response Code: " + response.statusCode());
    }

    @Test
    public void undoRetweetTest() {
        Response response = given().auth().oauth(
                        "mErlcTEUCPrOP5y0SuBWuyQJV",
                        "cnfRcUezMSKR5gKrG7aPM7tt5Ei9ON7GyrX3AwDpFPSv60tByQ",
                        "4003503614-Kewo5cPjq0SokbPrjpd8E7vq5p6Q2t4CY2OnjCp",
                        "WnRlWOtPshGMvJMVtNbZZDi73T1AgtX1kGvbtZnj25Q86").
                post("https://api.twitter.com/1.1/statuses/destroy/1652338152596733954.json");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }

    @Test
    public void deleteTweetTest() {
        Response response = given().auth().oauth(
                        "mErlcTEUCPrOP5y0SuBWuyQJV",
                        "cnfRcUezMSKR5gKrG7aPM7tt5Ei9ON7GyrX3AwDpFPSv60tByQ",
                        "4003503614-Kewo5cPjq0SokbPrjpd8E7vq5p6Q2t4CY2OnjCp",
                        "WnRlWOtPshGMvJMVtNbZZDi73T1AgtX1kGvbtZnj25Q86").
                post("https://api.twitter.com/1.1/statuses/destroy/1652338152596733954.json");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Response Body: " + response.asPrettyString());
    }
}
