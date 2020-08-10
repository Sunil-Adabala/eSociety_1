package com.sunil.esociety_1.controller;

import com.sunil.esociety_1.DTO.PayUsers;
import com.sunil.esociety_1.dao.PaymentsDao;
import com.sunil.esociety_1.dao.UsersDao;
import com.sunil.esociety_1.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Controller
public class ReportsController {

    @Autowired
    PaymentsDao paymentsDao;
    @Autowired
    UsersDao usersDao;

    @Autowired
    PaymentService paymentService;

    @RequestMapping("/reports")
    public String getReports()
    {
        System.out.println("hey");
        return "/ReportsTemplates/reports";
    }

    @GetMapping("/reports/yreports")
    public ModelAndView getReportsByYear(@RequestParam("year") int year)
    {
//        System.out.println("called" + year);
        ModelAndView mv = new ModelAndView("/ReportsTemplates/yreports");
        int society_id = paymentService.getCurrentLoggedInUserDetails().get(0);
//        System.out.println(usersDao.getYearReport(year,society_id));
        List<PayUsers> years = usersDao.getYearReport(year,society_id);
        mv.addObject("year",years);
        return mv;
    }

    @GetMapping("/reports/unpaid_paymemnts")
    public ModelAndView getReportsByYear(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("from") String from, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("to") String to, Model model) throws ParseException {
        ModelAndView mv = new ModelAndView("/ReportsTemplates/unpaidPayments");
        String s1=from;
        Date from_date= Date.valueOf(s1);//converting string into sql date
        System.out.println("--------------->"+from_date+"<------------------------");
        String s2=to;
        Date to_date= Date.valueOf(s2);//converting string into sql date
        System.out.println("--------------->"+to_date+"<------------------------");

        List<PayUsers> unpaid_obj = usersDao.getUnpaid(from_date,to_date);
        System.out.println(unpaid_obj);
        mv.addObject("unpaid_obj",unpaid_obj);
        return mv;
    }

//    @RequestMapping("/report/yreports")
//    public ModelAndView getReportsByYear(@RequestParam("year") int year)
//    {
//        System.out.println("called" + year);
//        ModelAndView mv1 = new ModelAndView("yreports.jsp");
//        System.out.println(paymentsDao.getYearReports(2020));
//        mv1.addObject("year",year);
//        return mv1;
////        return "yreports.jsp";
//    }
}
