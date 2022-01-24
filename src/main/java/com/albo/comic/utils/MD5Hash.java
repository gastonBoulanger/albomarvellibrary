package com.albo.comic.utils;

import org.springframework.util.DigestUtils;

public class MD5Hash {
	
	public static String generator(String data) {
		String result = null;
        try {
        	result = DigestUtils.md5DigestAsHex(data.getBytes());
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
	}
}
