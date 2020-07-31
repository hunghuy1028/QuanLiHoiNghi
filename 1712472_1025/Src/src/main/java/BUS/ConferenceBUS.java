/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.ConferenceDAO;
import POJOs.Conference;
import POJOs.UserHoinghi;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
    
    public static int getNumberParticipantsPending(Conference cf)
    {
        int count = 0;
        for (Iterator<UserHoinghi> iterator = cf.getUserHoinghis().iterator(); iterator.hasNext();) {
            UserHoinghi next = iterator.next();
            if(next.getStatus() == 0) 
                count++;
        }
        return count;
    }
    
    public static List<UserHoinghi> getListPendingParticipants (Conference cf)
    {
        List<UserHoinghi> result = new ArrayList<>();
        for (Iterator<UserHoinghi> iterator = cf.getUserHoinghis().iterator(); iterator.hasNext();) {
            UserHoinghi next = iterator.next();
            if (next.getStatus() == 0) result.add(next);
        }
        
        return result;
    }
    
    public static Conference getUpcomingConference ()
    {
        List<Conference> list = ConferenceDAO.getListConference();
        Calendar today = Calendar.getInstance();
        for (int i=0; i<list.size(); i++)
        {
            Calendar cal = Calendar.getInstance();
            cal.setTime(list.get(i).getThoiGian());
            if(cal.compareTo(today) < 0)  
            {
                list.remove(i);
                i--;
            }
        }
        
        Collections.sort(list, new Comparator<Conference>()
        {
            @Override
            public int compare(Conference o1, Conference o2) {
                return o1.getThoiGian().compareTo(o2.getThoiGian());             
            }
            
        });
        
        return list.get(0);
    }
}
