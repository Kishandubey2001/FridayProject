package utils;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentTestNGListener implements ITestListener{
	private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("Test Failed");
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public static ExtentTest getTest() {
        return test.get();
    }
    
    
    

    public static void hardassertwithstring(String actualvalue, String expectedvalue)
    {
        try {

            Assert.assertEquals(actualvalue, expectedvalue);
            ExtentTestNGListener.getTest()
                    .info("👍 Assertion Passed: Actual " + actualvalue +
                            " is matched with expected " + expectedvalue);

        } catch (AssertionError e) {

            ExtentTestNGListener.getTest()
                    .info("😒 Assertion Failed: Actual " + actualvalue +
                            " is not matched with expected " + expectedvalue);

            String message = e.getMessage();

            String exceptionMessage;

            if (message != null && message.contains("\n")) {
                exceptionMessage = message.substring(0, message.indexOf("\n"));
            } else {
                exceptionMessage = message;   // safe fallback
            }

            ExtentTestNGListener.getTest()
                    .fail("Exception occurred: " + exceptionMessage);

            throw e;
        }
    }
	
	
	
	public static void hardassertwithinteger(int actualvalue,int expectedvalue)
	{
		
		try {
			
			Assert.assertEquals(actualvalue, expectedvalue);
			ExtentTestNGListener.getTest().info("👍 Assertion Passed: Actual "+actualvalue +" is matched with expected "+expectedvalue+"");

		} catch (AssertionError e) {
			
			ExtentTestNGListener.getTest().info("😒 Assertion Failed: Actual "+actualvalue +" is not matched with expected "+expectedvalue+"");

			String exceptionMessage = e.getMessage().substring(0, e.getMessage().indexOf("\n"));
			ExtentTestNGListener.getTest().fail("Exception occurred: " +exceptionMessage );


			throw e; 
		}
	}
	
	
	public static void hardassertwithboolean(boolean actualvalue,boolean expectedvalue)
	{
		
		try {
			
			Assert.assertEquals(actualvalue, expectedvalue);
			ExtentTestNGListener.getTest().info("👍 Assertion Passed: Actual "+actualvalue +" is matched with expected "+expectedvalue+"");

		} catch (AssertionError e) {
			
			ExtentTestNGListener.getTest().info("😒 Assertion Passed: Actual "+actualvalue +" is matched with expected "+expectedvalue+"");

			String exceptionMessage = e.getMessage().substring(0, e.getMessage().indexOf("\n"));
			ExtentTestNGListener.getTest().fail("Exception occurred: " +exceptionMessage );


			throw e; 
		}
	}
	
	
	
	//  This method is print the element in extend report

	public void printmethod(String putstring)
	{
		ExtentTestNGListener.getTest().info(putstring);	
	}
 
    
}
