package fictionWeb;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import tool.DriverFactory;
import web.TestNGListener;

@Listeners({TestNGListener.class})
public class LoginTest {
	WebDriver driverW;
  @Test
  public void loginUser() throws Exception { 
	  
	  new Login(driverW).loginUser();
	  String l = new Login(driverW).loginSucceed(); 
	  Assert.assertEquals(l, "登录成功");   //断言登录后的提示信息是否是“登录成功”

  }
  @BeforeClass
  public void beforeClass() {  
	driverW = DriverFactory.createWebDriver("Firefox", "http://test.xiaoshuo2.hunwater.com/index.php/user/login_out?t=1506564953062753");
	TestNGListener.setDriver(driverW);
  }

  @AfterClass
  public void afterClass() {
	  driverW.quit();
  }

}
