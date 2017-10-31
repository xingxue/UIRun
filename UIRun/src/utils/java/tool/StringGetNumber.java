package tool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringGetNumber {
	
	/**
	 * 获取String数据里的数字并官换成int
	 * @param content
	 * @return
	 */
	  public int getNumbers(String content) {
		  String regEx="[^0-9]";   
		  Pattern p = Pattern.compile(regEx);   
		  Matcher m = p.matcher(content);   
		  return  Integer.parseInt(m.replaceAll("").trim());
	  }
	  
	  
	  /**
	   * 测试用
	   * @param args
	   */
	  public static void main(String[] args) {
		 int ln = new StringGetNumber().getNumbers("jfjalj124jj9");
		 System.out.println(ln);
	}
}
