/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.AccountDAO;
import POJOs.Account;
import POJOs.Conference;
import POJOs.UserHoinghi;
import POJOs.UserHoinghiId;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hungh
 */
public class AccountBUS {
    public static int getNumberNormalUser()
    {
        int result = 0;
        List<Account> list = AccountDAO.getListAccount();
        for (Account account : list) {
            if (account.getAccountType() == 1) result+=1;
        }
        return result;
    }
    
    public static int getActiveNormalUser()
    {
        int result = 0;
        List<Account> list = AccountDAO.getListAccount();
        for (Account account : list) {
            if (account.getAccountType() == 1 && account.getIsActive() == 1) result+=1;
        }
        return result;
    }
    
    public static int getStateOfAccountJoinConference(Account ac, Conference cf)
    {
        if(ac == null || cf == null) return -2;
        int result = -1;
        int idCon = cf.getIdHoiNghi();
        Iterator<UserHoinghi> userHoiNghis = ac.getUserHoinghis().iterator();
        while(userHoiNghis.hasNext())
        {
            UserHoinghi temp = userHoiNghis.next();
            if (temp.getConference().getIdHoiNghi() == idCon)
            {
                if(temp.getStatus() == 1) result = 1;
                else if (temp.getStatus() == 0) result = 0;
            }
        }   
        return result;
    }

}
