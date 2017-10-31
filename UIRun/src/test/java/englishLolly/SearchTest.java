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
public class SearchTest {
	
	WebDriver driverW;
	Logger log = Logger.getLogger(LoginTest.class.getName());
	
  @Parameters({ "userName_E", "pwd_E", "searchData_ID"})
  @Test(description = "助教ID搜索测试")
  public void searchZJID(String userName, String pwd, String searchData_ID) throws Exception {
	  new Login(driverW).loginUser(userName, pwd);
	  Assert.assertTrue(new Search(driverW).searchABCSame("TeacherPageEnglish","助教助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).search123Same("TeacherPageEnglish","助教助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchChinaSame("TeacherPageEnglish","助教助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchCharSame("TeacherPageEnglish","助教助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchMoreSame("TeacherPageEnglish","助教助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchTrueSame(searchData_ID,"TeacherPageEnglish","助教助教ID内容","FirstPageEnglish"));
  }
  
  @Parameters({ "userName_E", "pwd_E", "searchData_nicheng"})
  @Test(description = "助教昵称搜索测试")
  public void searchZJNC(String userName, String pwd, String searchData_nicheng) throws Exception { 
	  new Login(driverW).loginUser(userName, pwd);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语搜索分类",5);
	  Thread.sleep(500);
	  new WebBasePage(driverW, "TeacherPageEnglish").click("助教昵称",5);
	  Assert.assertTrue(new Search(driverW).searchABCLikeness("TeacherPageEnglish","助教助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).search123Likeness("TeacherPageEnglish","助教助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchChinaLikeness("TeacherPageEnglish","助教助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchCharLikeness("TeacherPageEnglish","助教助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchMoreLikeness("TeacherPageEnglish","助教助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchTrueLikeness(searchData_nicheng,"TeacherPageEnglish","助教助教昵称内容","FirstPageEnglish"));
  }
  
  @Parameters({ "userName_E", "pwd_E", "searchData_weixin"})
  @Test(description = "助教微信搜索测试")
  public void searchZJWX(String userName, String pwd, String searchData_weixin) throws Exception { 
	  new Login(driverW).loginUser(userName,pwd);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语搜索分类",5);
	  Thread.sleep(500);
	  new WebBasePage(driverW, "TeacherPageEnglish").click("助教微信",5);
	  Assert.assertTrue(new Search(driverW).searchABCLikeness("TeacherPageEnglish","助教助教微信内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).search123Likeness("TeacherPageEnglish","助教助教微信内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchChinaLikeness("TeacherPageEnglish","助教助教微信内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchCharLikeness("TeacherPageEnglish","助教助教微信内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchMoreLikeness("TeacherPageEnglish","助教助教微信内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchTrueLikeness(searchData_weixin,"TeacherPageEnglish","助教助教微信内容","FirstPageEnglish"));
  }
  
  @Parameters({ "userName_E", "pwd_E", "searchData_ID"})
  @Test(description = "班级助教ID搜索测试")
  public void searchClassZJWX(String userName, String pwd, String searchData_ID) throws Exception { 
	  new Login(driverW).loginUser(userName,pwd);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语班级群管理",5);
	  Assert.assertTrue(new Search(driverW).searchABCSame("ClassPageEnglish","班级助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).search123Same("ClassPageEnglish","班级助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchChinaSame("ClassPageEnglish","班级助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchCharSame("ClassPageEnglish","班级助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchMoreSame("ClassPageEnglish","班级助教ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchTrueSame(searchData_ID,"ClassPageEnglish","班级助教ID内容","FirstPageEnglish"));
  }
  
  @Parameters({ "userName_E", "pwd_E", "searchData_nicheng"})
  @Test(description = "助教昵称搜索测试")
  public void searchClassZJNC(String userName, String pwd, String searchData_nicheng) throws Exception { 
	  new Login(driverW).loginUser(userName,pwd);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语班级群管理",5);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语搜索分类",5);
	  Thread.sleep(500);
	  new WebBasePage(driverW, "ClassPageEnglish").click("助教名称",5);
	  Assert.assertTrue(new Search(driverW).searchABCLikeness("ClassPageEnglish","班级助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).search123Likeness("ClassPageEnglish","班级助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchChinaLikeness("ClassPageEnglish","班级助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchCharLikeness("ClassPageEnglish","班级助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchMoreLikeness("ClassPageEnglish","班级助教昵称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchTrueLikeness(searchData_nicheng,"ClassPageEnglish","班级助教昵称内容","FirstPageEnglish"));
  }
  
  @Parameters({ "userName_E", "pwd_E", "searchID_qun"})
  @Test(description = "群ID搜索测试")
  public void searchClassID(String userName, String pwd, String searchID_qun) throws Exception { 
	  new Login(driverW).loginUser(userName,pwd);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语班级群管理",5);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语搜索分类",5);
	  Thread.sleep(500);
	  new WebBasePage(driverW, "ClassPageEnglish").click("群ID",5);
	  Assert.assertTrue(new Search(driverW).searchABCLikeness("ClassPageEnglish","班级群ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).search123Likeness("ClassPageEnglish","班级群ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchChinaLikeness("ClassPageEnglish","班级群ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchCharLikeness("ClassPageEnglish","班级群ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchMoreLikeness("ClassPageEnglish","班级群ID内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchTrueLikeness(searchID_qun,"ClassPageEnglish","班级群ID内容","FirstPageEnglish"));
  }
  
  @Parameters({ "userName_E", "pwd_E", "searchName_qun"})
  @Test(description = "群名称搜索测试")
  public void searchClassName(String userName, String pwd, String searchName_qun) throws Exception { 
	  new Login(driverW).loginUser(userName,pwd);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语班级群管理",5);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语搜索分类",5);
	  Thread.sleep(500);
	  new WebBasePage(driverW, "ClassPageEnglish").click("群名称",5);
	  Assert.assertTrue(new Search(driverW).searchABCLikeness("ClassPageEnglish","班级群名称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).search123Likeness("ClassPageEnglish","班级群名称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchChinaLikeness("ClassPageEnglish","班级群名称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchCharLikeness("ClassPageEnglish","班级群名称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchMoreLikeness("ClassPageEnglish","班级群名称内容","FirstPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchTrueLikeness(searchName_qun,"ClassPageEnglish","班级群名称内容","FirstPageEnglish"));
  }
  
  @Parameters({ "userName_E", "pwd_E", "searchData_user"})
  @Test(description = "订单用户昵称搜索测试")
  public void searchOrderYHNC(String userName, String pwd, String searchData_user) throws Exception { 
	  new Login(driverW).loginUser(userName,pwd);
	  new WebBasePage(driverW, "FirstPageEnglish").click("英语订单信息",5);
//	  Assert.assertTrue(new Search(driverW).searchABCSame("ClassPageEnglish","用户昵称内容","OrdersPageEnglish")); 
//	  Assert.assertTrue(new Search(driverW).search123Same("ClassPageEnglish","用户昵称内容","OrdersPageEnglish")); 
//	  Assert.assertTrue(new Search(driverW).searchChinaSame("ClassPageEnglish","用户昵称内容","OrdersPageEnglish")); 
//	  Assert.assertTrue(new Search(driverW).searchCharSame("ClassPageEnglish","用户昵称内容","OrdersPageEnglish")); 
//	  Assert.assertTrue(new Search(driverW).searchMoreSame("ClassPageEnglish","用户昵称内容","OrdersPageEnglish")); 
	  Assert.assertTrue(new Search(driverW).searchTrueSame(searchData_user,"ClassPageEnglish","用户昵称内容","OrdersPageEnglish"));
  }
  
  
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  driverW = DriverFactory.createWebDriver("Firefox", "http://notadmin.hunyuedu.com/#/");
	  TestNGListener.setDriver(driverW);
  }

  @AfterClass
  public void afterClass() {
	  driverW.quit();
  }
}
