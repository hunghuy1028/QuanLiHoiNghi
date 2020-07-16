/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author hungh
 */
public class SupportFile {
    
    public static String getSecurePassword(String passwordToHash) throws NoSuchAlgorithmException
    {
        String generatedPassword = null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        //Add password bytes to digest
        md.update(passwordToHash.getBytes());
        //Get the hash's bytes 
        byte[] bytes = md.digest();
        //This bytes[] has bytes in decimal format;
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        //Get complete hashed password in hex format
        generatedPassword = sb.toString();
        return generatedPassword;
    }
    
//    public static int getIdConferenceByCustomName(String name)
//    {
//        return Integer.valueOf(name.substring(11));
//    }
    
    public static String getCustomTimeString(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return String.format(day + "/" + month + "/" + year + " " + hour + ":" + minute);
    }
    
//    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
//        Date d = c.getTime();
//        String kq = getCustomTimeString(d);
//        System.out.println("kq: "+ kq);
//    }
}
