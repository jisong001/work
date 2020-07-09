package tt.make.tool;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class test001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--------------");
		test001 t1 = new test001();
		int val = t1.getDifferenceValue("D:\\001.png", "D:\\002.png");
		System.out.println(" val == "+ val);
	}

	
	/**
     * 通过像素对比来计算偏差值
     *
     * @param path1 原图位置
     * @param path2 滑块图位置
     * @return 偏差值
     */
    public int getDifferenceValue(String path1, String path2) {
        int result = 0;
        File file = new File(path1);
        File file1 = new File(path2);

        try {
            BufferedImage image = ImageIO.read(file);
            BufferedImage image1 = ImageIO.read(file1);

            int width = image.getWidth();
            int height = image.getHeight();
            int width1 = image1.getWidth();
            int height1 = image1.getHeight();
            System.out.println("width="+width+" ;height="+height+" ;");

            int[][] colors = new int[width][height];
            for (int x = 1; x < width; x++) {
                for (int y = 1; y < height; y++) {
//                	if(y == height1) {
//                		System.out.println("11");
//                	}
                    int color1 = image.getRGB(x, y);
                    
                    int color2 = 0;
                    if (x < width1 && y<height1) {
                    	 color2 = image1.getRGB(x, y);
                    }
                    if (color1 == color2) {
                        colors[x - 1][y - 1] = 0;
                    } else {
                        colors[x - 1][y - 1] = 1;
                    }
                }
            }
            int min = 999;
            int max = -1;
            for (int x = 0; x < colors.length; x++) {
                for (int y = 0; y < colors[x].length; y++) {
                    if (colors[x][y] == 1) {
                        colors[x][y] = checkPixel(x, y, colors);
                        if (colors[x][y] == 1) {
                            if (x > max) {
                                max = x;
                            } else if (x < min) {
                                min = x;
                            }
                        }
                    }
                }
            }
            result = (max + min) / 2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int checkPixel(int x, int y, int[][] colors) {
        int result = colors[x][y];
        int num = 0;
        if ((y + 30) < colors[x].length) {
            for (int i = 1; i <= 30; i++) {
                int color = colors[x][y + i];
                if (color == 0) {
                    num += 1;
                }
            }
            if (num > 15) {
                return 0;
            }
        }
        return result;
    }


    public static void createImage(int width, int height, int ints[][], String name) throws IOException {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphic = bi.createGraphics();
        graphic.setColor(new Color(0x003D1CFF));
        graphic.fillRect(0, 0, width, height);
        for (int x = 0; x < ints.length; x++) {
            for (int y = 0; y < ints[x].length; y++) {
                if (ints[x][y] == 1) {
                    bi.setRGB(x, y, 0xFF7F2E);
                }
            }
        }
        Iterator<ImageWriter> it = ImageIO.getImageWritersByFormatName("png");
        ImageWriter writer = it.next();
        File f = new File("c://" + name + ".png");
        ImageOutputStream ios = ImageIO.createImageOutputStream(f);
        writer.setOutput(ios);
        writer.write(bi);
    }
}
