package com.api.test;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class APIUtils {
	
	public Response postRequest(String token,String requestBody,int statuscode)
	{
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
		return response;
	}

}
