package com.api.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class UserTest {
@Test
public void post()
{
	String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImtrZHViZXlAZ2VkdXNlcnZpY2VzLmNvbSIsIlVzZXJOYW1lIjoiS2lzaGFuIER1YmV5IiwiVXNlckVtYWlsSWQiOiJra2R1YmV5QGdlZHVzZXJ2aWNlcy5jb20iLCJVc2VyTmFtZUlkIjoiOTk5NzdlODItNDcxMS00YTNjLWFlOTItMDA4ZDgwZjQzY2QxIiwiSXNTU08iOiIiLCJJbnN0aXR1dGVOYW1lIjoiSUNJQ0kgUHJpdmF0ZSBMaW1pdGVkIiwiVXNlclBlcm1pc3Npb25zIjoiIiwiSW5zdGl0dXRlTG9nbyI6Imh0dHBzOi8vc21zYmxvYnN0b3JhZ2VhY2NvdW50ZGV2LmJsb2IuY29yZS53aW5kb3dzLm5ldC9zbXNmaWxlY29udGFpbmVycWEvYjE5NmY3YzgtYjdkZS00OTdhLTljYzktYWMyOTJhYWZhMTVjLnBuZyIsIlVzZXJSb2xlTmFtZSI6IkFwcCBEZXZlbG9wZXIiLCJVc2VyUm9sZUlkIjoiYjlhZDNjMjctNWUxYS00YTU4LTkwOTUtYTI2MDM2YzljNWM2IiwiRGF0ZUZvcm1hdCI6Ik1NL0REL1lZWVkiLCJUaW1lRm9ybWF0IjoiSDptbSIsIlNlbGVjdGVkSW5zdGl0dXRlIjoiMjQzOTVkMTktNGEwZC00MWZlLTk1MDgtODQ5N2U5MzM4ODljIiwiQXBwTG9nbyI6IiIsIk9yZ0xvZ28iOiIiLCJJc09yZ2FuaXphdGlvblVzZXIiOiJmYWxzZSIsIm5iZiI6MTc2MzYyNjc3OCwiZXhwIjoxNzY0MjMxNTc4LCJpYXQiOjE3NjM2MjY3Nzh9.ccCwCUwgwaFZi0_jWNPQpABkfumlUxBmAv3ohj4wcyM";   // use from login API response

    RestAssured.baseURI = "https://qa-apigateway-sms.geduservices.com";



    String requestBody = "{\r\n"
    		+ "  \"userName\": \"kkdubey@geduservices.com\",\r\n"
    		+ "  \"password\": \"Gedu@12345\"\r\n"
    		+ "}}";

    Response response = given()
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + token)
            .body(requestBody)
            .when()
            .post("/api/Account/Login")
            .then()
            .statusCode(200)
            .extract().response();

    System.out.println("Response: " + response.asString());
}
}


