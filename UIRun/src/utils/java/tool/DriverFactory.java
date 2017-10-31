package tool;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverFactory {
	
	public static AndroidDriver<?> driverA;
	public static IOSDriver<?> driverI;
	public static WebDriver driverW;
	static Logger log = Logger.getLogger(DriverFactory.class.getName());

	/**
	 * android手机启动
	 * @param apkName
	 * @param appActivity
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static AndroidDriver<?> createAndroidDriver(String apkName, String appActivity) {

		File apk = new File(System.getProperty("user.dir") + File.separator + "apps" + File.separator + apkName);

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "HUAWEI Mate 8");

		capabilities.setCapability("platformVersion", "7.0");

		capabilities.setCapability("app", apk);

		capabilities.setCapability("appActivity", appActivity);

		capabilities.setCapability("noSign", true);

		capabilities.setCapability("noReset", true);

		capabilities.setCapability("unicodeKeyboard", "True");

		capabilities.setCapability("resetKeyboard", "True");

		try {
			driverA = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			log.info("APP启动成功");
		} catch (MalformedURLException e) {
			log.error("APP启动失败");
		}
		
		return driverA;
	}
	
	
	/**
	 * web浏览器启动
	 * @param browser
	 * @param url
	 * @return
	 */
	public static WebDriver createWebDriver(String browser ,String url) {
		
		if(browser=="Firefox") {
			driverW = new FirefoxDriver();      //火狐的驱动配置
		}else if(browser=="Chrome") {
			driverW = new ChromeDriver();       //谷歌浏览器驱动配置
		}else if(browser=="IE") {
			driverW = new InternetExplorerDriver();   //IE浏览器驱动配置
		}else if(browser=="Edge") {
			driverW = new EdgeDriver();      //Edge浏览器驱动配置
		}else if(browser=="Opera") {
			driverW = new OperaDriver();    //Opera浏览器驱动配置
		}else if(browser=="PhantomJS") {
			driverW = new PhantomJSDriver();     //PhantomJS浏览器驱动配置
		}else {
			log.error("web启动无适配浏览器");
		}
		try {
			driverW.get(url);
			log.info("web启动成功");
		} catch (Exception e) {
			log.error("web启动失败");
		}
		 
		return driverW;
	}

}
