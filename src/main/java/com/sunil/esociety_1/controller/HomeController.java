package com.sunil.esociety_1.controller;

import com.sunil.esociety_1.DTO.PayUsers;
//import com.sunil.esociety_1.EmailService;
import com.sunil.esociety_1.dao.MonthlyActivitiesDao;
import com.sunil.esociety_1.dao.PaymentsDao;
import com.sunil.esociety_1.dao.UsersDao;
import com.sunil.esociety_1.dao.YearlyActivitiesDao;
import com.sunil.esociety_1.model.Payments;
import com.sunil.esociety_1.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PaymentsDao paymentsDao;

    @Autowired
    UsersDao usersDao;

    @Autowired
    MonthlyActivitiesDao monthlyActivitiesDao;

    @Autowired
    YearlyActivitiesDao yearlyActivitiesDao;

    @Autowired
    PaymentService paymentService;

//    @Autowired
//    EmailService emailService;

    @GetMapping("/")
    public String home() {
//        emailService.getEmailOfUsers();
        return "home";
    }




//    @GetMapping("/payments")
//    @ResponseBody
//    public List<PayUsers> payments()
//    {
////        ModelAndView mv = new ModelAndView("payments.jsp");
////        List<Payments> people = paymentsDao.findPaymentsById(1);
////        List<PayUsers> people = usersDao.getInfo();
//        System.out.println(usersDao.getInfo());
////        mv.addObject("obj",people);
//        return usersDao.getInfo();
//
//    }

//    @GetMapping("/users")
//    @ResponseBody
//    public List<Users> users()
//    {
////        ModelAndView mv = new ModelAndView("payments.jsp");
//////        List<Payments> people = paymentsDao.findPaymentsById(1);
////        List<PayUsers> people = usersDao.getInfo(1);
////        mv.addObject("obj",people);
////        return mv;
//        return usersDao.findPaymentsById();
//
//    }

//    public ModelAndView payments()
//    {
//
//        ModelAndView mv = new ModelAndView("payments");
////        List<Payments> people = paymentsDao.findPaymentsById(1);
//        List<PayUsers> people = usersDao.getInfo(1);
////        int total_mem = usersDao.getTotalmembers(1);
////        double month_amt = monthlyActivitiesDao.getMonthAmount(1);
////        month_amt = (month_amt / total_mem);
////        System.out.println(monthlyActivitiesDao.getMonthAmount(1));
////        double year_amt = yearlyActivitiesDao.getYearAmount(1);
////        year_amt = (year_amt / (12 * total_mem));
////
////        double total = month_amt + year_amt;

    //        mv.addObject("total",total);
//}




}
