package com.stone.email.util;

public class EmailTest {
    public void send() {
        MailSendInfo mailInfo = new MailSendInfo();
        mailInfo.attachFile("C:\\Users\\Administrator\\Desktop\\template.xlsx");
        // mailInfo.setMailServicerHost("smtp.qq.com");
        // mailInfo.setMailServiceProt("465");
        mailInfo.setMailServicerHost("mail.jsdttec.com");
        mailInfo.setMailServiceProt("25");
        mailInfo.setValidate(true);

        mailInfo.setUserName("shitao@jsdttec.com");
        mailInfo.setPassword("11111111111111");
        mailInfo.setFromAddress("shitao@jsdttec.com");
        mailInfo.setToAddres("476896460@qq.com");
        mailInfo.setSubject("测试发送邮件");
        mailInfo.setContent("这是一封测试邮件，请不要做任何回复<a href=\"http://www.baidu.com\" target=\"_blank\">百度</a><img style=\"width:300px;height:300px;\" src=\"http://upload.cankaoxiaoxi.com/2015/0507/thumb_114_84_1430951565721.jpg\"/>");
        System.out.println(SimpleMailSender.sendHtmlMail(mailInfo));
        // System.out.println(SimpleMailSender.sendTextMail(mailInfo));
    }
}
