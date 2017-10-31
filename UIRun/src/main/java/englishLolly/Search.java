package englishLolly;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import tool.RandomString;
import tool.StringGetNumber;
import web.WebBasePage;

public class Search {
	
	private WebDriver driverW;
	Logger log = Logger.getLogger(Search.class.getName());
	public Search(WebDriver driverW) {
		this.driverW = driverW;
	}
	 
	String[]  si = {"0","1","3","4","6","8","10","50","520"};
	String[]  sa = {"q","a","z","w","s","x","E","D","C","xingxue"};
	String[]  sw = {"你","我","他","测试"};
	String[]  sf = {"！","%","*",".","?"," ","#",":"};
	String[]  sz = {"xinguxe1","测试xingxue","1测试","123AQsw 你我他！"}; //带符号的数据是特例这次不做测试"5#","%好*","！a",
	
	/**
	 * 数字搜索完全相等
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean search123Same(String elePage, String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		lable:
		for(int i=0;i<si.length;i++) {
			b = false;
			int ln;
			new WebBasePage(driverW, page).sendKey("英语搜索框", si[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			if(numTrue==true) {
				String numString = new WebBasePage(driverW, page).getText("英语页面数据条数");  //获取当前页面数据条数
				ln = new StringGetNumber().getNumbers(numString);   //在字符串中获取数字
			}
			else ln=0;
			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+si[i]);
			//当前页数大于10，在第一条数据到第10条数据中随机获取一个数据进行比较
			//当前页数小于10，在第一条数据到当前数据中随机获取一个数据进行比较
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(si[i].equals(f)==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+si[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
				int num2 = new RandomString().getRandom(1,ln+1);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(si[i].equals(f)==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+si[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索数字测试过程完成，返回: "+b);
		return b;
		
	}
	/**
	 * 字母搜索不区分发小写，完全相等
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean searchABCSame(String elePage,String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		lable:
		for(int i=0;i<sa.length;i++) {
			b = false;
			int ln;
			new WebBasePage(driverW, page).sendKey("英语搜索框", sa[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			if(numTrue==true) {
				String numString = new WebBasePage(driverW, page).getText("英语页面数据条数");  //获取当前页面数据条数
				ln = new StringGetNumber().getNumbers(numString);   //在字符串中获取数字
			}
			else ln=0;
			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+sa[i]);
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(sa[i].toLowerCase().equals(f.toLowerCase())==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sa[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
				int num2 = new RandomString().getRandom(1,ln+1);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(sa[i].toLowerCase().equals(f.toLowerCase())==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sa[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索字母测试过程完成，返回: "+b);
		return b;
		
	}
	
	/**
	 * 汉字搜索完全相等
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean searchChinaSame(String elePage,String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		lable:
		for(int i=0;i<sw.length;i++) {
			b = false;
			int ln;
			new WebBasePage(driverW, page).sendKey("英语搜索框", sw[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			if(numTrue==true) {
				String numString = new WebBasePage(driverW, page).getText("英语页面数据条数");  //获取当前页面数据条数
				ln = new StringGetNumber().getNumbers(numString);   //在字符串中获取数字
			}
			else ln=0;
			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+sw[i]);
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(sw[i].equals(f)==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sw[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
				int num2 = new RandomString().getRandom(1,ln+1);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(sw[i].equals(f)==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sw[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索中文测试过程完成，返回: "+b);
		return b;
		
	}
	
	/**
	 * 字符串搜索完全相等
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean searchCharSame(String elePage,String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		lable:
		for(int i=0;i<sf.length;i++) {
			b = false;
			int ln;
			new WebBasePage(driverW, page).sendKey("英语搜索框", sf[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			if(numTrue==true) {
				String numString = new WebBasePage(driverW, page).getText("英语页面数据条数");  //获取当前页面数据条数
				ln = new StringGetNumber().getNumbers(numString);   //在字符串中获取数字
			}
			else ln=0;
			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+sf[i]);
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(sf[i].equals(f)==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sf[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
				int num2 = new RandomString().getRandom(1,ln+1);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(sf[i].equals(f)==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sf[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索符号测试过程完成，返回: "+b);
		return b;
		
	}
	
	/**
	 * 搜索组合字符串完全相等,不区分大小写
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean searchMoreSame(String elePage, String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		lable:
		for(int i=0;i<sz.length;i++) {
			b = false;
			int ln;
			new WebBasePage(driverW, page).sendKey("英语搜索框", sz[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			if(numTrue==true) {
				String numString = new WebBasePage(driverW, page).getText("英语页面数据条数");  //获取当前页面数据条数
				ln = new StringGetNumber().getNumbers(numString);   //在字符串中获取数字
			}
			else ln=0;
			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+sz[i]);
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(sz[i].toLowerCase().equals(f.toLowerCase())==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sz[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
				int num2 = new RandomString().getRandom(1,ln+1);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(sz[i].toLowerCase().equals(f.toLowerCase())==true) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sz[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索组合字符串测试过程完成，返回: "+b);
		return b;
		
	}
	
	/**
	 * 搜索存在的字符串，完全相等,不区分大小写
	 * @param sTrue
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean searchTrueSame(String sTrue, String elePage, String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		int ln;
		new WebBasePage(driverW, page).sendKey("英语搜索框", sTrue,5);
		System.out.println(1);
		Thread.sleep(5000);
		new WebBasePage(driverW, page).click("英语搜索按钮");
		System.out.println(2);
		Thread.sleep(5000);
		boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
		if(numTrue==true) {
			String numString = new WebBasePage(driverW, page).getText("英语页面数据条数");  //获取当前页面数据条数
			ln = new StringGetNumber().getNumbers(numString);   //在字符串中获取数字
		}
		else ln=0;
		log.info("当前页面数据条数 : "+ln);
		log.info("输入的搜索数据 : "+sTrue);
		if(ln>10) {
			@SuppressWarnings("static-access")
			int num1 = new RandomString().getRandom(1,11);
			f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
			log.info("获取搜索后的数据 : "+f);
			if(sTrue.toLowerCase().equals(f.toLowerCase())==true) {
				b=true;
			}else {
				log.error("搜索异常数据 : "+sTrue);
			} 
		}else if(ln>0) {
			@SuppressWarnings("static-access")
			int num2 = new RandomString().getRandom(1,ln+1);
			f=new WebBasePage(driverW, elePage).findElements(eleName).get(0).getText();
			log.info("获取搜索后的数据 : "+f);
			if(sTrue.toLowerCase().equals(f.toLowerCase())==true) {
				b=true;
			}else {
				log.error("搜索异常数据 : "+sTrue);
			} 
		}else {
//			f=new WebBasePage(driverW, elePage).findElements(eleName).get(0).getText();
			log.error("搜索不出数据异常 : "+sTrue);
		}
		return b;
	}
	
	/**
	 * 搜索数字，不完全相等，包含关系
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean search123Likeness(String elePage, String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		lable:
		for(int i=0;i<si.length;i++) {
			b = false;
			int ln;
			new WebBasePage(driverW, page).sendKey("英语搜索框", si[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			if(numTrue==true) {
				String numString = new WebBasePage(driverW, page).getText("英语页面数据条数");  //获取当前页面数据条数
				ln = new StringGetNumber().getNumbers(numString);   //在字符串中获取数字
			}
			else ln=0;

			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+si[i]);
			//当前页数大于10，在第一条数据到第10条数据中随机获取一个数据进行比较
			//当前页数小于10，在第一条数据到当前数据中随机获取一个数据进行比较
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.indexOf(si[i])!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+si[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
			
				int num2 = new RandomString().getRandom(1,ln+1);
				int ff = new WebBasePage(driverW, elePage).findElements(eleName).size();
				System.out.println("当前真实条数 : "+ff);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.indexOf(si[i])!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+si[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索数字测试过程完成，返回: "+b);
		return b;
		
	}
	
	/**
	 * 搜索字母，不区分大小写，不完全相等，包含关系
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean searchABCLikeness(String elePage, String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		lable:
		for(int i=0;i<sa.length;i++) {
			b = false;
			int ln;
			new WebBasePage(driverW, page).sendKey("英语搜索框", sa[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			if(numTrue==true) {
			String numString = new WebBasePage(driverW, page).getText("英语页面数据条数",5);
			ln = new StringGetNumber().getNumbers(numString);
			}
			else ln=0;
			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+sa[i]);
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.toLowerCase().indexOf(sa[i].toLowerCase())!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sa[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
				int num2 = new RandomString().getRandom(1,ln+1);
				log.info("获取第几个搜索数据 : "+num2);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.toLowerCase().indexOf(sa[i].toLowerCase())!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sa[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索字母测试过程完成，返回: "+b);
		return b;
		
	}
	
	/**
	 * 搜索中文，不完全相等，包含关系
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean searchChinaLikeness(String elePage, String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		lable:
		for(int i=0;i<sw.length;i++) {
			b = false;
			new WebBasePage(driverW, page).sendKey("英语搜索框", sw[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			int ln;
			if(numTrue==true) {
			String numString = new WebBasePage(driverW, page).getText("英语页面数据条数",5);
			ln = new StringGetNumber().getNumbers(numString);
			}
			else ln=0;
			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+sw[i]);
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.indexOf(sw[i])!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sw[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
				int num2 = new RandomString().getRandom(1,ln+1);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.indexOf(sw[i])!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sw[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索中文测试过程完成，返回: "+b);
		return b;
		
	}
	
	/**
	 * 搜索字符串，不完全相等包含关系
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean searchCharLikeness(String elePage, String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		lable:
		for(int i=0;i<sf.length;i++) {
			b = false;
			int ln;
			new WebBasePage(driverW, page).sendKey("英语搜索框", sf[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			if(numTrue==true) {
			String numString = new WebBasePage(driverW, page).getText("英语页面数据条数",5);
			ln = new StringGetNumber().getNumbers(numString);
			}
			else ln=0;
			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+sf[i]);
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.indexOf(sf[i])!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sf[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
				int num2 = new RandomString().getRandom(1,ln+1);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.indexOf(sf[i])!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sf[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索符号测试过程完成，返回: "+b);
		return b;
		
	}
	
	/**
	 * 搜索组合字符串，不完全相等包含关系，不区分大小写
	 */
	public Boolean searchMoreLikeness(String elePage, String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		System.out.println(4);
		lable:
		for(int i=0;i<sz.length;i++) {
			b = false;
			int ln;
			new WebBasePage(driverW, page).sendKey("英语搜索框", sz[i],5);
			new WebBasePage(driverW, page).click("英语搜索按钮");
			boolean numTrue = new WebBasePage(driverW, page).isElementDisplayed("英语页面数据条数");
			if(numTrue==true) {
			String numString = new WebBasePage(driverW, page).getText("英语页面数据条数",5);
			ln = new StringGetNumber().getNumbers(numString);
			}
			else ln=0;
			log.info("当前页面数据条数 : "+ln);
			log.info("输入的搜索数据 : "+sz[i]);
			if(ln>10) {
				@SuppressWarnings("static-access")
				int num1 = new RandomString().getRandom(1,11);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.toLowerCase().indexOf(sz[i].toLowerCase())!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sz[i]);
					break lable;
				} 
			}else if(ln>0) {
				@SuppressWarnings("static-access")
				int num2 = new RandomString().getRandom(1,ln+1);
				f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
				log.info("获取搜索后的数据 : "+f);
				if(f.toLowerCase().indexOf(sz[i].toLowerCase())!=-1) {
					b=true;
				}else {
					log.error("搜索异常数据 : "+sz[i]);
					break lable;
				} 
			}
			else b=true;
		}
		log.info("搜索组合字符串测试过程完成，返回: "+b);
		return b;
		
	}
	
	/**
	 * 搜索真实存在的数据，如果不存在报错，不完全相等，包含关系，不区分大小写
	 * @param sTrue
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public Boolean searchTrueLikeness(String sTrue, String elePage, String eleName, String page) throws Exception {
		Boolean b = false;
		String f;
		new WebBasePage(driverW, page).sendKey("英语搜索框", sTrue,5);
		new WebBasePage(driverW, page).click("英语搜索按钮");
		String numString = new WebBasePage(driverW, page).getText("英语页面数据条数",5);
		int ln = new StringGetNumber().getNumbers(numString);
		log.info("当前页面数据条数 : "+ln);
		log.info("输入的搜索数据 : "+sTrue);
		if(ln>10) {
			@SuppressWarnings("static-access")
			int num1 = new RandomString().getRandom(1,11);
			f=new WebBasePage(driverW, elePage).findElements(eleName).get(num1).getText();
			log.info("获取搜索后的数据 : "+f);
			if(f.toLowerCase().indexOf(sTrue.toLowerCase())!=-1) {
				b=true;
			}else {
				log.error("搜索异常数据 : "+sTrue);
			} 
		}else if(ln>0) {
			@SuppressWarnings("static-access")
			int num2 = new RandomString().getRandom(1,ln+1);
			f=new WebBasePage(driverW, elePage).findElements(eleName).get(num2).getText();
			log.info("获取搜索后的数据 : "+f);
			if(f.indexOf(sTrue)!=-1) {
				b=true;
			}else {
				log.error("搜索异常数据 : "+sTrue);
			} 
		}else {
			log.error("搜索不出数据异常 : "+sTrue);
		}
		return b;
	}

}
