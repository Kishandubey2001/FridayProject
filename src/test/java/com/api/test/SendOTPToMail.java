package com.api.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utils.ExtentTestNGListener;

public class SendOTPToMail extends BaseTest{
	
	@Test(priority = 1)
	public void verifyvalidlogin()
	{
	    String requestBody = "{\r\n"
	    		+ "  \"email\": \"kkdubey@geduservices.com\"\r\n"
	    		+ "}";
	    ExtentTestNGListener.getTest().info("Request Body: " + requestBody);

	    Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestBody)
	            .when()
	            .post("/api/Account/SendOTPToMail")
	            .then()
	            .statusCode(200)
	            .extract().response();

	    System.out.println("Response: " + response.asString());
	    response.prettyPrint();
	    response.then().extract().response();

		// Print complete response
		System.out.println(response.asPrettyString());

		
		
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected Status Code is 200");

}
}