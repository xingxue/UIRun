package tool;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 用例失败重跑逻辑
 * @author xingxue
 *
 */
public class TestNGRetry implements IRetryAnalyzer {
    public Logger log = Logger.getLogger(TestNGRetry.class.getName());
    private int retryCount = 1;
    private int maxRetryCount=2;


    public boolean retry(ITestResult result) {
        if (retryCount <= maxRetryCount) {
			String message = "running retry for  '" + result.getName() + "' on class " + 
                                       this.getClass().getName() + " Retrying " + retryCount + " times";
            log.info(message);
            retryCount++;
            return true;
        }
        return false;
    }
}