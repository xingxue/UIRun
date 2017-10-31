package englishLolly;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import tool.DriverFactory;
import web.TestNGListener;
import web.WebBasePage;

@Listeners({TestNGListener.class})
public class LoginTest {
	WebDriver driverW;
	Logger log = Logger.getLogger(LoginTest.class.getName());
	
  @Parameters({ "userName_E", "pwd_E"})
  @Test(description = "正常登陆成功")
  public void loginUser(String userName, String pwd) throws Exception {
	  new Login(driverW).loginUser(userName, pwd);
	  Assert.assertTrue(new WebBasePage(driverW, "FirstPageEnglish").isElementDisplayed("英语首页用户名", 5));  //验证登陆成功后是否显示用户名称
  }
  
  @Test(description = "退出登陆")
  public void logout() throws Exception {
	  new Login(driverW).logout();
	  String alertText = new WebBasePage(driverW, "loginPageEnglish").getText("英语退出登陆成功", 5);
	  log.info("退出登陆提示信息 : "+alertText);
	  Assert.assertEquals(alertText, "退出成功!");  //验证退出登陆成功后抓取弹出框是否提示“退出成功！”
      Assert.assertTrue(new WebBasePage(driverW, "loginPageEnglish").isElementDisplayed("英语登录确认按钮", 5));   //验证是否真实退出登陆页面，验证确认登陆按钮是否存在
  }
  
  
  @Parameters({ "userName_E", "pwdNull_E"})
  @Test(description = "密码为空登陆")
  public void pwdNull(String userName_E, String pwdNull_E) throws Exception {
	  new Login(driverW).loginUser(userName_E, pwdNull_E);
	  String alertText = new WebBasePage(driverW, "loginPageEnglish").getText("英语账号异常", 5);
	  log.info("密码为空提示信息  : "+alertText);
	  Assert.assertEquals(alertText, "密码长度不对");   //验证密码为空时的提示信息是否正确
	  Assert.assertTrue(new WebBasePage(driverW, "loginPageEnglish").isElementDisplayed("英语登录确认按钮", 5));    //验证点击登陆按钮还留在登陆页面
  }
  
  @Parameters({ "userNameNull_E", "pwdNull_E"})
  @Test(description = "手机为空登陆")
  public void loginUserPhoneNull(String userNameNull_E, String pwd_E) throws Exception {
	  new Login(driverW).loginUser(userNameNull_E, pwd_E);
	  String alertText = new WebBasePage(driverW, "loginPageEnglish").getText("英语账号异常", 5);
	  log.info("手机号为空提示信息  : "+alertText);
	  Assert.assertEquals(alertText, "手机号码格式错误");   //验证手机号为空时的提示信息是否正确
	  Assert.assertTrue(new WebBasePage(driverW, "loginPageEnglish").isElementDisplayed("英语登录确认按钮", 5));    //验证点击登陆按钮还留在登陆页面
  }
  
  @Parameters({ "userNameError_E", "pwdError_E"})
  @Test(description = "手机不存在登陆")
  public void loginUserPhoneError(String userNameError_E, String pwdError_E) throws Exception {
	  new Login(driverW).loginUser(userNameError_E, pwdError_E);
	  String alertText = new WebBasePage(driverW, "loginPageEnglish").getText("英语账号异常", 5);
	  log.info("手机号不存在提示信息  : "+alertText);
	  Assert.assertEquals(alertText, "用户不存在");   //验证手机号不存在时的提示信息是否正确
	  Assert.assertTrue(new WebBasePage(driverW, "loginPageEnglish").isElementDisplayed("英语登录确认按钮", 5));    //验证点击登陆按钮还留在登陆页面
  }
  
  @Parameters({ "userNameFormatError_E", "pwdNull_E"})
  @Test(description = "手机号格式不正确登陆")
  public void loginUserPhoneFormatError(String userNameFormatError_E, String pwdNull_E) throws Exception {
	  new Login(driverW).loginUser(userNameFormatError_E, pwdNull_E);
	  String alertText = new WebBasePage(driverW, "loginPageEnglish").getText("英语账号异常", 5);
	  log.info("手机号格式不正确提示信息  : "+alertText);
	  Assert.assertEquals(alertText, "手机号码格式错误");   //验证手机号格式不正确时的提示信息是否正确
	  Assert.assertTrue(new WebBasePage(driverW, "loginPageEnglish").isElementDisplayed("英语登录确认按钮", 5));    //验证点击登陆按钮还留在登陆页面
  }
  
  @Parameters({ "userName_E", "pwdError_E"})
  @Test(description = "密码错误登陆")
  public void pwdError(String userName_E, String pwdError_E) throws Exception {
	  new Login(driverW).loginUser(userName_E, pwdError_E);
	  String alertText = new WebBasePage(driverW, "loginPageEnglish").getText("英语账号异常", 5);
	  log.info("密码错误提示信息  : "+alertText);
	  Assert.assertEquals(alertText, "密码错误");   //验证密码为空时的提示信息是否正确
	  Assert.assertTrue(new WebBasePage(driverW, "loginPageEnglish").isElementDisplayed("英语登录确认按钮", 5));    //验证点击登陆按钮还留在登陆页面
  }
  
  @Parameters({ "userName_E", "pwdFormatError_E"})
  @Test(description = "密码格式不对登陆")
  public void pwdFormatError (String userName_E, String pwdFormatError_E) throws Exception {
	  new Login(driverW).loginUser(userName_E, pwdFormatError_E);
	  String alertText = new WebBasePage(driverW, "loginPageEnglish").getText("英语账号异常", 5);
	  log.info("密码格式错误提示信息  : "+alertText);
	  Assert.assertEquals(alertText, "密码长度不对");   //验证密码为空时的提示信息是否正确
	  Assert.assertTrue(new WebBasePage(driverW, "loginPageEnglish").isElementDisplayed("英语登录确认按钮", 5));    //验证点击登陆按钮还留在登陆页面
  }
  
  @Parameters({ "userName_E", "pwd_E"})
  @Test(description = "不勾选记住密码功能测试")
  public void pwdRemenber1 (String userName, String pwd) throws Exception {
	  if(new Login(driverW).pwdRemenber()==true) {
		  new WebBasePage(driverW, "loginPageEnglish").click("记住密码按钮");
	  }
	  new Login(driverW).loginUser(userName, pwd);  
	  new Login(driverW).logout();
	  String pwdText = new WebBasePage(driverW, "loginPageEnglish").getAttribute("英语登录密码");
	  log.info("密码内容 :"+pwdText);
	  Assert.assertEquals(pwdText, "");
  }
  
  @Parameters({ "userName_E", "pwd_E"})
  @Test(description = "勾选记住密码功能测试")
  public void pwdRemenber2 (String userName, String pwd) throws Exception {
	  if(new Login(driverW).pwdRemenber()==false) {
		  new WebBasePage(driverW, "loginPageEnglish").click("记住密码按钮");
	  }
	  new Login(driverW).loginUser(userName, pwd);  
	  new Login(driverW).logout();
	  String pwdText = new WebBasePage(driverW, "loginPageEnglish").getAttribute("英语登录密码");
	  log.info("密码内容 : "+pwdText);
	  Assert.assertEquals(pwdText, pwd);
  }
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  driverW = DriverFactory.createWebDriver("Firefox", "http://notadmin.hunyuedu.com/#/login");
	  TestNGListener.setDriver(driverW);
  }

  @AfterClass
  public void afterClass() {
	  driverW.quit();
  }

}
