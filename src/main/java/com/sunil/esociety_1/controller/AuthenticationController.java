package com.sunil.esociety_1.controller;

//import com.sunil.esociety_1.dao.ManagersDao;
import com.sunil.esociety_1.dao.PaymentsDao;
import com.sunil.esociety_1.dao.SocietiesDao;
import com.sunil.esociety_1.dao.UsersDao;
import com.sunil.esociety_1.model.Payments;
import com.sunil.esociety_1.model.Users;
import com.sunil.esociety_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @Autowired
    PaymentsDao paymentsDao;

    @Autowired
    UsersDao usersDao;

    @Autowired
    SocietiesDao societiesDao;



//    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
//    public ModelAndView login() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login"); // resources/template/login.html
//        return modelAndView;
//    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        System.out.println("Called");
        System.out.println("YOOOOOOOO"+usersDao.getEmailOfAllusers());
        ModelAndView modelAndView = new ModelAndView();
        Users user = new Users();
        modelAndView.addObject("user", user);
        modelAndView.addObject("societies",societiesDao.getSocietyNames());
//        modelAndView.addObject("managers",managersDao.getMangerNames());
        modelAndView.setViewName("register"); // resources/template/register.html
        return modelAndView;
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public ModelAndView registerUser(
            @RequestParam(value = "society_name", required = false) String society_name,
//            @RequestParam(value = "manager_name", required = false) String manager_name,
            @Valid Users user,
            BindingResult bindingResult,
            ModelMap modelMap)
    {
        System.out.println(user);
        ModelAndView modelAndView = new ModelAndView();
        // Check for the validations
        System.out.println("society_name ----------------->>>>>>"+society_name);
        System.out.println(societiesDao.getSocietyId(society_name));
        user.setSociety_id(societiesDao.getSocietyId(society_name));
//        user.setManager_id(managersDao.getMangerId(manager_name));
        if(bindingResult.hasErrors())
        {
            modelAndView.addObject("successMessage", "Please correct the errors in form!");
            modelMap.addAttribute("bindingResult", bindingResult);
        }
        else if(userService.isUserAlreadyPresent(user))
        {
            modelAndView.addObject("successMessage", "user already exists!");
        }
     // we will save the user if, no binding errors
        else
        {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User is registered successfully!");
        }
        modelAndView.addObject("user", new Users());
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/addmanager", method = RequestMethod.GET)
    public ModelAndView addUser() {
        System.out.println("Called");
        ModelAndView modelAndView = new ModelAndView();
        Users user = new Users();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("addManager");
        return modelAndView;
    }

    @RequestMapping(value="/addmanager", method=RequestMethod.POST)
    public ModelAndView addUser(@Valid Users user, BindingResult bindingResult, ModelMap modelMap) {
        System.out.println(user);
        usersDao.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new Users());
        modelAndView.setViewName("home");
        return modelAndView;
    }




}
