package android;

import java.util.HashMap;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import use.Locator;
import use.XmlUtils;

public class AndroidBasePage extends AndroidExecutorImpl {
    protected AndroidDriver<?> driverA;
    protected String pageName;  //页面名称
    protected String xmlPath;   //页面元素路径
    protected HashMap<String, Locator> locatorMap;
//    public Logger log = Logger.getLogger(BasePage.class.getName());
    
    public AndroidBasePage(AndroidDriver<?> driverA,String pageName) throws Exception  {
		super(driverA);
		this.driverA = driverA;
		this.pageName=pageName;
		
		//获取资源文件page.xml的路径
		xmlPath = this.getClass().getResource("").getPath() + "pageA.xml";
		locatorMap = XmlUtils.readXMLDocument(xmlPath, pageName);

	}
    
    public void type(String locatorName, String values) {
        super.type(getLocator(locatorName), values );
    }


    public void click(String locatorName) {
        super.click(getLocator(locatorName));
    }
    
    
    public void clear(String locatorName) {
    	super.clear(getLocator(locatorName));

	}


    public String getText(String locatorName) {
        return super.getText(getLocator(locatorName));
    }


    public MobileElement findElement(String locatorName) {
        return super.findElement(getLocator(locatorName));
    }
    
    public MobileElement findElementNumber(String locatorName, int n) {
        return super.findElementNumber(getLocator(locatorName), n);
    }

    public boolean isElementDisplayed(String locatorName) {
        return super.isElementDisplayed(getLocator(locatorName));
    }
    
    public void swipeToLeft(String locatorName) {
         super.swipeToLeft(getLocator(locatorName));
    }
    
    public void swipeToRight(String locatorName) {
        super.swipeToRight(getLocator(locatorName));
    }
    
    public void swipeToUp(String locatorName) {
         super.swipeToUp(getLocator(locatorName));
    }
    
    public void swipeToDown(String locatorName) {
         super.swipeToDown(getLocator(locatorName));
    }
    
    public  Locator getLocator(String locatorName) {

        Locator locator =  null;

        if(locatorMap!=null)
        {
            locator = locatorMap.get(locatorName);
        }
        return locator;
    }


}
