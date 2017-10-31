package fictionWeb;

import org.openqa.selenium.WebDriver;

import web.WebBasePage;

public class Login {
    private WebDriver driverW;
	public Login(WebDriver driverW) {
		this.driverW = driverW;
	}
	/**
	 * 登录输入账号和密码
	 * @throws Exception
	 */
	public void loginUser() throws Exception {
//		WebDriverWait wait = new WebDriverWait(driverW,1000);
//		wait.until( ExpectedConditions.presenceOfElementLocated(new WebBasePage(driverW,"loginPage").findBy("登录用户名"))).sendKeys("1012315920");
//		new WebBasePage(driverW,"loginPage").sendKey("登录用户名", "1012315920");
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		 WebElement f = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".red_box")));
		new WebBasePage(driverW,"loginPage").sendKey("登录用户名", "1012315920");
		new WebBasePage(driverW,"loginPage").sendKey("登录密码", "Xx123456");
		new WebBasePage(driverW,"loginPage").click("登录确认按钮");
		
	}
	
	/**
	 * 登录后获取页面是否登录成功的信息
	 * @return
	 * @throws Exception
	 */
	public String loginSucceed() throws Exception {
		 return new WebBasePage(driverW,"loginPage").getText("登录提示信息");
	}
	

}
