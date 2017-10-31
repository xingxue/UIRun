package use;

/**
 * 封装页面元素，每个元素都有相应的定位地址（xpath路径或css或id）,等待时间，定位方式，默认为id
 * @author xingxue
 *
 */
public class Locator {

	private String address; // 定位地址
	private ByType byType; // 定位方式

	/**
	 * 定位类型枚举
	 * 
	 * @author ljl
	 *
	 */
	public enum ByType {
		 id, linkText, name, className, cssSelector, partialLinkText, xpath, tagName, AndroidUIAutomator
	}

	public Locator() {
	}

	/**
	 * Locator构造器，默认定位类型By.xpath,等待时长3s
	 * 
	 * @author ljl
	 * @param element
	 */
	public Locator(String address) {
		this.address = address;
	}

	public Locator(String address, ByType byType) {
		this.address = address;
		this.byType = byType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ByType getByType() {
		return byType;
	}

	public void setByType(ByType byType) {
		this.byType = byType;
	}

}

