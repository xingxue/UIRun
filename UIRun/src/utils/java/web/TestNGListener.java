package web;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestNGListener extends TestListenerAdapter {
	 private static WebDriver driverW;  
	  
	    Logger log = Logger.getLogger(TestNGListener.class.getName());
	  
	    public static void setDriver(WebDriver driverW) {  
	        TestNGListener.driverW = driverW;  
	    } 
	    
	    
	    @Override  
	    public void onTestFailure(ITestResult tr) {  
	        log.error("Test Failure------------- : " + tr.getName());  
	        log.info("异常原因：     " + tr.getThrowable().toString());
	        super.onTestFailure(tr);  
	        try {
	        	ScreenShot screenShot = new ScreenShot(driverW);
		        screenShot.getScreenShot(tr);
			} catch (Exception e) {
				log.error("截屏失败");
			}
	        
	        driverW.navigate().back();
	    }  
	    
	    public void onTestSuccess(ITestResult tr) {
	    	log.info("Test Success--------------- : " + tr.getName());  
	        super.onTestSkipped(tr);  
	    }
	  
	    @Override  
	    public void onTestSkipped(ITestResult tr) {  
	        log.error("Test Skipped");  
	        log.info("异常原因：     " + tr.getThrowable().toString());
	        super.onTestSkipped(tr);  
	    }  
	  
	    @Override  
	    public void onStart(ITestContext testContext) {  
	        log.info("Test Start");  
	        super.onStart(testContext);  
	    }  
	  
	    @Override  
	    public void onFinish(ITestContext testContext) {  
	        log.info("Test Finish");  
	        super.onFinish(testContext);  
	        //重跑去重处理
	         Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();  
	        while (listOfFailedTests.hasNext()) {  
	        ITestResult failedTest = (ITestResult) listOfFailedTests.next();  
	         ITestNGMethod method = failedTest.getMethod();  
	            if (testContext.getFailedTests().getResults(method).size() > 1) {  
	                    listOfFailedTests.remove();  
	                    }   
	            else {  
	                    if (testContext.getPassedTests().getResults(method).size() > 0) {  
	                    listOfFailedTests.remove();  
	            }  
	            }
	            }
	    }  

}
