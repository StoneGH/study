package com.stone.email.util;

import java.util.Properties;
import java.util.Vector;

/**
 * <p>
 * Class Name: MailSendInfo
 * </p>
 * <p>
 * Description: 邮件基本信息
 * </p>
 * <p>
 * Sample: 该类的典型使用方法和用例
 * </p>
 * <p>
 * Author: 石涛
 * </p>
 * <p>
 * Date: 2014-6-30
 * </p>
 * <p>
 * Modified History: 修改记录，格式(Name) (Version) (Date) (Reason & Contents)
 * </p>
 */
public class MailSendInfo {
    /**
     * 发件服务器
     */
    private String mailServicerHost;
    /**
     * 发送邮件端口
     */
    private String mailServiceProt;
    /**
     * 发件人
     */
    private String fromAddress;
    /**
     * 收件人
     */
    private String toAddres;
    /**
     * 发件人用户名
     */
    private String userName;
    /**
     * 发件人密码
     */
    private String password;
    /**
     * 是否需要验证
     */
    private boolean validate = true;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 附件名称
     */
    private String fileName;
    /**
     * 附件集合
     */
    @SuppressWarnings("rawtypes")
    private Vector file = new Vector();

    public Properties getProperties() {
        Properties pro = new Properties();
        pro.put("mail.smtp.host", this.mailServicerHost);
        pro.put("mail.smtp.socketFactory.port", mailServiceProt);
        pro.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        pro.put("mail.smtp.port", this.mailServiceProt);
        pro.put("mail.smtp.auth", this.validate ? "true" : "false");
        return pro;
    }

    @SuppressWarnings("unchecked")
    public void attachFile(String fileName) {
        file.addElement(fileName);
    }

    public String getMailServicerHost() {
        return mailServicerHost;
    }

    public void setMailServicerHost(String mailServicerHost) {
        this.mailServicerHost = mailServicerHost;
    }

    public String getMailServiceProt() {
        return mailServiceProt;
    }

    public void setMailServiceProt(String mailServiceProt) {
        this.mailServiceProt = mailServiceProt;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddres() {
        return toAddres;
    }

    public void setToAddres(String toAddres) {
        this.toAddres = toAddres;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @SuppressWarnings("rawtypes")
    public Vector getFile() {
        return file;
    }

    @SuppressWarnings("rawtypes")
    public void setFile(Vector file) {
        this.file = file;
    }
}
