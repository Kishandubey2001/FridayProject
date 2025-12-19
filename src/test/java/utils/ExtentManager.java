package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    public static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
        	String date = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss_a")
                    .format(new Date());

           // String reportPath = System.getProperty("user.dir") + "/reports/ApiReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports//NewReport_" + date + ".html");
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setReportName("API Automation Report");
            reporter.config().setDocumentTitle("API Test Execution");

         // Custom Styling
            reporter.config().setCss(".report-name { font-size:26px; color:#00E676; }"
                 + ".status.pass { background-color:#00C853 !important; }"
                 + ".status.fail { background-color:#D50000 !important; }"
                 + "body { font-family:Arial; }");
         // Custom JS
            reporter.config().setJs("document.title='Kishan Test Report';");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Kishan");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("Browser", "Chrome 122");

            // Finally
            System.out.println("✨ Beautiful Extent Report Created Successfully!");
            
            
            
        }
        return extent;
    }
    
    
    
    
    
    
    
     
    
    
    
    
    
    

}
