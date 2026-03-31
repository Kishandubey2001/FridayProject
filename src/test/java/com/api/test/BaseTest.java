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

	        token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImtrZHViZXlAZ2VkdXNlcnZpY2VzLmNvbSIsIlVzZXJOYW1lIjoiS2lzaGFuIEt1bWFyIER1YmV5IiwiVXNlckVtYWlsSWQiOiJra2R1YmV5QGdlZHVzZXJ2aWNlcy5jb20iLCJVc2VyTmFtZUlkIjoiNWE3YmY0ODgtY2Q0Ni00NWQyLWFhMDUtZjA2MjE2Y2EzZmNlIiwiSXNTU08iOiIiLCJJbnN0aXR1dGVOYW1lIjoiUFJJU01TLVFBIiwiVXNlclBlcm1pc3Npb25zIjoiIiwiSW5zdGl0dXRlTG9nbyI6Imh0dHBzOi8vc21zYmxvYnN0b3JhZ2VhY2NvdW50ZGV2LmJsb2IuY29yZS53aW5kb3dzLm5ldC9zbXNmaWxlY29udGFpbmVycWEvNTY2N2ZkODctNGRhYi00YTI0LWFlZjctM2ExZDdhMWY1M2RjLmpwZyIsIlVzZXJSb2xlTmFtZSI6IkFwcCBEZXZlbG9wZXIiLCJVc2VyUm9sZUlkIjoiNGZmNTQ4MDctMTYyOS00ZGZjLTg1NzgtYWY1NWJkNzkwMzQxIiwiRGF0ZUZvcm1hdCI6Ik1NL0REL1lZWVkiLCJUaW1lRm9ybWF0IjoiSDptbSIsIlNlbGVjdGVkSW5zdGl0dXRlIjoiNDQ5NjU4YjktMWUzMS00YTQyLThlMGItODJmYjRhOGU4MjZmIiwiQXBwTG9nbyI6IiIsIk9yZ0xvZ28iOiJodHRwczovL3Ntc2Jsb2JzdG9yYWdlYWNjb3VudGRldi5ibG9iLmNvcmUud2luZG93cy5uZXQvc21zZmlsZWNvbnRhaW5lcnFhLzU2NjdmZDg3LTRkYWItNGEyNC1hZWY3LTNhMWQ3YTFmNTNkYy5qcGciLCJJc1BQQWNjZXB0ZWQiOiJmYWxzZSIsIklzT3JnYW5pemF0aW9uVXNlciI6ImZhbHNlIiwibmJmIjoxNzcwMjg3MTU0LCJleHAiOjE3NzA4OTE5NTQsImlhdCI6MTc3MDI4NzE1NH0.7Y7PcznLVtO6JTyrolmvNRmDwtCm07vNzAnCxaaRkrI";  // Or fetch dynamically
	    }
	    
	    
	    @AfterClass
	    public void teardown() {
	        System.out.println("----- Generating Report -----");
	        ExtentManager.getInstance().flush();
	    }
	
	
	
	
	
	
	
	
	
	}


