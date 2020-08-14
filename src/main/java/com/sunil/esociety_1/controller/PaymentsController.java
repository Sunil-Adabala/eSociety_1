package com.sunil.esociety_1.controller;

import com.sunil.esociety_1.DTO.PayUsers;
import com.sunil.esociety_1.dao.MonthlyActivitiesDao;
import com.sunil.esociety_1.dao.PaymentsDao;
import com.sunil.esociety_1.dao.UsersDao;
import com.sunil.esociety_1.dao.YearlyActivitiesDao;
import com.sunil.esociety_1.model.Payments;
import com.sunil.esociety_1.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PaymentsController {

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

    @GetMapping("/payments")
    public ModelAndView payments() {
        ModelAndView mv = new ModelAndView("/PaymentsTemp/payments");
        //getCurrentLoggedInSocietyId() returns list[society_id,user)id]
        List<PayUsers> people = usersDao.getInfo(paymentService.getCurrentLoggedInUserDetails().get(1));
        mv.addObject("obj", people);
        return mv;
    }

    @RequestMapping(value="/payments/paydue", method= RequestMethod.POST)
    public ModelAndView paydue(@Valid Payments payments, BindingResult bindingResult, ModelMap modelMap) {
        payments.setManager_id(paymentService.getCurrentLoggedInUserDetails().get(2));
        payments.setSociety_id(paymentService.getCurrentLoggedInUserDetails().get(0));
        payments.setUser_id(paymentService.getCurrentLoggedInUserDetails().get(1));
        paymentsDao.save(payments);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("payments", new Payments());
        modelAndView.setViewName("/PaymentsTemp/payments");
        return modelAndView;
    }

    @RequestMapping(value="/payments/paydue", method= RequestMethod.GET)
    public ModelAndView paydue() {
        ModelAndView mv = new ModelAndView("/home");
//        ModelAndView modelAndView = new ModelAndView();
        Double totalAmountToPay = (paymentService.total() - paymentService.getamountToPay());
        System.out.println("------------------"+paymentService.getamountToPay()+"--------------------------------------------");
        mv.addObject("totalAmount",totalAmountToPay);
        mv.addObject("payments", new Payments());
        return mv;
    }
}


//    @GetMapping("/payments")
//    public ModelAndView payments() {
////        Payments payments = new Payments();
//        ModelAndView mv = new ModelAndView("/PaymentsTemp/payments");
//        //getCurrentLoggedInSocietyId() returns list[society_id,user)id]
//        List<PayUsers> people = usersDao.getInfo(paymentService.getCurrentLoggedInUserDetails().get(1));
//        mv.addObject("obj", people);
////        mv.addObject("payments", payments);
//        //check Payments service for calculation;
////        Double totalAmountToPay = (paymentService.total() - paymentService.getamountToPay());
////        System.out.println("------------------"+paymentService.getamountToPay()+"--------------------------------------------");
////        mv.addObject("totalAmount",totalAmountToPay);
////        mv.addObject("paidAmount",paymentService.getamountToPay());
////        mv.addObject("total", paymentService.total());
//        return mv;
//    }