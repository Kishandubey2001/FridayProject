package com.api.Logout;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.pojo.LogoutRequest;
import com.api.test.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import utils.APIReusable;
import utils.ExtentTestNGListener;
import utils.JsonUtils;

public class LogoutAPI extends BaseTest{
	
	APIReusable apir;
	
	@Test(priority = 2)
	public void verifyvalidLogout() throws JsonProcessingException
	{
		
		 apir=	  new APIReusable();
		
		// 🔹 Read JSON file → POJO
	    LogoutRequest logoutRequest = JsonUtils.readJsonToPojo(
	            "src\\main\\resources\\testData\\logoutRequest.json",
	            LogoutRequest.class
	            
	    );
	    ObjectMapper mapper=     new ObjectMapper();
	    String logoutPayload = mapper.writeValueAsString(logoutRequest);
		
	    apir.postmethod(token, logoutPayload, "/api/Account/LogOut", 200);

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

		
		String message = response.jsonPath().getString("message");
	    String errorcode = response.jsonPath().getString("errorCode");
	  
		
		ExtentTestNGListener.getTest().info("Message: " + message);
		ExtentTestNGListener.getTest().info("ErrorCode: " + errorcode);
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

        ExtentTestNGListener.hardassertwithinteger(response.getStatusCode(), 200);
        ExtentTestNGListener.hardassertwithstring(message, "Logout successfully.");
        ExtentTestNGListener.hardassertwithstring(errorcode, null);
      
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



		String message = response.jsonPath().getString("message");
	    String errorcode = response.jsonPath().getString("errorCode");

		
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
