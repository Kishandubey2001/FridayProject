package workFlowAPI;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.test.BaseTest;

import io.restassured.response.Response;
import net.bytebuddy.utility.RandomString;
import utils.ExtentTestNGListener;

public class UpdateWorkFlow extends BaseTest{
	

	String radomStringupdated=     RandomString.make(10);
	//  public static String  id;
	@Test(priority = 1)
	public void verifyformCreate()
	{
//		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6ImtrZHViZXlAZ2VkdXNlcnZpY2VzLmNvbSIsIlVzZXJOYW1lIjoiS2lzaGFuIER1YmV5IiwiVXNlckVtYWlsSWQiOiJra2R1YmV5QGdlZHVzZXJ2aWNlcy5jb20iLCJVc2VyTmFtZUlkIjoiOTk5NzdlODItNDcxMS00YTNjLWFlOTItMDA4ZDgwZjQzY2QxIiwiSXNTU08iOiIiLCJJbnN0aXR1dGVOYW1lIjoiSUNJQ0kgUHJpdmF0ZSBMaW1pdGVkIiwiVXNlclBlcm1pc3Npb25zIjoiIiwiSW5zdGl0dXRlTG9nbyI6Imh0dHBzOi8vc21zYmxvYnN0b3JhZ2VhY2NvdW50ZGV2LmJsb2IuY29yZS53aW5kb3dzLm5ldC9zbXNmaWxlY29udGFpbmVycWEvYjE5NmY3YzgtYjdkZS00OTdhLTljYzktYWMyOTJhYWZhMTVjLnBuZyIsIlVzZXJSb2xlTmFtZSI6IkFwcCBEZXZlbG9wZXIiLCJVc2VyUm9sZUlkIjoiYjlhZDNjMjctNWUxYS00YTU4LTkwOTUtYTI2MDM2YzljNWM2IiwiRGF0ZUZvcm1hdCI6Ik1NL0REL1lZWVkiLCJUaW1lRm9ybWF0IjoiSDptbSIsIlNlbGVjdGVkSW5zdGl0dXRlIjoiMjQzOTVkMTktNGEwZC00MWZlLTk1MDgtODQ5N2U5MzM4ODljIiwiQXBwTG9nbyI6IiIsIk9yZ0xvZ28iOiIiLCJJc09yZ2FuaXphdGlvblVzZXIiOiJmYWxzZSIsIm5iZiI6MTc2MzYyNjc3OCwiZXhwIjoxNzY0MjMxNTc4LCJpYXQiOjE3NjM2MjY3Nzh9.ccCwCUwgwaFZi0_jWNPQpABkfumlUxBmAv3ohj4wcyM";   // use from login API response
//
//	    RestAssured.baseURI = "https://qa-apigateway-sms.geduservices.com";
//	    RestAssured.useRelaxedHTTPSValidation();  // FIX SSL ERROR

	    String requestBody = "{\r\n"
	    		+ "  \"id\": \""+CreateWorkFlow.id+"\",\r\n"
	    		+ "  \"workflowName\": \""+radomStringupdated+"\",\r\n"
	    		+ "  \"description\": \"This is update api\",\r\n"
	    		+ "  \"workflowTriggers\": \"\",\r\n"
	    		+ "  \"workflowJson\": \"\"\r\n"
	    		+ "}";
	    ExtentTestNGListener.getTest().info("Request Body: " + requestBody);


	    Response response = given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", "Bearer " + token)
	            .header("origin", "https://qa-sms.geduservices.com")
	            .body(requestBody)
	            .when()
	            .put("/api/Workflow/UpdateWorkflow")
	            .then()
	            .statusCode(200)
	            .extract().response();

	    System.out.println("Response: " + response.asString());
	    response.prettyPrint();
	    response.then().extract().response();

		// Print complete response
		System.out.println(response.asPrettyString());

		
		
		ExtentTestNGListener.getTest().info("Status Code: " + response.getStatusCode());
		//ExtentTestNGListener.getTest().info("Response Body: " + response.getBody().asPrettyString());
		ExtentTestNGListener.getTest().info("Response Time(ms): " + response.getTime());

      Assert.assertEquals(response.getStatusCode(), 200, "Expected Status Code is 200");
	    
//	    String id = response.jsonPath().getString("id");
//     System.out.println("Extracted ID: " + id);
	}

}
