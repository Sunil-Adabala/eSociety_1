package com.sunil.esociety_1.controller;

import com.sunil.esociety_1.dao.ManagersDao;
import com.sunil.esociety_1.model.Managers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testController {

    @Autowired
    ManagersDao managersDao;

    @RequestMapping("/test")
    public List<Managers> test()
    {
        System.out.println("here");
//        System.out.println(userRepo.findAll());
        return managersDao.findAll();
    }
}
