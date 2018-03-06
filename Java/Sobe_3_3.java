import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sobe_3_3 
{
	public static void Xaxis()
	{
		BufferedImage image = null;
		  int[][] sobel_x = {{-1,0,1},{-2,0,2},{-1,0,1}};
		  int[][] sob;//Sobel Calculations
		  
		  // read the image
		      try {
		      	file = new File("/Users/priteshratnappagol/Desktop/Sobel/building.png");
		          image = ImageIO.read(file);
		      } catch (IOException e) {
		          System.err.println(e);
		      }
		      int width = image.getWidth();//width of image
		      int height = image.getHeight();//height of image
		      
		      // Finding the greyscale image
		      sob = new int[width][height];
		      for (int y = 0; y < height; y++) {
		          for (int x = 0; x < width; x++) {
		              int pixel = image.getRGB(x, y);
		              int a = (pixel >> 24) & 0xff;
		              int r = (pixel >> 16) & 0xff;
		              int g = (pixel >> 8) & 0xff;
		              int b = pixel & 0xff;
		              
		              // calculate average
		              int avg = (r+g+b)/3;
		              
		              sob[x][y] = avg;
		              // replacing RGB value with average
		              pixel = (avg << 24) | (avg << 16) | (avg << 8) | avg;
		              image.setRGB(x, y, pixel);
		          }
		      }
		    
		      //calculation for horizontal sobel filter
		      for (int y = 1; y < height-1; y++) {
		          for (int x = 1; x < width-1; x++) {
		                int Gx = (sobel_x[0][0] * sob[x-1][y-1]) + (sobel_x[0][1] * sob[x-1][y]) +
				              (sobel_x[0][2] * sob[x-1][y+1]) + (sobel_x[1][0] * sob[x][y-1]) + 
				              (sobel_x[1][1] * sob[x][y]) + (sobel_x[1][2] * sob[x][y+1]) + 
				              (sobel_x[2][0] * sob[x+1][y-1]) + (sobel_x[2][1] * sob[x+1][y]) + 
				              (sobel_x[2][2] * sob[x+1][y+1]);
		                int value = Gx;
		            
		              if (Gx>255) {
		                  Gx = 255;
		              } else if (Gx<0) {
		                  Gx = 0;
		              }
		              Color x_image = new Color(Gx,Gx,Gx);
		              image.setRGB(x, y, x_image.getRGB());
		          }
		      }
		      // write image
		      try {
		      	file = new File("/Users/priteshratnappagol/Desktop/Sobel/xsobel.png");
					ImageIO.write(image,"png", file);
					System.out.println("Writing Complete");
		      } catch (IOException e) {
		          System.err.println(e);
		      }
	}
	public static void Yaxis()
	{
		  BufferedImage image = null;
  int[][] sobel_y= {{-1,-2,-1},{0,0,0},{1,2,1}};
  int[][] sob;// for sobel calculations
  
  // read the image
      try {
      	file = new File("/Users/priteshratnappagol/Desktop/Sobel/greyscale.png");
          image = ImageIO.read(file);
      } catch (IOException e) {
          System.err.println(e);
      }
      int width = image.getWidth();//width of image
      int height = image.getHeight();//height of image
      
      sob = new int[width][height];
      for (int y = 0; y < height; y++) {
          for (int x = 0; x < width; x++) {
              int pixel = image.getRGB(x, y);  
              int a = (pixel >> 24) & 0xff;
              int r = (pixel >> 16) & 0xff;
              int g = (pixel >> 8) & 0xff;
              int b = pixel & 0xff;
              
              // calculate average
              int avg = (r+g+b)/3;
              
              sob[x][y] = avg;
              // replacing RGB value with average
              pixel = (avg << 24) | (avg << 16) | (avg << 8) | avg;
              image.setRGB(x, y, pixel);
          }
      }
      //calculation for vertical sobel filter
      for (int y = 1; y < height-1; y++) {
          for (int x = 1; x < width-1; x++) {
        	  int Gy = (sobel_y[0][0] * sob[x-1][y-1]) + (sobel_y[0][1] * sob[x-1][y]) +
		              (sobel_y[0][2] * sob[x-1][y+1]) + (sobel_y[1][0] * sob[x][y-1]) + 
		              (sobel_y[1][1] * sob[x][y]) + (sobel_y[1][2] * sob[x][y+1]) + 
		              (sobel_y[2][0] * sob[x+1][y-1]) + (sobel_y[2][1] * sob[x+1][y]) + 
		              (sobel_y[2][2] * sob[x+1][y+1]);
             
              if (Gy>255) {
                  Gy = 255;
              } else if (Gy<0) {
                  Gy = 0;
              }
              Color y_image = new Color(Gy,Gy,Gy);
              image.setRGB(x, y, y_image.getRGB());
          }
      }
      // write image
      try {
      	file = new File("/Users/priteshratnappagol/Desktop/Sobel/ysobel.png");
			ImageIO.write(image,"png", file);
			System.out.println("Writing Complete");
      } catch (IOException e) {
          System.err.println(e);
      }
  }
	
	public static void Sobel()
	{
		 BufferedImage image = null;
		  int[][] sobel_x = {{-1,0,1},{-2,0,2},{-1,0,1}};
		  int[][] sobel_y= {{-1,-2,-1},{0,0,0},{1,2,1}};
		  
		  int[][] sob;//for sobel calculations
		  
		  // read the image
		      try {
		      	file = new File("/Users/priteshratnappagol/Desktop/Sobel/building.png");
		          image = ImageIO.read(file);
		      } catch (IOException e) {
		          System.err.println(e);
		      }
		      int width = image.getWidth();//width of image
		      int height = image.getHeight();//height of image
		      
		      sob = new int[width][height];
		      for (int y = 0; y < height; y++) {
		          for (int x = 0; x < width; x++) {
		              int pixel = image.getRGB(x, y);
		              int a = (pixel >> 24) & 0xff;
		              int r = (pixel >> 16) & 0xff;
		              int g = (pixel >> 8) & 0xff;
		              int b = pixel & 0xff;
		              
		              // calculate average
		              int avg = (r+g+b)/3;
		              
		              sob[x][y] = avg;
		              // replacing RGB value with average
		              pixel = (avg << 24) | (avg << 16) | (avg << 8) | avg;
		              image.setRGB(x, y, pixel);
		          }
		      }
		      
		      //calculation for sobel filter
		      for (int y = 1; y < height-1; y++) {
		          for (int x = 1; x < width-1; x++) {
		        	  int Gx = (sobel_x[0][0] * sob[x-1][y-1]) + (sobel_x[0][1] * sob[x-1][y]) +
				              (sobel_x[0][2] * sob[x-1][y+1]) + (sobel_x[1][0] * sob[x][y-1]) + 
				              (sobel_x[1][1] * sob[x][y]) + (sobel_x[1][2] * sob[x][y+1]) + 
				              (sobel_x[2][0] * sob[x+1][y-1]) + (sobel_x[2][1] * sob[x+1][y]) + 
				              (sobel_x[2][2] * sob[x+1][y+1]);

		        	  int Gy = (sobel_y[0][0] * sob[x-1][y-1]) + (sobel_y[0][1] * sob[x-1][y]) +
				              (sobel_y[0][2] * sob[x-1][y+1]) + (sobel_y[1][0] * sob[x][y-1]) + 
				              (sobel_y[1][1] * sob[x][y]) + (sobel_y[1][2] * sob[x][y+1]) + 
				              (sobel_y[2][0] * sob[x+1][y-1]) + (sobel_y[2][1] * sob[x+1][y]) + 
				              (sobel_y[2][2] * sob[x+1][y+1]);
		              
		              int pixel = (int) Math.sqrt((Gx * Gx) + (Gy * Gy));

		              if (pixel>255) {
		                  pixel = 255;
		              } else if (pixel<0) {
		            	  pixel = 0;
		              }
		              Color y_image = new Color(pixel,pixel,pixel);
		              image.setRGB(x, y, y_image.getRGB());
		          }
		      }
		      // write image
		      try {
		      	file = new File("/Users/priteshratnappagol/Desktop/Sobel/sobel.png");
					ImageIO.write(image,"png", file);
					System.out.println("Writing Complete");
		      } catch (IOException e) {
		          System.err.println(e);
		      }

	}
	public static void Peak()
	{
		 BufferedImage image = null;
		  int[][] sobel_x = {{-1,0,1},{-2,0,2},{-1,0,1}};
		  int[][] sobel_y= {{-1,-2,-1},{0,0,0},{1,2,1}};
		  int[][] sob;//for sobel calculations
		  
		  // read the image
		      try {
		      	file = new File("/Users/priteshratnappagol/Desktop/Sobel/building.png");
		          image = ImageIO.read(file);
		      } catch (IOException e) {
		          System.err.println(e);
		      }
		      int width = image.getWidth();//width of image
		      int height = image.getHeight();//height of image
		      
		      sob = new int[width][height];
		      for (int y = 0; y < height; y++) {
		          for (int x = 0; x < width; x++) {
		              int pixel = image.getRGB(x, y);
		              int a = (pixel >> 24) & 0xff;
		              int r = (pixel >> 16) & 0xff;
		              int g = (pixel >> 8) & 0xff;
		              int b = pixel & 0xff;
		              
		              // calculate average
		              int avg = (r+g+b)/3;
		              
		              sob[x][y] = avg;
		              // replacing RGB value with average
		              pixel = (avg << 24) | (avg << 16) | (avg << 8) | avg;
		              image.setRGB(x, y, pixel);
		          }
		      }
		      
		      //calculation for sobel
		      for (int y = 1; y < height-1; y++) {
		          for (int x = 1; x < width-1; x++) {
		        	  int Gx = (sobel_x[0][0] * sob[x-1][y-1]) + (sobel_x[0][1] * sob[x-1][y]) +
				              (sobel_x[0][2] * sob[x-1][y+1]) + (sobel_x[1][0] * sob[x][y-1]) + 
				              (sobel_x[1][1] * sob[x][y]) + (sobel_x[1][2] * sob[x][y+1]) + 
				              (sobel_x[2][0] * sob[x+1][y-1]) + (sobel_x[2][1] * sob[x+1][y]) + 
				              (sobel_x[2][2] * sob[x+1][y+1]);

		        	  int Gy = (sobel_y[0][0] * sob[x-1][y-1]) + (sobel_y[0][1] * sob[x-1][y]) +
				              (sobel_y[0][2] * sob[x-1][y+1]) + (sobel_y[1][0] * sob[x][y-1]) + 
				              (sobel_y[1][1] * sob[x][y]) + (sobel_y[1][2] * sob[x][y+1]) + 
				              (sobel_y[2][0] * sob[x+1][y-1]) + (sobel_y[2][1] * sob[x+1][y]) + 
				              (sobel_y[2][2] * sob[x+1][y+1]);
		              
		              int max = Math.max(Gx, Gy);
		              if (max>255) {
		                  max = 255;
		              } else if (max<0) {
		                  max = 0;
		              }
		              Color y_image = new Color(max,max,max);
		              image.setRGB(x, y, y_image.getRGB());
		          }
		      }
		      // write image
		      try {
		      	file = new File("/Users/priteshratnappagol/Desktop/Sobel/peak.png");
					ImageIO.write(image,"png", file);
					System.out.println("Writing Complete");
		      } catch (IOException e) {
		          System.err.println(e);
		      }

	}
	public static File file = null;
 	public static void main(String[] args) throws IOException
  	{
 	  Xaxis();
 	  Yaxis();
	  Sobel();
	  Peak();
	}
}
