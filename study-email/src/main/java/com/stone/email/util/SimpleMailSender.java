package com.stone.email.util;

import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * <p>
 * Class Name: SimpleMailSender
 * </p>
 * <p>
 * Description: 邮件发送(带附件)
 * </p>
 * <p>
 * Sample: 使用时需要加入mail.jar文件，因为JDK中只有mail的接口，没有实现类
 * </p>
 * <p>
 * Author: 石涛
 * </p>
 * <p>
 * Date: 2014-11-27
 * </p>
 * <p>
 * Modified History: 修改记录，格式(Name) (Version) (Date) (Reason & Contents)
 * </p>
 */
public class SimpleMailSender {

    /**
     * @description: 发送文本邮件
     * @param mailInfo
     * @return
     * @author 石涛
     * @date 2014-11-27
     * @-- ------------------------------------------------
     * @xx 修改人修改日期 修改描述
     * @xx 石涛 2014-11-27 创建
     * @-- ------------------------------------------------
     * @Version Ver1.0
     */
    public static boolean sendTextMail(MailSendInfo mailInfo) {
        // 判断是否需要身份验证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址
            Address to = new InternetAddress(mailInfo.getToAddres());
            // 设置邮件消息的接收者
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息的发送时间
            mailMessage.setSentDate(new Date());
            // 设置邮件消息的内容
            mailMessage.setText(mailInfo.getContent());
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * @description:发送HTML邮件，并且带附件
     * @param mailInfo
     * @return
     * @author 石涛
     * @date 2014-11-27
     * @-- ------------------------------------------------
     * @xx 修改人修改日期 修改描述
     * @xx 石涛 2014-11-27 创建
     * @-- ------------------------------------------------
     * @Version Ver1.0
     */
    @SuppressWarnings("rawtypes")
    public static boolean sendHtmlMail(MailSendInfo mailInfo) {
        // 判断是否需要身份验证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            // 如果需要身份认证，则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            // 根据session创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            // 创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress());
            // 设置邮件消息的发送者
            mailMessage.setFrom(from);
            // 创建邮件的接收者地址
            Address to = new InternetAddress(mailInfo.getToAddres());
            // 设置邮件消息的接收者
            mailMessage.setRecipient(Message.RecipientType.TO, to);
            // 设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            // 设置邮件消息的发送时间
            mailMessage.setSentDate(new Date());
            // MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart multipart = new MimeMultipart();
            // 利用枚举器方便的遍历集合
            Enumeration efile = mailInfo.getFile().elements();
            // 检查序列中是否还有更多的对象
            while (efile.hasMoreElements()) {
                MimeBodyPart mbp = new MimeBodyPart();
                // 选择出每一个附件名
                mailInfo.setFileName(efile.nextElement().toString());
                // 得到数据源
                FileDataSource fds = new FileDataSource(mailInfo.getFileName());
                // 得到附件本身并至入BodyPart
                mbp.setDataHandler(new DataHandler(fds));
                // 得到文件名同样至入BodyPart
                mbp.setFileName(fds.getName());
                multipart.addBodyPart(mbp);
            }
            // 移走集合中的所有元素
            mailInfo.getFile().removeAllElements();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置邮件消息的内容
            html.setContent(mailInfo.getContent(), "text/html;charset=utf-8");
            multipart.addBodyPart(html);
            // Multipart加入到信件
            mailMessage.setContent(multipart);
            // 发送邮件
            Transport.send(mailMessage);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
