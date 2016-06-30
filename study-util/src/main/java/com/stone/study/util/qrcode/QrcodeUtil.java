package com.stone.study.util.qrcode;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import com.swetake.util.Qrcode;

/**
 * 
 * <p>
 * Class Name: QrcodeUtil
 * </p>
 * <p>
 * Description: 二维码生成和解析工具
 * </p>
 * <p>
 * Sample: 该类的典型使用方法和用例
 * </p>
 * <p>
 * Author: 石涛
 * </p>
 * <p>
 * Date: 2015-5-22
 * </p>
 * <p>
 * Modified History: 修改记录，格式(Name) (Version) (Date) (Reason & Contents)
 * </p>
 */
public class QrcodeUtil {

    /**
     * @desc:二维码生成
     * @author: Stone
     * @param content
     * @param deskNo
     * @param file
     * @param logo
     * @param savePath
     * @param size
     * @return
     * @time: 2015-5-22 上午10:36:23
     * @ver: 1.0.0
     */
    public static int createQrcodeWithLogo(String content, String deskNo, File file, String logo, String savePath, int size) {
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');
        qrcode.setQrcodeEncodeMode('B');
        qrcode.setQrcodeVersion(8);// 1-40调整二维码块状的疏密度以及文本存储量[1:16][2:28][3:43][4:64][5:86][6:108][7:124][9:182]
        int qrcodeWidth = 420;
        int qrcodeHeight = 420;
        int rect = 8;// 二维码的大小绘制
        int pixoff = 13; // 设置偏移量，不设置可能导致解析出错 二维码块的疏密度
        int logoWidth = 80;
        int logoHeight = 80;
        int deskNoPosition = qrcodeHeight - 20;// 二维码桌号位置
        int deskNoFontSize = 40;// 桌号字体大小
        int[] deskNoMR = { 42, 62, 86, 110, 134 };// 桌号聚二维码右边距离
        switch (size) {
        case 184:
            qrcodeWidth = 184;
            qrcodeHeight = 184;
            rect = 4;// 二维码的大小绘制
            pixoff = 2; // 设置偏移量，不设置可能导致解析出错 二维码块的疏密度
            logoWidth = 50;
            logoHeight = 50;
            deskNoPosition = qrcodeHeight - 5;// 二维码桌号位置
            deskNoFontSize = 25;// 桌号字体大小
            // 桌号聚二维码右边距离
            deskNoMR[0] = 20;
            deskNoMR[1] = 35;
            deskNoMR[2] = 50;
            deskNoMR[3] = 70;
            deskNoMR[4] = 90;
            qrcode.setQrcodeVersion(7);// 1-40调整二维码块状的疏密度以及文本存储量[1:16][2:28][3:43][4:64][5:86][6:108][7:124][9:182]
            break;
        case 768:
            qrcodeWidth = 768;
            qrcodeHeight = 768;
            rect = 15;// 二维码的大小绘制
            pixoff = 15; // 设置偏移量，不设置可能导致解析出错 二维码块的疏密度
            logoWidth = 200;
            logoHeight = 200;
            deskNoPosition = qrcodeHeight - 30;// 二维码桌号位置
            deskNoFontSize = 80;// 桌号字体大小
            // 桌号聚二维码右边距离
            deskNoMR[0] = 80;
            deskNoMR[1] = 120;
            deskNoMR[2] = 170;
            deskNoMR[3] = 210;
            deskNoMR[4] = 250;
            break;
        }

        try {

            byte[] contentBytes = content.getBytes("utf-8");
            BufferedImage bufImg = new BufferedImage(qrcodeWidth, qrcodeHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D gs = bufImg.createGraphics();
            gs.setBackground(Color.WHITE);
            gs.clearRect(0, 0, qrcodeWidth, qrcodeHeight);
            gs.setColor(Color.BLACK); // 二维码颜色

            if (contentBytes.length > 0 && contentBytes.length < 220) {
                boolean[][] codeOut = qrcode.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * rect + pixoff, i * rect + pixoff, rect, rect);
                        }
                    }
                }
            } else {
                System.out.println("生成失败");
                return -1;
            }

            gs.setStroke(new BasicStroke(3f));
            gs.setColor(Color.RED);

            System.out.println("===============deskno length" + deskNo.getBytes("gbk").length);

            BufferedImage img = getRemotePictrue(logo, savePath, logoWidth, logoHeight);
            if (img != null) {
                int imgWidth = img.getWidth();
                int imgHeight = img.getHeight();
                gs.drawImage(img, (qrcodeWidth - imgWidth) / 2, (qrcodeHeight - imgHeight) / 2, null);
            }

            Font font = new Font("微软雅黑", Font.LAYOUT_NO_LIMIT_CONTEXT, deskNoFontSize);
            gs.setFont(font);
            if (deskNoMR.length >= deskNo.getBytes("gbk").length) {
                gs.drawString(deskNo, (qrcodeWidth - deskNoMR[deskNo.getBytes("gbk").length - 1]), deskNoPosition);
            }
            gs.dispose();
            bufImg.flush();

            // 生成二维码QRCode图片
            ImageIO.write(bufImg, "png", file);
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    /**
     * 
     * 描述: 解析二维码
     * 
     * @param qrcodeImgPath
     *            二维码图片路劲
     * @return 二维码解析后的数据
     * @author 石涛 date 2014-8-28
     *         -------------------------------------------------- 修改人 修改日期 修改描述
     *         石涛 2014-8-28 创建
     *         --------------------------------------------------
     * @Version Ver1.0
     */
    public static String decoderQRCode(String qrcodeImgPath) {
        String decoderData = null;
        try {
            QRCodeDecoder decoder = new QRCodeDecoder();
            File imageFile = new File(qrcodeImgPath);
            final BufferedImage image = ImageIO.read(imageFile);
            decoderData = new String(decoder.decode(new QRCodeImage() {

                public int getWidth() {
                    return image.getWidth();
                }

                public int getPixel(int x, int y) {
                    return image.getRGB(x, y);
                }

                public int getHeight() {
                    return image.getHeight();
                }
            }), "GBK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decoderData;
    }

    /***
     * 下载远程图片
     * 
     * @param tuxiang
     * @param imgPath
     * @param logoWidth
     * @param logoHeight
     * @return
     */
    public static BufferedImage getRemotePictrue(String tuxiang, String imgPath, int logoWidth, int logoHeight) {
        InputStream in = null;
        BufferedImage logo = null;
        String name = tuxiang.substring(tuxiang.lastIndexOf("/") + 1, tuxiang.length());
        String suffix = name.substring(name.lastIndexOf(".") + 1, name.length());
        name = name.substring(0, name.lastIndexOf("."));
        String realPath = imgPath + File.separator + name + "." + suffix;
        FileOutputStream bw = null;
        if (tuxiang != null) {
            try {
                URL url = new URL(tuxiang);
                URLConnection conn = url.openConnection();
                conn.setDoOutput(true);
                conn.setDoInput(true);
                in = conn.getInputStream();

                // Thumbnails.of(in).size(500, 500).toFile(realPath); //缩略图
                bw = new FileOutputStream(new File(realPath));
                byte[] bytes = new byte[1024];
                int len;
                while ((len = in.read(bytes, 0, bytes.length)) != -1) {
                    bw.write(bytes, 0, len);
                }
                logo = ImageIO.read(new File(realPath));
                int width = logo.getWidth();
                int height = logo.getHeight();
                if (width > height) {
                    Thumbnails.of(realPath).sourceRegion(Positions.CENTER, height, height).size(logoWidth, logoHeight).keepAspectRatio(false).toFile(realPath);
                } else {
                    Thumbnails.of(realPath).sourceRegion(Positions.CENTER, width, width).size(logoWidth, logoHeight).keepAspectRatio(false).toFile(realPath);
                }
                logo = ImageIO.read(new File(realPath));
            } catch (Exception e) {
                return null;
            } finally {
                try {
                    if (null != bw)
                        bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return logo;
    }

    public static void main(String[] args) throws Exception {
        // File file = new File("C:\\555.png");
        // String url =
        // "http://i0.sinaimg.cn/photo/2015/0119/U10744P1505DT20150119112807.jpg";
        // String content =
        // "http://114.215.197.146:8888/client/foodspage?qrcodeid=82bf84da3b2f4eb5b84600007e9aeb27&openid=oGZpBt2qf6XoX4FxDi6_n8lVL4D8";
        // System.out.println("url length:" + url.length());
        // System.out.println(createQrcodeWithLogo(content, "包2", file, url,
        // "C:/", 184));
        System.out.println(decoderQRCode("C:\\Users\\Administrator\\Desktop\\ptqrshow1.png"));
    }
}
