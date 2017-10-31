package web;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import use.Locator;
import use.XmlUtils;

public class WebBasePage extends WebUIExecutorImpl {
	protected WebDriver driverW;
	protected String pageName;// 页面名称
	protected String xmlPath;// 页面元素配置文件路径
	protected HashMap<String, Locator> locatorMap;//存储页面元素信息
//	public LogUtil log;

	public WebBasePage(WebDriver driverW, String pageName) throws Exception {
		super(driverW);
		this.driverW = driverW;
		this.pageName = pageName;
		// 获取page.xml路径，page.xml在同级目录
		xmlPath = this.getClass().getResource("").getPath() + "pageW.xml";
		locatorMap = XmlUtils.readXMLDocument(xmlPath, pageName);
	}

	public void clear(String locatorName) {
		super.clear(getLocator(locatorName));
	}
	
	public void click(String locatorName) {
		super.click(getLocator(locatorName));
	}
	
	public String getAttribute(String locatorName) {
		return super.getAttribute(getLocator(locatorName));
	}
	
	public void click(String locatorName, int waitTime) {
		super.click(getLocator(locatorName), waitTime);
	}
	
	public void sendKey(String locatorName, String value) {
		super.sendKey(getLocator(locatorName), value);
	}
	
	public void sendKey(String locatorName, String value, int waitTime) {
		super.sendKey(getLocator(locatorName), value, waitTime);
	}

	public String getText(String locatorName) {
		return super.getText(getLocator(locatorName));
	}
	
	public String getText(String locatorName, int waitTime) {
		return super.getText(getLocator(locatorName), waitTime);
	}

	public WebElement findElement(String locatorName) {
		return super.findElement(getLocator(locatorName));
	}
	
	public List<WebElement> findElements(String locatorName) {
		return super.findElements(getLocator(locatorName));
	}

	public void moveToElement(String locatorName) {
		super.moveToElement(getLocator(locatorName));
	}
	
	public void moveToElement(String locatorName, int waitTime) {
		super.moveToElement(getLocator(locatorName), waitTime);
	}

	public By findBy(String locatorName) {
		return super.findBy(getLocator(locatorName));
	}
	
	public boolean isElementDisplayed(String locatorName) {
		return super.isElementDisplayed(getLocator(locatorName));
	}
	
	public boolean isElementDisplayed(String locatorName, int waitTime) {
		return super.isElementDisplayed(getLocator(locatorName), waitTime);
	}

	public void switchWindow(String title) {
		super.switchWindow(title);
	}

	public void switchFrame(String locatorName) {
		super.switchFrame(getLocator(locatorName));
	}
	
	public WebElement waitElement(String locatorName, int waitTime) {
		return super.waitElement(getLocator(locatorName), waitTime);
	}

	/**
	 * 根据locatorName返回对应的locator
	 * 
	 * @author ljl
	 */
	public Locator getLocator(String locatorName) {
		Locator locator = null;
		if (locatorMap != null) {
			locator = locatorMap.get(locatorName);
		}
		return locator;
	}
}

