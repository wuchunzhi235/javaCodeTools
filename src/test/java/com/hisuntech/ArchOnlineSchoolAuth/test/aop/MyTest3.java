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

package com.hisuntech.ArchOnlineSchoolAuth.test.aop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.alipay.config.AlipayConfig;
import com.alipay.sign.RSA;
import com.alipay.util.AlipayCore;

/**
 * @description 
 * @author wuchunzhi
 * @date 2016年7月26日 下午5:55:32
 */
public class MyTest3 {
	private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> sParaTemp = new HashMap<String, String>();
		
		
		/**
key = subject and value = 
key = sign_type and value = 
key = is_total_fee_adjust and value = 
key = notify_type and value = 
key = out_trade_no and value = 
key = gmt_payment and value = 
key = trade_status and value = 
key = sign and value = 
key = gmt_create and value = 
key = buyer_email and value = wuchunzhi235@163.com
key = price and value = 1.00
key = total_fee and value = 1.00
key = seller_id and value = 2088021521071865
key = quantity and value = 1
key = seller_email and value = jky1156@126.com
key = notify_id and value = 
key = payment_type and value = 1
		 */
		sParaTemp.put("buyer_id", "2088002160867934");
		sParaTemp.put("trade_no", "2016072721001004930253080736");
		sParaTemp.put("use_coupon", "N");
		sParaTemp.put("notify_time", "2016-07-27 11:12:27");
		sParaTemp.put("subject", "创课贴订单-16072700000055");
		sParaTemp.put("sign_type", "RSA");
		sParaTemp.put("is_total_fee_adjust", "N");
		sParaTemp.put("notify_type", "trade_status_sync");
		sParaTemp.put("out_trade_no", "16072700000055");
		sParaTemp.put("gmt_payment", "2016-07-27 11:12:27");
		sParaTemp.put("trade_status", "TRADE_SUCCESS");
		sParaTemp.put("sign", "mI4jTU1H6EcO5Ic160A/Pk0u4GTspog9KEwtseJ3v/lBQulGXBBB4HGd+UACr0vjaxm/Rrj5oHLjvbaAvR4TuU+Se7WkToFruG2Lcfq5k2pAjGEJ62B28VbKaeC7V5IJoGCDR5XqLukr+nL3fsp9+iqyKCuRSNjbP9JXThG9Bjg=");
		sParaTemp.put("gmt_create", "2016-07-27 11:12:26");
		sParaTemp.put("buyer_email", "wuchunzhi235@163.com");
		sParaTemp.put("price", "1.00");
		sParaTemp.put("total_fee", "1.00");
		sParaTemp.put("seller_id", "2088021521071865");
		sParaTemp.put("quantity", "1");
		sParaTemp.put("seller_email", "jky1156@126.com");
		sParaTemp.put("notify_id", "bd0082367a8ef60c5f4a977944a5ba7n6e");
		sParaTemp.put("payment_type", "1");
		
		if(sParaTemp.get("notify_id") != null) {
			String notify_id = sParaTemp.get("notify_id");
			String responseTxt = verifyResponse(notify_id);
			System.out.println("responseTxt:"+responseTxt);
		}
		
		String sign = "";
	    if(sParaTemp.get("sign") != null) {sign = sParaTemp.get("sign");}
	    boolean isSign = getSignVeryfy(sParaTemp, sign);
	    System.out.println("isSign:"+isSign);
	}
	
	
	
	/**
	    * 获取远程服务器ATN结果,验证返回URL
	    * @param notify_id 通知校验ID
	    * @return 服务器ATN结果
	    * 验证结果集：
	    * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
	    * true 返回正确信息
	    * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	    */
	    private static String verifyResponse(String notify_id) {
	        //获取远程服务器ATN结果，验证是否是支付宝服务器发来的请求
	    	//AlipayConfig alipayConfig = new AlipayConfig();
	        String partner = "2088021521071865";//alipayConfig.getPartner();
	        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

	        return checkUrl(veryfy_url);
	    }
	    
	    
	    /**
	     * 获取远程服务器ATN结果
	     * @param urlvalue 指定URL路径地址
	     * @return 服务器ATN结果
	     * 验证结果集：
	     * invalid命令参数不对 出现这个错误，请检测返回处理中partner和key是否为空 
	     * true 返回正确信息
	     * false 请检查防火墙或者是服务器阻止端口问题以及验证时间是否超过一分钟
	     */
	     private static String checkUrl(String urlvalue) {
	         String inputLine = "";

	         try {
	             URL url = new URL(urlvalue);
	             HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	             BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
	                 .getInputStream()));
	             inputLine = in.readLine().toString();
	         } catch (Exception e) {
	             e.printStackTrace();
	             inputLine = "";
	         }

	         return inputLine;
	     }
	     
	     
	     /**
	      * 根据反馈回来的信息，生成签名结果
	      * @param Params 通知返回来的参数数组
	      * @param sign 比对的签名结果
	      * @return 生成的签名结果
	      */
	 	public static boolean getSignVeryfy(Map<String, String> Params, String sign) {
	     	//过滤空值、sign与sign_type参数
	     	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
	         //获取待签名字符串
	         String preSignStr = AlipayCore.createLinkString(sParaNew);
	         //获得签名验证结果
	         boolean isSign = false;
	         //AlipayConfig alipayConfig = new AlipayConfig();
	         if("RSA".equals("RSA")){
	         	isSign = RSA.verify(preSignStr, sign, 
	         			"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB",
	         			//alipayConfig.getAlipay_public_key(), 
	         			"utf-8"
	         			//alipayConfig.getInput_charset()
	         			);
	         }
	         return isSign;
	     }
}
