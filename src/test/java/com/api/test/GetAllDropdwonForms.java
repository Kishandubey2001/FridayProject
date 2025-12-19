package com.api.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExtentTestNGListener;

public class GetAllDropdwonForms extends BaseTest{
	
	@Test(priority = 1)
	public void verifyGetAllForm() {

	    RestAssured.baseURI = "https://qa-apigateway-sms.geduservices.com";
	    RestAssured.useRelaxedHTTPSValidation();  // Fix SSL certificate issue

	    Response response = given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .header("origin", "https://qa-sms.geduservices.com")
	            .when()
	            .get("/api/Form/GetAllDropdwonForms?id=fa651dd6-3ca3-e93b-737f-e74369302e04")   // API URL
	            .then()
	            .statusCode(200)  // Validate successful response
	            .extract().response();

	    // Print response
	    System.out.println("GET FORM RESPONSE:");
	    response.prettyPrint();

	    ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
	   ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
	    ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        Assert.assertEquals(response.getStatusCode(), 200, "Expected Status Code is 200");
   
	}
	
	

}
