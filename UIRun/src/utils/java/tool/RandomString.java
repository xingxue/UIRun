package tool;

import java.util.Random;

public class RandomString {
	
	public static int getRandom(int count) {
		return (int) Math.round(Math.random() * (count));
	} 
	
	public static String string1 = "abcdefghijklmnopqrstuvwxyz1234567890"; 
	public static String string2 = "1234567890"; 
	 
	/**
	 * 生成随机数,混合随机数或者是存数字随机数
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length,String name){
		int len;
	    StringBuffer sb = new StringBuffer();
	    if(name.equals("混合")) {
	    	len = string1.length();
	    	for (int i = 0; i < length; i++) {
		        sb.append(string1.charAt(getRandom(len-1)));
		    }
	    }else if(name.equals("数字")) {
	    	len = string2.length();
	    	for (int i = 0; i < length; i++) {
		        sb.append(string2.charAt(getRandom(len-1)));
		    }
	    }else{
	    	len = string1.length();
	    	for (int i = 0; i < length; i++) {
		        sb.append(string1.charAt(getRandom(len-1)));
		    }
	    }
	    return sb.toString();
	}
	

    /**
     * 取某个范围内的随机数，包括min，不包括max
     * @param min
     * @param max
     * @return
     */
	public static int getRandom(int min, int max){
	    Random random = new Random();
	    int s = random.nextInt(max) % (max - min) + min;
	    return s;

	}
	
	
	public static void main(String[] args) {
		for(int i=0;i<=100;i++) {
			System.out.println(getRandom(1,2));
		}
		
	}
	


}
