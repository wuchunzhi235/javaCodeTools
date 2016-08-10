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

import java.util.HashMap;
import java.util.Map;

import com.alipay.util.AlipayNotify;

/**
 * @description 
 * @author wuchunzhi
 * @date 2016年5月11日 下午6:25:37
 */
public class DDDTest {
	
	public static  void main(String[] args){
		/**
		long dd = System.currentTimeMillis();
		System.out.println(dd);
		
		String fmt = "yyyyMMddHHmmss";
    	SimpleDateFormat sdf = new SimpleDateFormat(fmt);
    	String dateStr = sdf.format(new Date());
    	System.out.println(dateStr);
    	
    	String uuid = java.util.UUID.randomUUID().toString();
    	System.out.println(uuid);
    	//yyyyMMddHHmmssZ
    	 * (*/
		
		
		
		Map<String, String> sParaTemp = new HashMap<String, String>();
		
		//RqPnCoPT3K9%252Fvwbh3InQ8DTlBqQF2KlM0p08vXXXXXXXXXXMK3zQ4hsFX%252F3tstP
		sParaTemp.put("is_success", "T");
		sParaTemp.put("notify_id", "RqPnCoPT3K9%2Fvwbh3InXShsPdkahl1szZyud1wE4Ac7hi6UJwp%2BAp7kg%2F97MFR6rdj%2FV");
		sParaTemp.put("notify_time", "2016-05-18 19:10:14");
		sParaTemp.put("notify_type", "trade_status_sync");
		sParaTemp.put("out_trade_no", "16051800000164");
		sParaTemp.put("payment_type", "1");
		sParaTemp.put("seller_id", "2088021521071865");
		sParaTemp.put("service", "alipay.wap.create.direct.pay.by.user");
		sParaTemp.put("subject", "建客学院订单-16051800000164");
		sParaTemp.put("total_fee", "0.01");
		sParaTemp.put("trade_no", "2016051821001004490280869093");
		sParaTemp.put("trade_status", "TRADE_SUCCESS");
		sParaTemp.put("sign_type", "RSA");
		
		
		boolean sdd = AlipayNotify.getSignVeryfy(sParaTemp,
				"kQZ49Qp4dHTEsFNPK0ftT0dqCuPRqNHIjP6/JzPpG1It4x8LMHHSY7oHa+sNouPFyVbaPFyRcS8iEQPysU0ccusRILSJfGdXc698CY3XMaeXMotuIgWyKNwHJ58nTjBaG+t2JTNWWrFUMkZyQP4V56sbPFy1d/DUDD6gcq0YWLU=");
		
		System.out.print("sdd:"+sdd);
		/**
		http://101.200.75.226:8080/testPay/return_url.jsp?
		is_success=T&
		notify_id=RqPnCoPT3K9%2Fvwbh3InXShsPdkahl1szZyud1wE4Ac7hi6UJwp%2BAp7kg%2F97MFR6rdj%2FV&
		notify_time=2016-05-18 19:10:14&
		notify_type=trade_status_sync&
		out_trade_no=16051800000164&
		payment_type=1&
		seller_id=2088021521071865&
		service=alipay.wap.create.direct.pay.by.user&
		subject=建客学院订单-16051800000164&
		total_fee=0.01&
		trade_no=2016051821001004490280869093&
		trade_status=TRADE_SUCCESS&
		sign=kQZ49Qp4dHTEsFNPK0ftT0dqCuPRqNHIjP6/JzPpG1It4x8LMHHSY7oHa+sNouPFyVbaPFyRcS8iEQPysU0ccusRILSJfGdXc698CY3XMaeXMotuIgWyKNwHJ58nTjBaG+t2JTNWWrFUMkZyQP4V56sbPFy1d/DUDD6gcq0YWLU=&
		sign_type=RSA

				*/
		
	}
}
