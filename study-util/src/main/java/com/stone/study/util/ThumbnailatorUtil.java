package com.stone.study.util;

import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

/**
 * Thumbnailator
 * 
 * @author Stone
 * @describe Thumbnailator是一个为Java界面更流畅的缩略图生成库。从API提供现有的图像文件和图像对象的缩略图中简化了缩略过程
 *           ，两三行代码就能够从现有图片生成缩略图
 *           ，且允许微调缩略图生成，同时保持了需要写入到最低限度的代码量。同时还支持根据一个目录批量生成缩略图。
 */
public class ThumbnailatorUtil {
	public static void main(String[] args) throws IOException {
//		Thumbnails
//				.of("C:\\Users\\Administrator\\Desktop\\马上点餐\\F6A121A1C45AB95C50825D2DDE6A1D05.png")
//				.size(425, 283)
//				.toFile("C:\\Users\\Administrator\\Desktop\\马上点餐\\F6A121A1C45AB95C50825D2DDE6A1D05-1.png");
		Thumbnails
		.of("C:\\Users\\Administrator\\Desktop\\马上点餐\\F6A121A1C45AB95C50825D2DDE6A1D05.png")
		.size(80, 80)
		.toFile("C:\\Users\\Administrator\\Desktop\\马上点餐\\F6A121A1C45AB95C50825D2DDE6A1D05-1.png");
	}

	// public static void main(String[] args) throws IOException {
	// String filepath =
	// "C:\\Users\\Administrator\\Desktop\\活动\\20150127\\20150127";
	// File file = new File(filepath);
	// if (file.isDirectory()) {
	// String[] filelist = file.list();
	// for (int i = 0; i < filelist.length; i++) {
	// File readfile = new File(filepath + "\\" + filelist[i]);
	// if (!readfile.isDirectory()) {
	// System.out.println(i);
	// if (readfile.length() > 512000) {
	// System.out.println("absolutepath="
	// + readfile.getAbsolutePath());
	// Thumbnails.of(readfile.getAbsolutePath()).size(425, 283)
	// .toFile(readfile.getAbsolutePath());
	// }
	// // Thumbnails.of(readfile.getAbsolutePath()).scale(0.10f)
	// // .toFile(readfile.getAbsolutePath());
	// }
	// }
	// }
	// }
}
