package com.api.test;

import io.restassured.RestAssured;

public class DummyRest {
	
	public void verifycreate()
	{
		RestAssured.baseURI="https://reqres.in/";
		String requestbody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
	}

}
