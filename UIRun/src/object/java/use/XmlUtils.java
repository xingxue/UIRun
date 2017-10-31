package use;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import use.Locator.ByType;

public class XmlUtils {


	 public static HashMap<String, Locator> readXMLDocument(String xmlUrl, String pageName) throws Exception {  
            Logger log = Logger.getLogger(XmlUtils.class.getName());
	        HashMap<String, Locator> locatorMap = new HashMap<>();  
	        File file = new File(xmlUrl);  
	        if (!file.exists()) {  
	            log.error("can't find " + xmlUrl);  
	        } else {  
	            // 创建SAXReader对象  
	            SAXReader sr = new SAXReader();  
	            // 读取xml文件转换为Document  
	            Document document = sr.read(file);  
	            // 获取所有根节点元素对象  
	            Element root = document.getRootElement();  
	            Iterator<?> rootIte = root.elementIterator();  
	            Locator locator = null;  
	            // 遍历根节点  
	            while (rootIte.hasNext()) {  
	                Element page = (Element) rootIte.next();  
	                log.info("pageName is " + pageName);  
	                // 忽略大小写比较  
	                if (page.attribute(0).getValue().equalsIgnoreCase(pageName)) {  
	                    Iterator<?> pageIte = page.elementIterator();  
	                    // 找到pageName后遍历该page内各个节点  
	                    while (pageIte.hasNext()) {  
	                        String type = "";  
	                        String value = "";  
	                        String locatorName = "";  
	                        Element locatorEle = (Element) pageIte.next();  
	                        Iterator<?> locatorIte = locatorEle.attributeIterator();  
	                        // 遍历单个标签内的元素  
	                        while (locatorIte.hasNext()) {  
	                            Attribute attribute = (Attribute) locatorIte.next();  
	                            String attributeName = attribute.getName();  
	                            if (attributeName.equals("type")) {  
	                                type = attribute.getValue();  
	                            }  else {  
	                                value = attribute.getValue();  
	                            }  
	                        }  
	                        locator = new Locator(value, getByType(type));  
	                        locatorName = locatorEle.getText();  
	                        locatorMap.put(locatorName, locator);  
	                    }  
	                    break;  
	                }  
	            }  
	        }  
	        return locatorMap;  
	    }  
	
	  public static ByType getByType(String type) {
	        ByType byType = ByType.id;
	        if (type == null || type.equalsIgnoreCase("id")) {
	            byType = ByType.id;
	        } else if (type.equalsIgnoreCase("xpath")) {
	            byType = ByType.xpath;
	        } else if (type.equalsIgnoreCase("linkText")) {
	            byType = ByType.linkText;
	        } else if (type.equalsIgnoreCase("name")) {
	            byType = ByType.name;
	        } else if (type.equalsIgnoreCase("className")) {
	            byType = ByType.className;
	        } else if (type.equalsIgnoreCase("cssSelector")) {
	            byType = ByType.cssSelector;
	        } else if (type.equalsIgnoreCase("partialLinkText")) {
	            byType = ByType.partialLinkText;
	        } else if (type.equalsIgnoreCase("tagName")) {
	            byType = ByType.tagName;
	        }else if (type.equalsIgnoreCase("AndroidUIAutomator")) {
	            byType = ByType.AndroidUIAutomator;
	        }
	        return byType;
	    }
}
