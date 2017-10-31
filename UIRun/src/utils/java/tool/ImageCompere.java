package tool;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Java 利用直方图原理比较2张图片的相似度
 * @author xingxue
 *
 */
public class ImageCompere {
//	 static Logger log = Logger.getLogger(ScreenShot.class.getName());

	 public static int[] getData(String name)throws Exception{
	        BufferedImage img = ImageIO.read(new File(name));
	        BufferedImage slt = new BufferedImage(100,100,BufferedImage.TYPE_INT_RGB);
	        slt.getGraphics().drawImage(img,0,0,100,100,null);
	        int[] data = new int[256];
	        for(int x = 0;x<slt.getWidth();x++){
	            for(int y = 0;y<slt.getHeight();y++){
	                int rgb = slt.getRGB(x,y);
	                Color myColor = new Color(rgb);
	                int r = myColor.getRed();
	                int g = myColor.getGreen();
	                int b = myColor.getBlue();
	                data[(r+g+b)/3]++;
	            }
	        }
	        //data 就是所谓图形学当中的直方图的概念
	        return data;
	    }
	 
	    public static float compare(int[] s,int[] t){
	        float result = 0F;
	        for(int i = 0;i<256;i++){
	            int abs = Math.abs(s[i]-t[i]);
	            int max = Math.max(s[i],t[i]);
	            result += (1-((float)abs/(max==0?1:max)));
	        }
	        return (result/256)*100;
	    }
	    
	    //输入地址后返回两张图片的相似度值
	    public static float compereNum(String a,String b) throws Exception {
	    	float percent = compare(getData(a),getData(b));
	    	return percent;
	    }
	    
	    
    public static void main(String[] args) throws Exception{  
    	 float percent = compare(getData("C:\\Users\\xingxue\\eclipse-workspace\\UIRun\\elementimg\\20171020155254.png"),getData("C:\\Users\\xingxue\\eclipse-workspace\\UIRun\\compereimg\\记住密码.png"));
         System.out.println("两张图片的相似度为："+percent+"%");
    }  

}
