package com.sunil.esociety_1.controller;

import com.sunil.esociety_1.DTO.PayUsers;
import com.sunil.esociety_1.dao.PaymentsDao;
import com.sunil.esociety_1.dao.UsersDao;
import com.sunil.esociety_1.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class ReportsController {

    @Autowired
    PaymentsDao paymentsDao;
    @Autowired
    UsersDao usersDao;

    @RequestMapping("/reports")
    public String getReports()
    {
        System.out.println("hey");
        return "reports.jsp";
    }

    @GetMapping("/yreports")
    public ModelAndView getReportsByYear(@RequestParam("year") int year)
    {
//        System.out.println("called" + year);
        ModelAndView mv = new ModelAndView("yreports.jsp");
        System.out.println(usersDao.getYearReport(year));
        List<PayUsers> years = usersDao.getYearReport(year);
        mv.addObject("year",years);
        return mv;
//        return "yreports.jsp";
    }

    @GetMapping("/unpaid_paymemnts")
    public ModelAndView getReportsByYear(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("from") Date from, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("to") Date to,Model model)
    {
        ModelAndView mv = new ModelAndView("unpaid_payments.jsp");
        System.out.println(from+" "+to);
        List<PayUsers> unpaid_obj = usersDao.getUnpaid(from,to);
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
