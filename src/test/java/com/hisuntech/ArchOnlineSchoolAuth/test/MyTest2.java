/*
 * Copyright (c) 2015, 2016, Hisuntech and/or its affiliates. All rights reserved.
 * Hisuntech PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.hisuntech.ArchOnlineSchoolAuth.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @description 
 * @author wuchunzhi
 * @date 2016年6月16日 下午4:09:10
 */
public class MyTest2 {
	
	public static void main(String[] args){
		try{
			String urlStr = "http://www.stongnet.com/sdkhttp/sendsms.aspx?reg=101100-WEB-HUAX-467724&pwd=YCDISCCS&sourceadd=&phone=18280300427&content=注册验证码为330855，请在注册页面填下验证码完成注册验证。（如非本人操作，请忽略）【全国BIM管理中心】";
			System.out.println(urlStr);
			URL url = new URL(urlStr);
			// 打开url连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// 设置url请求方式 ‘get’ 或者 ‘post’
			connection.setRequestMethod("GET");
			// 发送
			InputStream is =url.openStream();
			//转换返回值
			String returnStr = convertStreamToString(is);
	        System.out.println("return strResult:"+ returnStr);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
        
	}
	
	/**
	 * 转换返回值类型为UTF-8格式.
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is) {    
        StringBuilder sb1 = new StringBuilder();    
        byte[] bytes = new byte[4096];  
        int size = 0;  
        
        try {    
        	while ((size = is.read(bytes)) > 0) {  
                String str = new String(bytes, 0, size, "UTF-8");  
                sb1.append(str);  
            }  
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb1.toString();    
    }
}
