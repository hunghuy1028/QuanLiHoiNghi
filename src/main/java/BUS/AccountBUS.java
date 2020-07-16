/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.AccountDAO;
import POJOs.Account;
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

}
