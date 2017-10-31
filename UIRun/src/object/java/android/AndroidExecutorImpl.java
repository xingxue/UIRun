 package android;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import use.Locator;

public class AndroidExecutorImpl {


	private AndroidDriver<?> driverA;
	
//	public Logger log = Logger.getLogger(AppiumExecutorImpl.class.getName());

	public AndroidExecutorImpl(AndroidDriver<?> driverA) {
		this.driverA = driverA;
	}

	/**
	 * 点击元素
	 */
	public void click(Locator locator) {
		MobileElement e = findElement(locator);
		e.click();

	}

	/**
	 * 在元素中输入文本
	 */
	public void type(Locator locator, String values) {
		MobileElement e = findElement(locator);
		e.sendKeys(values);

	}
	
	/**
	 * 清空文本框数据
	 */
	public void clear(Locator locator) {
		MobileElement e = findElement(locator);
		e.clear();

	}

	/**
	 * 获取元素信息
	 */
	public String getText(Locator locator) {
		MobileElement e = findElement(locator);
		String text = e.getText();
		return text;
	}

	/**
	 * Android获取元素
	 */
	public MobileElement findElement(Locator locator) {
		MobileElement e = null;
		switch (locator.getByType()) {
		case xpath:
			e = (MobileElement) driverA.findElement(By.xpath(locator.getAddress()));
			break;
		case id:
			e = (MobileElement) driverA.findElement(By.id(locator.getAddress()));
			break;
		case name:
			e = (MobileElement) driverA.findElement(By.name(locator.getAddress()));
			break;
		case className:
			e = (MobileElement) driverA.findElement(By.className(locator.getAddress()));
			break;
		case AndroidUIAutomator:
			e = (MobileElement) driverA.findElementByAndroidUIAutomator(locator.getAddress());
			break;
		default:
			e = (MobileElement) driverA.findElement(By.id(locator.getAddress()));
		}
		return e;
	}

	/**
	 * 遍历元素获取其中一个,n为几获取第几个元素
	 */
	public MobileElement findElementNumber(Locator locator, int n) {
		MobileElement e = null;
		switch (locator.getByType()) {
		case xpath:
			e = (MobileElement) driverA.findElementsByXPath(locator.getAddress()).get(n);
			break;
		case id:
			e = (MobileElement) driverA.findElementsById(locator.getAddress()).get(n);
			break;
		case name:
			e = (MobileElement) driverA.findElementsByName(locator.getAddress()).get(n);
			break;
		case className:
			e = (MobileElement) driverA.findElementsByClassName(locator.getAddress()).get(n);
			break;
		default:
			e = (MobileElement) driverA.findElement(By.id(locator.getAddress()));
		}
		return e;
	}

	/**
	 * 判断元素是否出现
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
	 * 向左滑
	 */
	public void swipeToLeft() {
		int x = driverA.manage().window().getSize().width;
		int y = driverA.manage().window().getSize().height;
		try {
			driverA.swipe((x / 8 * 7), (y / 2 * 1), (x / 8 * 1), (y / 2 * 1), 1000);
		} catch (Exception e) {
			driverA.swipe((x / 8 * 7), (y / 2 * 1), (x / 8 * 1), (y / 2 * 1), 1000);
		}

	}

	/**
	 * 向右滑
	 */
	public void swipeToRight() {
		int x = driverA.manage().window().getSize().width;
		int y = driverA.manage().window().getSize().height;
		try {
			driverA.swipe((x / 8 * 1), (y / 2 * 1), (x / 8 * 7), (y / 2 * 1), 1000);
		} catch (Exception e) {
			driverA.swipe((x / 8 * 1), (y / 2 * 1), (x / 8 * 7), (y / 2 * 1), 1000);
		}
	}

	/**
	 * 向上滑
	 */
	public void swipeToUp() {
		int x = driverA.manage().window().getSize().width;
		int y = driverA.manage().window().getSize().height;
		try {
			driverA.swipe((x / 2 * 1), (y / 4 * 3), (x / 2 * 1), (y / 4 * 1), 1000);
		} catch (Exception e) {
			driverA.swipe((x / 2 * 1), (y / 4 * 3), (x / 2 * 1), (y / 4 * 1), 1000);
		}
	}

