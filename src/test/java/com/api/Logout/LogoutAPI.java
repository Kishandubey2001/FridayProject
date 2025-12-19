package com.api.Logout;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.pojo.LogoutRequest;
import com.api.test.BaseTest;

import io.restassured.response.Response;
import utils.ExtentTestNGListener;
import utils.JsonUtils;

public class LogoutAPI extends BaseTest{
	@Test(priority = 2)
	public void verifyvalidLogout()
	{
		
		// 🔹 Read JSON file → POJO
	    LogoutRequest logoutRequest = JsonUtils.readJsonToPojo(
	            "src\\main\\resources\\testData\\logoutRequest.json",
	            LogoutRequest.class
	    );
		
		
		

	    ExtentTestNGListener.getTest().info("Request Body: " + logoutRequest.getUserNameId());

	    Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(logoutRequest)
	            .when()
	            .post("/api/Account/LogOut")
	            .then()
	            .statusCode(200)
	            .extract().response();

	    //System.out.println("Response: " + response.asString());
	    response.prettyPrint();
	    response.then().extract().response();

		// Print complete response
		//System.out.println(response.asPrettyString());
		
		
		
		String message = response.jsonPath().getString("message");
	    String errorcode = response.jsonPath().getString("errorCode");
	  

	    response.prettyPrint();
	    response.then().extract().response();

		

		
		ExtentTestNGListener.getTest().info("Message: " + message);
		ExtentTestNGListener.getTest().info("ErrorCode: " + errorcode);
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        ExtentTestNGListener.hardassertwithinteger(response.getStatusCode(), 200);
        ExtentTestNGListener.hardassertwithstring(message, "Logout successfully.");
        ExtentTestNGListener.hardassertwithstring(errorcode, "null");
        
        
        

		
		
}
        


	
	
	@Test(priority = 1)
	public void verifyLogoutwithinvalidUserid()
	{
	    String requestBody = "{\r\n"
	    		+ "  \"userNameId\": \"35cd3d6d-f0bd-4e27-8a95-237ea715355a\"\r\n"
	    		+ "}";
	    ExtentTestNGListener.getTest().info("Request Body: " + requestBody);

	    Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestBody)
	            .when()
	            .post("/api/Account/LogOut")
	            .then()
	            .statusCode(404)
	            .extract().response();


	    response.prettyPrint();
	    response.then().extract().response();

		String message = response.jsonPath().getString("message");
	    String errorcode = response.jsonPath().getString("errorCode");
	  
	    response.prettyPrint();
	    response.then().extract().response();

		

		
		ExtentTestNGListener.getTest().info("Message: " + message);
		ExtentTestNGListener.getTest().info("ErrorCode: " + errorcode);
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        ExtentTestNGListener.hardassertwithinteger(response.getStatusCode(), 404);
        ExtentTestNGListener.hardassertwithstring(message, "User not found.");
        ExtentTestNGListener.hardassertwithstring(errorcode, "NotFound");
        

}

}
