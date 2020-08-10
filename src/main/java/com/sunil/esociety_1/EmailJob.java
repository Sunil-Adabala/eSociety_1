//package com.sunil.esociety_1;
//
//import com.sunil.esociety_1.EmailService;
//import com.sunil.esociety_1.dao.UsersDao;
//import com.sunil.esociety_1.model.Users;
//import org.quartz.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Configurable;
//
//
//import java.util.Date;
//@Configurable
//@PersistJobDataAfterExecution
//public class EmailJob implements Job {
//    @Autowired
//    UsersDao usersDao;
//
//        public void execute(JobExecutionContext context) throws JobExecutionException {
//        System.out.println("Job1 --->>> Time is " + new Date());
////            context.getJobDetail().getJobDataMap().get()
////        System.out.println(usersDao.getEmailOfAllusers()+"<------------------");
//        EmailService email = new EmailService();
//        email.sendEmail("adabalasunil@gmail.com","Email Testing Subject1", "Email Testing Body1");
//    }
//
//
//
//}
