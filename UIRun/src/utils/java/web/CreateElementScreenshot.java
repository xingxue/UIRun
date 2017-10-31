package web;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

import tool.GetTime;

public class CreateElementScreenshot { 
	private static String path;
	static Logger log = Logger.getLogger(CreateElementScreenshot.class.getName());
	
	public CreateElementScreenshot() {

		path = System.getProperty("user.dir") + "/elementimg/"+ new GetTime().getNewTime() + ".png";
	}
	
	public File captureElement(WebElement element) throws Exception {
        WrapsDriver wrapsDriver = (WrapsDriver) element;
        // 截图整个页面
        File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(screen);
        // 获得元素的高度和宽度
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();
        // 创建一个矩形使用上面的高度，和宽度
        Rectangle rect = new Rectangle(width, height);
        // 得到元素的坐标
        Point p = element.getLocation();
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        // 存为png格式
        ImageIO.write(dest, "png", screen);
        return screen;
    }
	
	public File elementScreenshot(WebElement element)  {
		File shotFile = new File(path);
		File phone;
		try {
			phone = new CreateElementScreenshot().captureElement(element);
			FileUtils.copyFile(phone, shotFile);
			log.info("组件截屏成功");
		} catch (Exception e) {
			log.error("组件截屏失败");
			e.printStackTrace();
		}
		return shotFile;
		
	}
	
	/**
	 * 获取截屏路径
	 * @return
	 */
	public String getPath() {
        return path;
    }

    @SuppressWarnings("static-access")
	public void setPath(String path) {
        this.path = path;
    }


}