	/**
	 * 向下滑
	 */
	public void swipeToDown() {
		int x = driverA.manage().window().getSize().width;
		int y = driverA.manage().window().getSize().height;
		try {
			driverA.swipe((x / 2 * 1), (y / 8 * 1), (x / 2 * 1), (y / 8 * 7), 1000);
		} catch (Exception e) {
			driverA.swipe((x / 2 * 1), (y / 8 * 1), (x / 2 * 1), (y / 8 * 7), 1000);
		}

	}
	
	/**
	 * 上滑N次
	 * @param n
	 */
	public void swipeToUpNumber(int n) {
		for(int i = 0; i < n; i++) {
			swipeToUp();
		}
	}
	
	/**
	 * 上滑N次
	 * @param n
	 */
	public void swipeToDownNumber(int n) {
		for(int i = 0; i < n; i++) {
			swipeToDown();
		}
	}
	
	/**
	 * 元素内向左滑
	 */
	public void swipeToLeft(Locator locator) {
		int widthx = findElement(locator).getSize().width;
		int heighty = findElement(locator).getSize().height;
		int x = findElement(locator).getLocation().getX();
		int y = findElement(locator).getLocation().getY();
		try {
			driverA.swipe((x+widthx / 8 * 7), (y+heighty / 2 * 1), (x+widthx / 8 * 1), (y+heighty / 2 * 1), 1000);
		} catch (Exception e) {
			driverA.swipe((x+widthx / 8 * 7), (y+heighty / 2 * 1), (x+widthx / 8 * 1), (y+heighty / 2 * 1), 1000);
		}

	}
	
	/**
	 * 元素内向右滑
	 */
	public void swipeToRight(Locator locator) {
		int widthx = findElement(locator).getSize().width;
		int heighty = findElement(locator).getSize().height;
		int x = findElement(locator).getLocation().getX();
		int y = findElement(locator).getLocation().getY();
		try {
			driverA.swipe((x+widthx/ 8 * 1), (y+heighty / 2 * 1), (x+widthx / 8 * 7), (y+heighty / 2 * 1), 1000);
		} catch (Exception e) {
			driverA.swipe((x+widthx / 8 * 1), (y+heighty / 2 * 1), (x+widthx / 8 * 7), (y+heighty / 2 * 1), 1000);
		}

	}
	
	/**
	 * 元素内向上滑
	 */
	public void swipeToUp(Locator locator) {
		int widthx = findElement(locator).getSize().width;
		int heighty = findElement(locator).getSize().height;
		int x = findElement(locator).getLocation().getX();
		int y = findElement(locator).getLocation().getY();
		try {
			driverA.swipe((x+widthx / 2 * 1), (y+heighty / 4 * 3), (x+widthx / 2 * 1), (y+heighty / 4 * 1), 1500);
		} catch (Exception e) {
			driverA.swipe((x+widthx / 2 * 1), (y+heighty / 4 * 3), (x+widthx / 2 * 1), (y+heighty / 4 * 1), 1500);
		}

	}
	
	/**
	 * 元素内向下滑
	 */
	public void swipeToDown(Locator locator) {
		int widthx = findElement(locator).getSize().width;
		int heighty = findElement(locator).getSize().height;
		int x = findElement(locator).getLocation().getX();
		int y = findElement(locator).getLocation().getY();
		try {
			driverA.swipe((x+widthx / 2 * 1), (y+heighty / 4 * 3), (x+widthx / 2 * 1), (y+heighty / 4 * 1), 1500);
		} catch (Exception e) {
			driverA.swipe((x+widthx / 2 * 1), (y+heighty / 4 * 3), (x+widthx / 2 * 1), (y+heighty / 4 * 1), 1500);
		}

	}
	
	

	/**
	 * 通过坐标点击
	 */
	public void tapByXY(int x, int y) {
		TouchAction to = new TouchAction(driverA);
		try {
			to.tap(x, y).release().perform();
		} catch (Exception e) {
			System.out.println("点击失败");
		}

	}


}

