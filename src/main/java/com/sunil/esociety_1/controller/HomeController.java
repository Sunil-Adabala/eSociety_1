package com.sunil.esociety_1.controller;

import com.sunil.esociety_1.DTO.PayUsers;
//import com.sunil.esociety_1.EmailService;
import com.sunil.esociety_1.dao.*;
import com.sunil.esociety_1.model.*;
import com.sunil.esociety_1.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
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

    @Autowired
    SocietiesDao societiesDao;

    @GetMapping("/")
    public String welcome() {
//        emailService.getEmailOfUsers();
        return "welcome";
    }

    @GetMapping("/home")
    public String home(Authentication authentication) {
//        emailService.getEmailOfUsers();
//        List<GrantedAuthority> listAuthorities = new ArrayList<>(authentication.getAuthorities());
//        List<String> listOfAuth = new ArrayList<>();
//        for(GrantedAuthority xyz:authentication.getAuthorities())
//        {
//            listOfAuth.add(xyz.toString());
//            System.out.println(xyz.toString());
//        }
//        if(listOfAuth.contains("ADMIN"))
//        {
//            return "redirect:/admin";
//        }
//        else if(listOfAuth.contains("MANAGER"))
//        {
//            return "redirect:/user";
//        }
//        else {
//            System.out.println("IT was else");
//            return "home";
//        }
        return "home";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
//        emailService.getEmailOfUsers();
        return "hey! admin";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
//        emailService.getEmailOfUsers();
        return "hey! user";
    }






    @RequestMapping(value = "/addsociety", method = RequestMethod.GET)
    public ModelAndView addSociety() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("societies", new Societies());
        modelAndView.setViewName("addSociety"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value = "/addsociety", method = RequestMethod.POST)
    public ModelAndView addSociety(@Valid Societies societies, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        societiesDao.save(societies);
//        modelAndView.addObject("societies", new Societies());
        modelAndView.setViewName("home"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value = "/addmonthlyactivity", method = RequestMethod.GET)
    public ModelAndView addMonthlyActivity() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("mActivities", new MonthlyActivities());
        modelAndView.setViewName("monthlyActivities"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value = "/addmonthlyactivity", method = RequestMethod.POST)
    public ModelAndView addMonthlyActivity(@Valid MonthlyActivities monthlyActivities, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(paymentService.getCurrentLoggedInUserDetails().get(0));
        monthlyActivities.setSociety_id(paymentService.getCurrentLoggedInUserDetails().get(0));
        monthlyActivities.setManager_id(1);
        monthlyActivitiesDao.save(monthlyActivities);
//        modelAndView.addObject("societies", new Societies());
        modelAndView.setViewName("home"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value = "/addyearlyactivity", method = RequestMethod.GET)
    public ModelAndView addYearlyActivity() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("yActivities", new YearlyActivities());
        modelAndView.setViewName("/ManagerTemplates/addYearlyActivities"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value = "/addyearlyactivity", method = RequestMethod.POST)
    public ModelAndView addYearlyActivity(@Valid YearlyActivities yearlyActivities, BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(paymentService.getCurrentLoggedInUserDetails().get(0));
        yearlyActivities.setSociety_id(paymentService.getCurrentLoggedInUserDetails().get(0));
        yearlyActivities.setManager_id(1);
        yearlyActivitiesDao.save(yearlyActivities);
//        modelAndView.addObject("societies", new Societies());
        modelAndView.setViewName("home"); // resources/template/register.html
        return modelAndView;
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
