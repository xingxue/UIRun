package web;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import tool.GetTime;

public class ScreenShot {
	 private WebDriver driverW;  
	  
	    public ScreenShot(WebDriver driverW) {  
	        this.driverW = driverW;  
	    }  

	    	public void getScreenShot(ITestResult tr) {  
	            Logger log = Logger.getLogger(ScreenShot.class.getName());
	    		  //获取当前时间
	    		String className = tr.getName();
	            String curTime = new GetTime().getNewTime();
	    		 //设置截图不经和文件名称 
	            String path = System.getProperty("user.dir") + "/img/"+ className + curTime + ".png";  
	            //TakesScreenshot接口是依赖于具体的浏览器API操作的，所以在HTMLUnit Driver中并不支持该操作  
	            TakesScreenshot tScreenshot = (TakesScreenshot)driverW;  
	            // 截图  
	            File photo = tScreenshot.getScreenshotAs(OutputType.FILE);  
	            File shotFile = new File(path);  
	            try {  
	                // 将截图复制到指定目录  
	                FileUtils.copyFile(photo, shotFile);
	                log.info("截屏路径 : " + path);
 
	            } catch (IOException e) {  
	                log.error(getClass() + " 保存截图失败");  
	                e.printStackTrace();  
	            }  
	        }    
}
