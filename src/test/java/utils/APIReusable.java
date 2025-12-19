package utils;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class APIReusable {
	
	
	public Response postmethod(String token,String requestbody,String apiEndPoint,int statuscode)
	{
		Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestbody)
	            .when()
	            .post(apiEndPoint)
	            .then()
	            .statusCode(statuscode)
	            .extract().response();
		return response;
	}
	
	
	public Response getmethod(String token,String apiEndPoint,int statuscode)
	{
		Response response = given()
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .header("origin", "https://qa-sms.geduservices.com")
	            .when()
	            .get(apiEndPoint)   // API URL
	            .then()
	            .statusCode(statuscode)  // Validate successful response
	            .extract().response();
		
		return response;

	}
	
	
	public Response putmethod(String token,String requestBody,String apiEndPoint,int statuscode)
	{
		Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestBody)
	            .when()
	            .put(apiEndPoint)
	            .then()
	            .statusCode(200)
	            .extract().response();
		return response;
	}

}
