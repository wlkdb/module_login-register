package com.example.lg_login;

import java.security.MessageDigest;
import java.util.Map;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Info {
	public static String str_auto_login="auto_login";
	public static String str_user="user";
	public static String str_password="password";
	
	
	public static SharedPreferences sp;
	
	
	public static String MD5(String str) {
		MessageDigest md5 =null;

		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch(Exception e) {
			e.printStackTrace();
			return "";
		}
		 
		char[] charArray = str.toCharArray();
		byte[] byteArray =new byte[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue =new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) &0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		
		//return encryptmd5(hexValue.toString());
		return hexValue.toString();	
	}
	
	public static void updateSp(Map<String, String> spMap)
	{
		Editor editor=Info.sp.edit();
		for (Map.Entry<String, String> entry:spMap.entrySet()){  
			editor.putString(entry.getKey(), entry.getValue());
			editor.putString(entry.getKey(), entry.getValue());
		}
        editor.commit();
	}
}
