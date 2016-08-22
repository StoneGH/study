package com.stone.study.util;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * <p>
 * Class Name: FileOperateUtil
 * </p>
 * <p>
 * Description: 文件操作
 * </p>
 * <p>
 * Sample: 该类的典型使用方法和用例
 * </p>
 * <p>
 * Author: 石涛
 * </p>
 * <p>
 * Date: 2014-9-19
 * </p>
 * <p>
 * Modified History: 修改记录，格式(Name) (Version) (Date) (Reason & Contents)
 * </p>
 */
public class FileOperateUtil {

    /**
     * 
     * 描述:java.util.zip.ZipOutputStream压缩多个文件为一个ZIP 不支持中文
     * 
     * @param sourceFilesPath
     * @param fileName
     * @param compressFilePath
     * @author 石涛 date 2014-9-19
     *         -------------------------------------------------- 修改人 修改日期 修改描述
     *         石涛 2014-9-19 创建
     *         --------------------------------------------------
     * @throws FileNotFoundException
     * @Version Ver1.0
     */
    public static void compressFilesToZip(String[] sourceFilesPath, String fileName, String compressFilePath) throws FileNotFoundException {
        byte[] bytes = new byte[1024];
        try {
            // ZipOutputStream:完成文件或文件夹的压缩
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(new File(compressFilePath + "\\" + fileName)));
            for (String sourceFilePath : sourceFilesPath) {
                File file = new File(sourceFilePath);
                if (!file.exists())
                    continue;
                if (file.isDirectory()) {
                }
                InputStream in = new FileInputStream(file);
                zipOut.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while ((len = in.read(bytes)) > 0) {
                    zipOut.write(bytes, 0, len);
                }
                zipOut.closeEntry();
                in.close();
            }
            zipOut.close();
            System.out.println("==========compress finish==========");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * 描述: org.apache.tools.zip.ZipOutputStream压缩多个文件为一个ZIP 支持中文
     * 
     * @param sourceFilesPath
     * @param fileName
     * @param compressFilePath
     * @throws FileNotFoundException
     * @author 石涛 date 2014-9-19
     *         -------------------------------------------------- 修改人 修改日期 修改描述
     *         石涛 2014-9-19 创建
     *         --------------------------------------------------
     * @Version Ver1.0
     */
    public static void apacheCompressFilesToZip(String[] sourceFilesPath, String fileName, String compressFilePath) {
        byte[] bytes = new byte[1024];
        try {
            org.apache.tools.zip.ZipOutputStream out = new org.apache.tools.zip.ZipOutputStream(new FileOutputStream(new File(compressFilePath + "\\"
                    + fileName)));
            for (String sourceFilePath : sourceFilesPath) {
                File file = new File(sourceFilePath);
                if (!file.exists())
                    continue;
                InputStream in = new FileInputStream(file);
                out.setEncoding("GBK");
                out.putNextEntry(new org.apache.tools.zip.ZipEntry(file.getName()));
                int len;
                while ((len = in.read(bytes)) > 0) {
                    out.write(bytes, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
            System.out.println("==========compress finish==========");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * 描述:java.util.zip.ZipOutputStream解压文件
     * 
     * @param compressPageDir
     * @param uncompressDir
     * @author 石涛 date 2014-9-19
     *         -------------------------------------------------- 修改人 修改日期 修改描述
     *         石涛 2014-9-19 创建
     *         --------------------------------------------------
     * @Version Ver1.0
     */
    public static void decompressZipToFiles(String compressPageDir, String decompressDir) {
        BufferedInputStream bi;
        try {
            FileInputStream fi = new FileInputStream(compressPageDir);
            CheckedInputStream cis = new CheckedInputStream(fi, new CRC32());
            ZipInputStream input = new ZipInputStream(cis);
            bi = new BufferedInputStream(input);
            ZipEntry ze;
            while ((ze = input.getNextEntry()) != null) {
                String name = ze.getName();
                if (ze.isDirectory()) {
                    File decompressDirFile = new File(decompressDir + "\\" + name);
                    if (!decompressDirFile.exists()) {
                        decompressDirFile.mkdirs();
                    }
                } else {
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(decompressDir + "\\" + name));
                    byte[] buffer = new byte[1024];
                    int read = bi.read(buffer);
                    while (read != -1) {
                        bos.write(buffer, 0, read);
                        read = bi.read(buffer);
                    }
                    bos.close();
                }
            }
            bi.close();
            System.out.println("==========decompress finish==========");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @description: 下载远程图片
     * @param imgurl
     *            图片地址
     * @return OutputStream
     * @author 石涛
     * @date 2014-10-31
     * @-- ------------------------------------------------
     * @xx 修改人修改日期 修改描述
     * @xx 石涛 2014-10-31 创建
     * @-- ------------------------------------------------
     * @Version Ver1.0
     */
    public OutputStream urlDownloadImgage(String imgurl) {
        // 图片名称
        String imgName = imgurl.substring(imgurl.lastIndexOf("/") + 1);
        OutputStream outputStream = null;
        try {
            URL url = new URL(imgurl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            outputStream = new FileOutputStream(imgName);
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = inputStream.read(buffer)) != 0) {
                outputStream.write(buffer, 0, read);
            }
            inputStream.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    public void uploadFile(String path, String fileName) {
        File file = new File(path);
        if (!file.isDirectory()) {// 该目录不存在就创建
            file.mkdirs();
        }

    }

    /**
     * @description: 图片下隐藏文件
     * @param pictureDir
     *            图片文件地址
     * @param hideFileDir
     *            图片下隐藏的文件地址
     * @param targetPictureDir
     *            最终文件地址
     * @author 石涛
     * @date 2014-10-31
     * @-- ------------------------------------------------
     * @xx 修改人修改日期 修改描述
     * @xx 石涛 2014-10-31 创建
     * @-- ------------------------------------------------
     * @Version Ver1.0
     */
    public void hideFileInPicture(String pictureDir, String hideFileDir, String targetPictureDir) {
        try {
            String dosCommand = " cmd /c copy /b ";
            dosCommand += pictureDir + "+" + hideFileDir + " " + targetPictureDir;
            // String str =
            // "cmd /c copy /b C:\\Users\\Administrator\\Desktop\\images\\nesteaice.jpg+C:\\Users\\Administrator\\Desktop\\images\\test.zip C:\\Users\\Administrator\\Desktop\\images\\nesteaice123.jpg";
            Runtime.getRuntime().exec(dosCommand);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片压缩
     * 
     * @param srcFilePath
     * @param descFilePath
     * @return
     */
    public static boolean compressPic(String srcFilePath, String descFilePath) {
        File file = null;
        BufferedImage src = null;
        FileOutputStream out = null;
        ImageWriter imgWrier;
        ImageWriteParam imgWriteParams;

        // 指定写图片的方式为 jpg
        imgWrier = ImageIO.getImageWritersByFormatName("jpg").next();
        imgWriteParams = new javax.imageio.plugins.jpeg.JPEGImageWriteParam(null);
        // 要使用压缩，必须指定压缩方式为MODE_EXPLICIT
        imgWriteParams.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        // 这里指定压缩的程度，参数qality是取值0~1范围内，
        imgWriteParams.setCompressionQuality((float) 0.1);
        imgWriteParams.setProgressiveMode(ImageWriteParam.MODE_DISABLED);
        ColorModel colorModel = ColorModel.getRGBdefault();
        // 指定压缩时使用的色彩模式
        imgWriteParams.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));

        try {
            if (StringUtils.isBlank(srcFilePath)) {
                return false;
            } else {
                file = new File(srcFilePath);
                src = ImageIO.read(file);
                out = new FileOutputStream(descFilePath);

                imgWrier.reset();
                // 必须先指定 out值，才能调用write方法, ImageOutputStream可以通过任何
                // OutputStream构造
                imgWrier.setOutput(ImageIO.createImageOutputStream(out));
                // 调用write方法，就可以向输入流写图片
                imgWrier.write(null, new IIOImage(src, null, null), imgWriteParams);
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * HttpServletResponse实现下载<br/>
     * 注1：setContentType(String type)方法里的参数type是指一个用于指定文件内容的MIME类型<br/>
     * 常见的MIME类型及含义：<br/>
     * text/html 超文本标记语言文本(.html)<br/>
     * text/plain 普通文本(.txt)<br/>
     * image/gif GIF图形(.gif)<br/>
     * image/jpeg JPEG图形(.jpeg或.jpg)<br/>
     * video/x-msvideo AVI文件(.avi)<br/>
     * application/zip zip压缩包(.zip)<br/>
     * application/msword word文档(.doc)<br/>
     * application/vnd.ms-excel excel文档(.xls)<br/>
     * audio/x-mpeg mp3音乐文件(.mp3)<br/>
     * 
     * @param filePath
     * @param response
     * @throws Exception
     */
    public static void serverFileDownload(String filePath, HttpServletResponse response) throws Exception {
        // 创建要下载的文件的对象(参数为要下载的文件在服务器上的路径)
        File serverFile = new File(filePath);
        // 设置要显示在保存窗口的文件名，如果文件名中有中文的话，则要设置字符集，否则会出现乱码。另外，要写上文件后缀名
        String fileName = java.net.URLEncoder.encode("Java编程思想最新版.doc", "utf-8");
        // 该步是最关键的一步，使用setHeader()方法弹出"是否要保存"的对话框，打引号的部分都是固定的值，不要改变
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        /*
         * 以下四行代码经测试似乎可有可无，可能是我测试的文件太小或者其他什么原因。。。
         */
        response.setContentType("application/msword");
        // 定义下载文件的长度 /字节
        long fileLength = serverFile.length();
        // 把长整形的文件长度转换为字符串
        String length = String.valueOf(fileLength);
        // 设置文件长度(如果是Post请求，则这步不可少)
        response.setHeader("content_Length", length);
        /*
         * 以上内容仅是下载一个空文件以下内容用于将服务器中相应的文件内容以流的形式写入到该空文件中
         */
        // 获得一个 ServletOutputStream(向客户端发送二进制数据的输出流)对象
        OutputStream servletOutPutStream = response.getOutputStream();
        // 获得一个从服务器上的文件myFile中获得输入字节的输入流对象
        FileInputStream fileInputStream = new FileInputStream(serverFile);

        byte bytes[] = new byte[1024];// 设置缓冲区为1024个字节，即1KB
        int len = 0;
        // 读取数据。返回值为读入缓冲区的字节总数,如果到达文件末尾，则返回-1
        while ((len = fileInputStream.read(bytes)) != -1) {
            // 将指定 byte数组中从下标 0 开始的 len个字节写入此文件输出流,(即读了多少就写入多少)
            servletOutPutStream.write(bytes, 0, len);
        }
        servletOutPutStream.close();
        fileInputStream.close();
    }
}
