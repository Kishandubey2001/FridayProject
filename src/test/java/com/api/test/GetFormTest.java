package com.api.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExtentTestNGListener;

public class GetFormTest extends BaseTest{

	@Test(priority = 3)
	public void verifyGetForm() {

	   // String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImtrZHViZXlAZ2VkdXNlcnZpY2VzLmNvbSIsIlVzZXJOYW1lIjoiS2lzaGFuIER1YmV5IiwiVXNlckVtYWlsSWQiOiJra2R1YmV5QGdlZHVzZXJ2aWNlcy5jb20iLCJVc2VyTmFtZUlkIjoiOTk5NzdlODItNDcxMS00YTNjLWFlOTItMDA4ZDgwZjQzY2QxIiwiSXNTU08iOiIiLCJJbnN0aXR1dGVOYW1lIjoiSUNJQ0kgUHJpdmF0ZSBMaW1pdGVkIiwiVXNlclBlcm1pc3Npb25zIjoiIiwiSW5zdGl0dXRlTG9nbyI6Imh0dHBzOi8vc21zYmxvYnN0b3JhZ2VhY2NvdW50ZGV2LmJsb2IuY29yZS53aW5kb3dzLm5ldC9zbXNmaWxlY29udGFpbmVycWEvYjE5NmY3YzgtYjdkZS00OTdhLTljYzktYWMyOTJhYWZhMTVjLnBuZyIsIlVzZXJSb2xlTmFtZSI6IkFwcCBEZXZlbG9wZXIiLCJVc2VyUm9sZUlkIjoiYjlhZDNjMjctNWUxYS00YTU4LTkwOTUtYTI2MDM2YzljNWM2IiwiRGF0ZUZvcm1hdCI6Ik1NL0REL1lZWVkiLCJUaW1lRm9ybWF0IjoiSDptbSIsIlNlbGVjdGVkSW5zdGl0dXRlIjoiMjQzOTVkMTktNGEwZC00MWZlLTk1MDgtODQ5N2U5MzM4ODljIiwiQXBwTG9nbyI6IiIsIk9yZ0xvZ28iOiIiLCJJc09yZ2FuaXphdGlvblVzZXIiOiJmYWxzZSIsIm5iZiI6MTc2MzYyNjc3OCwiZXhwIjoxNzY0MjMxNTc4LCJpYXQiOjE3NjM2MjY3Nzh9.ccCwCUwgwaFZi0_jWNPQpABkfumlUxBmAv3ohj4wcyM";  // Use from login response
	    //String formId = id;  // use the ID extracted from publish API response 

	    RestAssured.baseURI = "https://qa-apigateway-sms.geduservices.com";
	    RestAssured.useRelaxedHTTPSValidation();  // Fix SSL certificate issue

	    Response response = given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .header("origin", "https://qa-sms.geduservices.com")
	            .when()
	            .get("/api/Form/GetFormById/" + CreateFormTest.id)   // API URL
	            .then()
	            .statusCode(200)  // Validate successful response
	            .extract().response();

	    // Print response
	    System.out.println("GET FORM RESPONSE:");
	    response.prettyPrint();

	    // Extract useful fields
	    String formName = response.jsonPath().getString("data.name");
	    String formStatus = response.jsonPath().getString("data.status");

	    System.out.println("Form Name => " + formName);
	    System.out.println("Form Status => " + formStatus);
	    
	    ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
	    ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
	    ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected Status Code is 200");
   
	}
	
}
