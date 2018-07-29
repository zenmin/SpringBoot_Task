package com.zm.springboot_task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl javaMailSender;

    //测试邮件发送
    @Test
    public void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo("15228766049@163.com");     //收件人地址不对  会抛出550 Invalid Addresses
        simpleMailMessage.setText("测试邮件任务");
        simpleMailMessage.setSubject("这是标题");
        simpleMailMessage.setFrom("741703967@qq.com");
        javaMailSender.send(simpleMailMessage);
    }

    //测试复杂邮件发送
    @Test
    public void testMail2() throws Exception {
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage,true);  //multipart=true 表示这是一个可以上传附件的消息
        mimeMessageHelper.setTo("15228766049@163.com");     //收件人地址不对  会抛出550 Invalid Addresses
        mimeMessageHelper.setText("<b>测试邮件任务<b>",true);     //表明这是一个html片段
        mimeMessageHelper.setSubject("这是标题");
        mimeMessageHelper.setFrom("741703967@qq.com");
        //添加邮件附件
        mimeMessageHelper.addAttachment("cs.png",new File("C:\\Users\\74170\\Pictures\\FLAMING MOUNTAIN.png"));

        javaMailSender.send(mimeMailMessage);
    }

}
