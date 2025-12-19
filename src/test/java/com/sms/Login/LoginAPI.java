package com.sms.Login;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.test.BaseTest;

import io.restassured.response.Response;
import utils.ExtentTestNGListener;

public class LoginAPI extends BaseTest{
	
	@Test(priority = 1)
	public void verifyloginwithValidemailAndInvalidPassword()
	{
	    String requestBody = "{\r\n"
	    		+ "  \"userName\": \"kkdubey@geduservices.com\",\r\n"
	    		+ "  \"password\": \"Gedu@123\"\r\n"
	    		+ "}";
	    ExtentTestNGListener.getTest().info("Request Body: " + requestBody);

	    Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestBody)
	            .when()
	            .post("/api/Account/Login")
	            .then()
	            .statusCode(400)
	            .extract().response();
	    
	    String message = response.jsonPath().getString("message");
	    String errorcode = response.jsonPath().getString("errorCode");


	    response.prettyPrint();
	    response.then().extract().response();


		
		ExtentTestNGListener.getTest().info("Message: " + message);
		ExtentTestNGListener.getTest().info("ErrorCode: " + errorcode);
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        ExtentTestNGListener.hardassertwithinteger(response.getStatusCode(), 400);
        ExtentTestNGListener.hardassertwithstring(message, "Username or password does not exists. Please try again.");
        ExtentTestNGListener.hardassertwithstring(errorcode, "BadRequest");
}
	

	
	

	@Test(priority = 2)
	public void verifyloginwithinValidemailAndvalidPassword()
	{
	    String requestBody = "{\r\n"
	    		+ "  \"userName\": \"kk@geduserv.com\",\r\n"
	    		+ "  \"password\": \"Gedu@12345\"\r\n"
	    		+ "}";
	    ExtentTestNGListener.getTest().info("Request Body: " + requestBody);

	    Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestBody)
	            .when()
	            .post("/api/Account/Login")
	            .then()
	            .statusCode(401)
	            .extract().response();
	    
	    String message = response.jsonPath().getString("message");
	    String errorcode = response.jsonPath().getString("errorCode");


	    response.prettyPrint();
	    response.then().extract().response();


		
		ExtentTestNGListener.getTest().info("Message: " + message);
		ExtentTestNGListener.getTest().info("ErrorCode: " + errorcode);
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        ExtentTestNGListener.hardassertwithinteger(response.getStatusCode(), 401);
        ExtentTestNGListener.hardassertwithstring(message, "Username or password does not exists. Please try again.");
        ExtentTestNGListener.hardassertwithstring(errorcode, "Unauthorized");
}
		
	
	
	
	@Test(priority = 3)
	public void verifyloginwithinValidemailAndinvalidPassword()
	{
	    String requestBody = "{\r\n"
	    		+ "  \"userName\": \"kk@geduservi.com\",\r\n"
	    		+ "  \"password\": \"Gedu@123\"\r\n"
	    		+ "}";
	    ExtentTestNGListener.getTest().info("Request Body: " + requestBody);

	    Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestBody)
	            .when()
	            .post("/api/Account/Login")
	            .then()
	            .statusCode(401)
	            .extract().response();
	    
	    String message = response.jsonPath().getString("message");
	    String errorcode = response.jsonPath().getString("errorCode");


	    response.prettyPrint();
	    response.then().extract().response();

		ExtentTestNGListener.getTest().info("Message: " + message);
		ExtentTestNGListener.getTest().info("ErrorCode: " + errorcode);
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        ExtentTestNGListener.hardassertwithinteger(response.getStatusCode(), 401);
        ExtentTestNGListener.hardassertwithstring(message, "Username or password does not exists. Please try again.");
        ExtentTestNGListener.hardassertwithstring(errorcode, "Unauthorized");
}
	
	@Test(priority = 4)
	public void verifyloginwithblankemailAndblankPassword()
	{
	    String requestBody = "{\r\n"
	    		+ "  \"userName\": \"\",\r\n"
	    		+ "  \"password\": \"\"\r\n"
	    		+ "}";
	    ExtentTestNGListener.getTest().info("Request Body: " + requestBody);

	    Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestBody)
	            .when()
	            .post("/api/Account/Login")
	            .then()
	            .statusCode(400)
	            .extract().response();
	    
	    String message = response.jsonPath().getString("message");
	    String errorcode = response.jsonPath().getString("errorCode");
	    response.prettyPrint();
	    response.then().extract().response();
		System.out.println(response.asPrettyString());

		
		ExtentTestNGListener.getTest().info("Message: " + message);
		ExtentTestNGListener.getTest().info("ErrorCode: " + errorcode);
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

       
}
	
	
	
	
	
	
	
	
	
	@Test(priority = 5)
	public void verifyvalidlogin()
	{
	    String requestBody = "{\r\n"
	    		+ "  \"userName\": \"kkdubey@geduservices.com\",\r\n"
	    		+ "  \"password\": \"Gedu@12345\"\r\n"
	    		+ "}";
	    ExtentTestNGListener.getTest().info("Request Body: " + requestBody);

	    Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestBody)
	            .when()
	            .post("/api/Account/Login")
	            .then()
	            .statusCode(200)
	            .extract().response();
	    
	    String message = response.jsonPath().getString("message");


	    response.prettyPrint();
	    response.then().extract().response();


		
		ExtentTestNGListener.getTest().info("Message: " + message);
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        ExtentTestNGListener.hardassertwithinteger(response.getStatusCode(), 200);
        ExtentTestNGListener.hardassertwithstring(message, "Login successfully.");
 
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

