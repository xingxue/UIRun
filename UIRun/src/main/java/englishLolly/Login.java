package englishLolly;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tool.ImageCompere;
import web.CreateElementScreenshot;
import web.WebBasePage;

public class Login {
	private WebDriver driverW;
	Logger log = Logger.getLogger(Login.class.getName());
	public Login(WebDriver driverW) {
		this.driverW = driverW;
	}

	/**
	 * 登陆功能
	 * @param userName
	 * @param pwd
	 */
	public void loginUser(String userName, String pwd) {
		try {
			new WebBasePage(driverW, "loginPageEnglish").sendKey("英语登录用户名", userName, 5);
			new WebBasePage(driverW, "loginPageEnglish").sendKey("英语登录密码", pwd, 5);
			Thread.sleep(3000);
			new WebBasePage(driverW, "loginPageEnglish").click("英语登录确认按钮");
			log.info("登陆过程完成");
		} catch (Exception e) {
			log.error("登陆过程失败");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 退出登陆功能
	 */
	public void logout() {
		try {
			new WebBasePage(driverW, "FirstPageEnglish").moveToElement("英语首页用户名", 5);
			new WebBasePage(driverW, "FirstPageEnglish").click("英语退出登陆");
			new WebBasePage(driverW, "FirstPageEnglish").click("英语确认退出登陆" ,5);
			log.info("退出登陆过程成功");
		} catch (Exception e) {
			log.error("退出登陆过程失败");
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过截屏验证记住密码是否勾选，勾选了显示true，没勾选显示false
	 * @return
	 * @throws Exception
	 */
	public boolean pwdRemenber() throws Exception {
		WebElement  e =new WebBasePage(driverW, "loginPageEnglish").findElement("记住密码按钮");
	    String imgPath1 = new CreateElementScreenshot().elementScreenshot(e).getPath();
	    log.info("截屏路径 : "+imgPath1);
	    String imgPath2 = "C:\\Users\\xingxue\\eclipse-workspace\\UIRun\\compereimg\\记住密码.png";
		@SuppressWarnings("static-access")
		float compere = new ImageCompere().compereNum(imgPath1, imgPath2);
	    log.info("图片相似度为 : "+compere);
		Boolean Remenber;
		if(compere>=99) {
			Remenber = false;
		}else Remenber = true;
		log.info("记住密码功能是否勾选 : "+Remenber);
		return Remenber;

	}

}
