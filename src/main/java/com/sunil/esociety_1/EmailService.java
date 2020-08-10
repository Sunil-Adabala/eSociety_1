//package com.sunil.esociety_1;
//import com.sunil.esociety_1.dao.UsersDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.List;
//import java.util.Properties;
//
//@Service
//public class EmailService {
//
//    /**
//     * Utility method to send simple HTML email
////     * @param session
////     * @param toEmail
////     * @param subject
////     * @param body
//     */
//
//
//    @Autowired
//    UsersDao usersDao;
//
////    @RequestMapping("/test3")
////    @ResponseBody
////    public String test()
////    {
////        List<String> emails=usersDao.getEmailOfAllusers();
////        for(String email:emails) {
////
////            System.out.println("Email  "+email);
////            sendEmail(email, "Email Testing Subject1", "Email Testing Body1");
////        }
////        return usersDao.getEmailOfAllusers().get(0);
////    }
//
//    public String getEmailOfUsers()
//    {
//        List<String> emails=usersDao.getEmailOfAllusers();
//        for(String email:emails) {
//
//            System.out.println("Email  "+email);
//            sendEmail(email, "Email Testing Subject1", "Email Testing Body1");
//        }
//        return usersDao.getEmailOfAllusers().get(0);
//    }
//
//
//    public  void  sendEmail(String toEmail, String subject, String body){
//        List<String> emails=usersDao.getEmailOfAllusers();
//
//        System.out.println(usersDao.getEmailOfAllusers().get(0));
//
//        try
//        {
//
//            final String fromEmail = "suniladabalacsec2@vjit.ac.in"; //requires valid gmail id
//            final String password = "8801343595"; // correct password for gmail id
//
//            Authenticator auth = new Authenticator() {
//                //override the getPasswordAuthentication method
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(fromEmail, password);
//                }
//            };
//
//            Properties props = new Properties();
//            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host smtp.mailtrap.io
//            props.put("mail.smtp.port", "587"); //TLS Port
//            props.put("mail.smtp.auth", "true"); //enable authentication
//            props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
//
//            Session session = Session.getInstance(props, auth);
//            MimeMessage msg = new MimeMessage(session);
//
//            //set message headers
//            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//            msg.addHeader("format", "flowed");
//            msg.addHeader("Content-Transfer-Encoding", "8bit");
//
//            msg.setFrom(new InternetAddress("suniladabalacsec@vjit.ac.in", "NoReply-JD"));
//
//            msg.setReplyTo(InternetAddress.parse("adabalasunil@gmail.com", false));
//
//            msg.setSubject("test", "UTF-8");
//
//            msg.setText("fuck u", "UTF-8");
//
//            msg.setSentDate(new Date());
//
//
//            List<String> lst = new ArrayList<>();
//            lst.add("adabalasunil@gmail.com");
////            getEmailOfUsers();
//
//
//            for(int i = 0;i<lst.size();i+=1)
//            {
//                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("adabalasunil@gmail.com", false));
//
//            }
//
//            Transport.send(msg);
//
//            System.out.println("EMail Sent Successfully!!");
//        }
//
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
