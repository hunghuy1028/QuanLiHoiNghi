/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author hungh
 */
public class HashPassword {
    
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
    
//    public static void main(String[] args) {
//        HashPassword a = new HashPassword();
//        String re = a.getSecurePassword("hung123");
//        System.out.println("pass: " + re);
//    }
}
