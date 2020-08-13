package com.sunil.esociety_1.service;

import com.sunil.esociety_1.UserPrincipal;
import com.sunil.esociety_1.dao.MonthlyActivitiesDao;
import com.sunil.esociety_1.dao.PaymentsDao;
import com.sunil.esociety_1.dao.UsersDao;
import com.sunil.esociety_1.dao.YearlyActivitiesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    UsersDao usersDao;

    @Autowired
    MonthlyActivitiesDao monthlyActivitiesDao;

    @Autowired
    PaymentsDao paymentsDao;

    @Autowired
    YearlyActivitiesDao yearlyActivitiesDao;
    private double month_amt;
    private double total_mem;
    private double year_amt;

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public double getMonth_amt() {
//        System.out.println("monthlyActivitiesDao.getMonthAmount(1)" + monthlyActivitiesDao.getMonthAmount(this.getCurrentLoggedInSocietyId()));
        return monthlyActivitiesDao.getMonthAmount(this.getCurrentLoggedInUserDetails().get(0));
    }



    public double getTotal_mem() {
//        System.out.println("usersDao.getTotalmembers(1) ->"+usersDao.getTotalmembers(1));
        return usersDao.getTotalmembers(this.getCurrentLoggedInUserDetails().get(0));
    }



    public double getYear_amt() {
        return yearlyActivitiesDao.getYearAmount(this.getCurrentLoggedInUserDetails().get(0));
    }

    public double calMonthAmnt()
    {
        month_amt = getMonth_amt();
        total_mem = getTotal_mem();
        month_amt = month_amt /  total_mem;
        return month_amt;
    }

    public double calYearAmnt()
    {
        year_amt = getYear_amt();
        total_mem = getTotal_mem();
        year_amt = year_amt / (12 * total_mem);
        return year_amt;
    }

    public double total()
    {
        double total = Double.parseDouble(String.format("%.2f", this.calYearAmnt() + this.calMonthAmnt()));
        return total;
    }

    public Double getamountToPay()
    {
        double total = this.total();
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        System.out.println("month--> " +month+"<---||"+"user_id--->"+getCurrentLoggedInUserDetails().get(1));
        System.out.println(paymentsDao.getPaidAmount(getCurrentLoggedInUserDetails().get(1),month));
        if(paymentsDao.getPaidAmount(getCurrentLoggedInUserDetails().get(1),month) == null)
        {
            return 0.00;
        }
        else
        {
            return paymentsDao.getPaidAmount(getCurrentLoggedInUserDetails().get(1),month);
        }

    }

    public List<Integer> getCurrentLoggedInUserDetails()
    {
        //getCurrentLoggedInSocietyId() returns list[society_id,user_id,manager_id]
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserPrincipal) {
            username = ((UserPrincipal)principal).getUsername();
            System.out.println("username ---------> "+username);
        }
        else {
            username = principal.toString();
            System.out.println("else username ----------->"+username);
        }
        int societyId = usersDao.getSocietyId(username);
        int user_id = usersDao.getUserId(username);
        int manager_id = usersDao.getManagerId(username);
        List<Integer> loggedInUserDetails = new ArrayList<Integer>();
        loggedInUserDetails.add(societyId);
        loggedInUserDetails.add(user_id);
        loggedInUserDetails.add(manager_id);
//        List<Users> userDetails = usersDao.getCurrentUserDetails(username);
//        System.out.println("userdets->"+userDetails);


        return loggedInUserDetails;
    }

//    public int getCurrentLoggedInUserId()
//    {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        String username;
//        if (principal instanceof UserPrincipal) {
//            username = ((UserPrincipal)principal).getUsername();
//            System.out.println("username ---------> "+username);
//        }
//        else {
//            username = principal.toString();
//            System.out.println("else username ----------->"+username);
//        }
//        int user_id = usersDao.getUserId(username);
//        return user_id;
//    }

}



    //    List<PayUsers> people = usersDao.getInfo(1);
//    double total_mem = usersDao.getTotalmembers(1);
//    double month_amt = monthlyActivitiesDao.getMonthAmount(1);
//    month_amt = (month_amt / total_mem);
//
//    System.out.println(monthlyActivitiesDao.getMonthAmount(1));
//    double year_amt = yearlyActivitiesDao.getYearAmount(1);
//    year_amt = (year_amt / (12 * total_mem));
//
//    double total = month_amt + year_amt;
//

