package com.hisuntech.ArchOnlineSchoolAuth.test;

import java.io.UnsupportedEncodingException;

import javax.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport {
	
	public static void  main(String[] args) throws UnsupportedEncodingException{
		String ss = "http://101.200.75.226:8080/testPay/return_url.jsp?is_success=T&notify_id=RqPnCoPT3K9%252Fvwbh3InXShsPdkahl1szZyud1wE4Ac7hi6UJwp%252BAp7kg%252F97MFR6rdj%252FV&notify_time=2016-05-18+19%3A10%3A14&notify_type=trade_status_sync&out_trade_no=16051800000164&payment_type=1&seller_id=2088021521071865&service=alipay.wap.create.direct.pay.by.user&subject=%E5%BB%BA%E5%AE%A2%E5%AD%A6%E9%99%A2%E8%AE%A2%E5%8D%95-16051800000164&total_fee=0.01&trade_no=2016051821001004490280869093&trade_status=TRADE_SUCCESS&sign=kQZ49Qp4dHTEsFNPK0ftT0dqCuPRqNHIjP6%2FJzPpG1It4x8LMHHSY7oHa%2BsNouPFyVbaPFyRcS8iEQPysU0ccusRILSJfGdXc698CY3XMaeXMotuIgWyKNwHJ58nTjBaG%2Bt2JTNWWrFUMkZyQP4V56sbPFy1d%2FDUDD6gcq0YWLU%3D&sign_type=RSA";
		String ss2 = java.net.URLDecoder.decode(ss,   "utf-8");
		System.out.println(ss2);
	}
}
