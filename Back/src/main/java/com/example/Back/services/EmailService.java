package com.example.Back.services;

import com.example.Back.dto.MailData;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;
import java.util.Map;

@Service
@Log
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("spring.mail.username")
    private String fromMail;

    @Async
    public void sendMail(MailData mailData, String mailConfigure){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

            message.setFrom(fromMail, fromMail);
            message.setTo(mailData.getRecipientTo());
            message.setSubject(mailData.getSubject());
            message.setText(mailConfigure, true);

            javaMailSender.send(mimeMessage);
            log.info("Mail Send Successfully To ");
        } catch (MessagingException e) {
            log.info("There is an error in mail ---->" + e.getMessage());

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }


    @Async
    public void doSendMail(String emailConfiguration ,String subject, String fileName, String recipientTo) throws Exception {
        MailData mailData = MailData.builder()
                .subject(subject)
                .recipientTo(recipientTo)
                .fileName(fileName)
                .build();

        sendMail(mailData, emailConfiguration);

    }

    void processEmailTemplateAndSend(Map<String, Object> model, Context context, String recipientTo, String subject, String templatePath) throws Exception {

        context.setVariables(model);

        String html = templateEngine.process(templatePath, context);


        doSendMail(html, subject , templatePath, recipientTo);
    }

}
