package com.tools;



import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class MakeImg {

	public static final String imageSrc = "C:\\Users\\lianghui\\Desktop\\移动广告平台\\素材\\193956120305736611.jpg";
	public static final String imageDes = "C:\\Users\\lianghui\\Desktop\\移动广告平台\\素材\\";

	public static void main(String args[]) {
		int[][] sizes = { { 320, 50 }, { 640, 100 }, { 728, 90 }, { 30, 180 }, { 640, 100 }, { 480, 75 }, { 360, 50 }, { 320, 266 }, { 420, 350 },
				{ 600, 500 }, {1080, 1920}, {720, 1280},{1080, 160},{300,250},{640,960},{640,1136}};
		try {
			for (int i = 0; i < sizes.length; i++) {
				int width = sizes[i][0];
				int height = sizes[i][1];
//				String imageName = System.currentTimeMillis() + "_" + width + "_" + height + ".jpg";
				String imageName = width + "_" + height + ".jpg";
				cutCenterImage(imageSrc, imageDes + imageName, width, height);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 根据尺寸图片居中裁剪
	 */
	public static void cutCenterImage(String src, String dest, int w, int h) throws IOException {
		Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
		ImageReader reader = (ImageReader) iterator.next();
		InputStream in = new FileInputStream(src);
		ImageInputStream iis = ImageIO.createImageInputStream(in);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		int imageIndex = 0;
		Rectangle rect = new Rectangle((reader.getWidth(imageIndex) - w) / 2, (reader.getHeight(imageIndex) - h) / 2, w, h);
		param.setSourceRegion(rect);
		BufferedImage bi = reader.read(0, param);
		ImageIO.write(bi, "jpg", new File(dest));

	}

	/*
	 * 图片裁剪通用接口
	 */

	public static void cutImage(String src, String dest, int x, int y, int w, int h) throws IOException {
		Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
		ImageReader reader = (ImageReader) iterator.next();
		InputStream in = new FileInputStream(src);
		ImageInputStream iis = ImageIO.createImageInputStream(in);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		Rectangle rect = new Rectangle(x, y, w, h);
		param.setSourceRegion(rect);
		BufferedImage bi = reader.read(0, param);
		ImageIO.write(bi, "jpg", new File(dest));
	}

	/*
	 * 图片缩放
	 */
	public static void zoomImage(String src, String dest, int w, int h) throws Exception {
		double wr = 0, hr = 0;
		File srcFile = new File(src);
		File destFile = new File(dest);
		BufferedImage bufImg = ImageIO.read(srcFile);
		Image Itemp = bufImg.getScaledInstance(w, h, bufImg.SCALE_SMOOTH);
		wr = w * 1.0 / bufImg.getWidth();
		hr = h * 1.0 / bufImg.getHeight();
		AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
		Itemp = ato.filter(bufImg, null);
		try {
			ImageIO.write((BufferedImage) Itemp, dest.substring(dest.lastIndexOf(".") + 1), destFile);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
