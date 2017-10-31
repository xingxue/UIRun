package web;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import use.Locator;



public class WebUIExecutorImpl {
	private WebDriver driverW;

	public WebUIExecutorImpl(WebDriver driverW) {
		this.driverW = driverW;
	}

	public WebDriver getDriver() {
		return driverW;
	}

	public void setDriver(WebDriver driverW) {
		this.driverW = driverW;
	}

	/**
	 * 点击元素
	 * @param locator
	 */
	public void click(Locator locator) {
		WebElement element = findElement(locator);
		element.click();
	}

	/**
	 * 输入文本
	 * @param locator
	 * @param value
	 */
	public void sendKey(Locator locator, String value) {
		WebElement element = findElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	/**
	 * 获取元素信息
	 * @param locator
	 * @return
	 */
	public String getText(Locator locator) {
		WebElement element = findElement(locator);
		return element.getText();
	}
	
	/**
	 * 清空文本框数据
	 */
	public void clear(Locator locator) {
		WebElement element = findElement(locator);
		element.clear();

	}

	/**
	 * 判断元素是否出现
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(Locator locator) {
		
		boolean flag = false;
		try {
			findElement(locator).isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 获取input数据框中输入的数据
	 * @param locator
	 * @return
	 */
	public String getAttribute(Locator locator) {
		WebElement element = findElement(locator);
		return element.getAttribute("value");
	}
	
	/**
	 * 将鼠标移动到指定组件上
	 */
	public void moveToElement(Locator locator) {
		WebElement element = findElement(locator);
		Actions actions = new Actions(driverW);
		actions.moveToElement(element).perform();
	}

	/**
	 * 获取by
	 * 把缓存转换为元素
	 * @param locator
	 * @return
	 */
	public By findBy(Locator locator) {
		By b = null;
		String address = locator.getAddress();
		switch (locator.getByType()) {
		case xpath:
			b = By.xpath(address);
			break;
		case id:
			b = By.id(address);
			break;
		case className:
			b = By.className(address);
			break;
		case linkText:
			b = By.linkText(address);
			break;
		case cssSelector:
			b = By.cssSelector(address);
			break;
		case name:
			b = By.name(address);
			break;
		case partialLinkText:
			b = By.partialLinkText(address);
			break;
		case tagName:
			b = By.tagName(address);
			break;
		default:
			b = By.id(address);
			break;
		}
		return b;
	
		
	}
	/**
	 * 获取元素
	 * 把缓存转化成真实元素
	 * @param locator
	 * @return
	 */
	public WebElement findElement(Locator locator) {
		WebElement element = null;
		String address = locator.getAddress();
		switch (locator.getByType()) {
		case xpath:
			element = driverW.findElement(By.xpath(address));
			break;
		case id:
			element = driverW.findElement(By.id(address));
			break;
		case className:
			element = driverW.findElement(By.className(address));
			break;
		case linkText:
			element = driverW.findElement(By.linkText(address));
			break;
		case cssSelector:
			element = driverW.findElement(By.cssSelector(address));
			break;
		case name:
			element = driverW.findElement(By.name(address));
			break;
		case partialLinkText:
			element = driverW.findElement(By.partialLinkText(address));
			break;
		case tagName:
			element = driverW.findElement(By.tagName(address));
			break;
		default:
			element = driverW.findElement(By.id(address));
			break;
		}
		return element;
	}
	
	/**
	 * 获取元素集
	 * @param locator
	 * @return
	 */
	public List<WebElement> findElements(Locator locator) {
		List<WebElement> elements = null;
		String address = locator.getAddress();
		switch (locator.getByType()) {
		case xpath:
			elements = driverW.findElements(By.xpath(address));
			break;
		case id:
			elements = driverW.findElements(By.id(address));
			break;
		case className:
			elements = driverW.findElements(By.className(address));
			break;
		case linkText:
			elements = driverW.findElements(By.linkText(address));
			break;
		case cssSelector:
			elements = driverW.findElements(By.cssSelector(address));
			break;
		case name:
			elements = driverW.findElements(By.name(address));
			break;
		case partialLinkText:
			elements = driverW.findElements(By.partialLinkText(address));
			break;
		case tagName:
			elements = driverW.findElements(By.tagName(address));
			break;
		default:
			elements = driverW.findElements(By.id(address));
			break;
		}
		return elements;
	}

	/**
	 * 切换窗口
	 * @param title
	 */
	public void switchWindow(String title) {
		Set<String> handles = driverW.getWindowHandles();
		for (String handle : handles) {
			if (handle.equals(driverW.getWindowHandle())) {
				continue;
			} else {
				driverW.switchTo().window(handle);
				if (title.contains(driverW.getTitle())) {
					break;
				} else {
					continue;
				}
			}
		}
	}

	/**
	 * 切换frame
	 * @param locator
	 */
	public void switchFrame(Locator locator) {
		driverW.switchTo().frame(locator.getAddress());
	}

	
	/********************************************************************************************/	
	
	
	/**
	 * 获取显示智能等待元素
	 * @param locator
	 */
	public WebElement waitElement(Locator locator,int waitTime) {
		By b = findBy(locator);
		WebDriverWait wait = new WebDriverWait(driverW,waitTime);
		WebElement  element =  wait.until(new ExpectedCondition<WebElement>(){
		      public WebElement apply(WebDriver driverW) {
		            return driverW.findElement(b);
		          }
		    });
		return element;
	}

	/**
	 * 智能等待元素出现后点击元素
	 * @param locator
	 * @param waitTime
	 */
	public void click(Locator locator, int waitTime) {
		WebElement element = waitElement(locator, waitTime);
		element.click();
	}
	
	
	/**
	 * 智能等待元素出现后输入内容
	 * @param locator
	 * @param value
	 * @param waitTime
	 */
	public void sendKey(Locator locator, String value, int waitTime) {
		WebElement element = waitElement(locator, waitTime);
		element.clear();
		element.sendKeys(value);
	}
	
	
	/**
	 * 智能等待元素出现后获取元素信息
	 * @param locator
	 * @param waitTime
	 */
	public String getText(Locator locator, int waitTime) {
		WebElement element = waitElement(locator, waitTime);
		return element.getText();
	}
	
	
	/**
	 * 智能判断元素是否出现
	 * @param locator
	 * @return
	 */
	public boolean isElementDisplayed(Locator locator,  int waitTime) {
		
		boolean flag = false;
		try {
			waitElement(locator, waitTime).isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	
	/**
	 * 智能等待title出现
	 * @param title
	 * @param waitTime
	 */
	public void waitTitle(String title, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driverW, waitTime);
		wait.until( ExpectedConditions.titleContains(title));
	}
	
	/**
	 * 智能将鼠标移动到指定组件上
	 */
	public void moveToElement(Locator locator, int waitTime) {
		WebElement element = waitElement(locator, waitTime);
		Actions actions = new Actions(driverW);
		actions.moveToElement(element).perform();
	}
	
	
	/********************************************************************************************/

	
	/**
	 * 隐示等待页面全部加载完成
	 * @param url
	 * @param waitTime
	 */
	public void waitPage(String url, int waitTime) {
		driverW.manage().timeouts().pageLoadTimeout(waitTime, TimeUnit.SECONDS);
	    driverW.get(url);
	}
}
