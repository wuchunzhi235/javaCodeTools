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
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;

import com.alipay.config.AlipayConfigTX;
import com.alipay.util.httpClient.HttpProtocolHandler;
import com.alipay.util.httpClient.HttpRequest;
import com.alipay.util.httpClient.HttpResponse;
import com.alipay.util.httpClient.HttpResultType;

/**
 * @description 
 * @author wuchunzhi
 * @date 2016年6月16日 下午4:09:10
 */
public class MyTest {
	
	public static void main(String[] args) throws HttpException, IOException{
		
		Map<String, String> sParaTemp = new HashMap<String, String>();
		
		//RqPnCoPT3K9%252Fvwbh3InQ8DTlBqQF2KlM0p08vXXXXXXXXXXMK3zQ4hsFX%252F3tstP
		sParaTemp.put("WIDout_trade_no", "16051800000164");
		//sParaTemp.put("WIDsubject", "16051800000164");
		sParaTemp.put("WIDtotal_fee", "0.1");
		sParaTemp.put("payType", "10");
//		sParaTemp.put("seller_id", "2088021521071865");
//		sParaTemp.put("service", "alipay.wap.create.direct.pay.by.user");
//		sParaTemp.put("subject", "建客学院订单-16051800000164");
//		sParaTemp.put("total_fee", "0.01");
//		sParaTemp.put("trade_no", "2016051821001004490280869093");
//		sParaTemp.put("trade_status", "TRADE_SUCCESS");
//		sParaTemp.put("sign_type", "RSA");
		
		
		String url = "http://192.168.1.126:8080/ArchOnlineSchoolBack/getAlipayAdr/getAdr";
		
		//String url = "http://101.200.75.226:8083/ArchOnlineSchoolBack/getAlipayAdr/getAdr";
		
		
        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();

        HttpRequest request = new HttpRequest(HttpResultType.BYTES);
        //设置编码集
        request.setCharset(AlipayConfigTX.input_charset);

        request.setParameters(generatNameValuePair(sParaTemp));
        request.setUrl(url);

        HttpResponse response = httpProtocolHandler.execute(request,"","");
        if (response == null) {
        	System.out.println("return null;");
            
        }
        
        String strResult = response.getStringResult();
        System.out.println("return strResult;"+ strResult);
        
	}
	
	
	/**
     * MAP类型数组转换成NameValuePair类型
     * @param properties  MAP类型数组
     * @return NameValuePair类型数组
     */
    private static NameValuePair[] generatNameValuePair(Map<String, String> properties) {
        NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
        }

        return nameValuePair;
    }
}
