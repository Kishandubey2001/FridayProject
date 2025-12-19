package com.api.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import utils.ExtentManager;

public class BaseTest {
	 public static String token;
	   // public static String formId;

	    @BeforeClass
	    public void setup() {
	        RestAssured.baseURI = "https://qa-apigateway-sms.geduservices.com";
	        RestAssured.useRelaxedHTTPSValidation();

	        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImtrZHViZXlAZ2VkdXNlcnZpY2VzLmNvbSIsIlVzZXJOYW1lIjoiS2lzaGFuIER1YmV5IiwiVXNlckVtYWlsSWQiOiJra2R1YmV5QGdlZHVzZXJ2aWNlcy5jb20iLCJVc2VyTmFtZUlkIjoiOTk5NzdlODItNDcxMS00YTNjLWFlOTItMDA4ZDgwZjQzY2QxIiwiVXNlclBlcm1pc3Npb25zIjoiIiwiVXNlclJvbGVOYW1lIjoiQXBwIERldmVsb3BlciIsIlVzZXJSb2xlSWQiOiIwNjI3NjY3MC1lM2Q0LTQ4YzItODAxMC1jODNhNjRlMjg2N2YiLCJJc1NTTyI6IiIsIkluc3RpdHV0ZU5hbWUiOiJBcnRpZmljaWFsIGludGVsbGlnZW5jZSIsIkluc3RpdHV0ZUxvZ28iOiJodHRwczovL3Ntc2Jsb2JzdG9yYWdlYWNjb3VudGRldi5ibG9iLmNvcmUud2luZG93cy5uZXQvc21zZmlsZWNvbnRhaW5lcnFhL2M1N2JlOGI4LTVlYTktNDYyZi05ZDA1LWM3NGRhOWM3YzFhZS5qcGVnIiwiRGF0ZUZvcm1hdCI6Ik1NL0REL1lZWVkiLCJUaW1lRm9ybWF0IjoiSDptbSIsIlNlbGVjdGVkSW5zdGl0dXRlIjoiMDM2MzkzMjQtNTM1OS00NThiLThhMWUtOTIyZWFkNzAwM2QwIiwiQXBwTG9nbyI6IiIsIk9yZ0xvZ28iOiIiLCJJc09yZ2FuaXphdGlvblVzZXIiOiJmYWxzZSIsIm5iZiI6MTc2NDIzNDUyOSwiZXhwIjoxNzY0ODM5MzI5LCJpYXQiOjE3NjQyMzQ1Mjl9.cMfFuOBF1VKRlonby3qTYE-OFSH35dQmuldB4OblOdk";  // Or fetch dynamically
	    }
	    
	    
	    @AfterClass
	    public void teardown() {
	        System.out.println("----- Generating Report -----");
	        ExtentManager.getInstance().flush();
	    }
	
	
	
	
	
	
	
	
	
	}


