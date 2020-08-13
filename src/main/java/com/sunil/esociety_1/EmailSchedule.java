package com.sunil.esociety_1;

import com.sunil.esociety_1.dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class EmailSchedule {

    @Autowired
    UsersDao usersDao;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");


    @Scheduled(cron = "0 0 8 5,6,7,8,9,10 * ?")
    public void scheduleTaskWithCronExpression() {

        List<String> emails=usersDao.getEmailOfAllusers();

        System.out.println(usersDao.getEmailOfAllusers());

        try
        {
            EmailPassword emailPassword = new EmailPassword();

            final String fromEmail = "suniladabalacsec2@vjit.ac.in"; //requires valid gmail id
            final String password = emailPassword.getPassword();

            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            };

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host smtp.mailtrap.io
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);

            //set message headers
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");

            msg.setFrom(new InternetAddress("suniladabalacsec@vjit.ac.in", "NoReply-JD"));

//            msg.setReplyTo(InternetAddress.parse("adabalasunil@gmail.com", false));

            msg.setSubject("ESociety Bill payment", "UTF-8");

            Calendar mCalendar = Calendar.getInstance();
            String thisMonth = mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
            System.out.println(thisMonth);


            String emailMessage = "Please pay the bill of " + thisMonth + " on or before 10th of this month to avoid fine , Please ignore if paid already!";

            msg.setText(emailMessage, "UTF-8");

            msg.setSentDate(new Date());


            emails.add("adabalasunil@gmail.com");
            emails.add("suniladabalacsec2@vjit.ac.in");

            if (emails.size() > 0)
            {
                for (String to : emails)
                {
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    System.out.println("sending email to -->"+to);
                }
            }


//            for(int i = 0;i<lst.size();i+=1)
//            {
//                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("adabalasunil@gmail.com", false));
//                System.out.println("sending email to -->"+lst.get(i));
//
//            }

            Transport.send(msg);

            System.out.println("EMails Sent Successfully!!");
        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
