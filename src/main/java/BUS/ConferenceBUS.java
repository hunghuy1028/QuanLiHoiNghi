/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConferenceDAO;
import POJOs.Conference;
import POJOs.UserHoinghi;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hungh
 */
public class ConferenceBUS {
    public static int getTotalParticipants(Conference cf)
    {
        int count = 0;
        for (Iterator<UserHoinghi> iterator = cf.getUserHoinghis().iterator(); iterator.hasNext();) {
            UserHoinghi next = iterator.next();
            count++;
        }
        return count;
    }
    
    public static int getNumberParticipantsAccpet(Conference cf)
    {
        int count = 0;
        for (Iterator<UserHoinghi> iterator = cf.getUserHoinghis().iterator(); iterator.hasNext();) {
            UserHoinghi next = iterator.next();
            if(next.getStatus() == 1) 
                count++;
        }
        return count;
    }
    
}
