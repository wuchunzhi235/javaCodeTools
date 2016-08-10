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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @description 
 * @author wuchunzhi
 * @date 2016年6月2日 下午6:13:09
 */
public class HttpPostTest {
    void testPost(String urlStr) {
        try {
            URL url = new URL(urlStr);
            URLConnection con = url.openConnection();
            con.setDoOutput(true);
            con.setRequestProperty("Pragma:", "no-cache");
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setRequestProperty("Content-Type", "text/xml");
            
            
            /**
             * 绿色百高学院
APPID：  wx6bb1f48bbbdb6093
亚亚  14:19:22
登录邮箱：ljluntan@126.com
微信号： mybaigao
原始ID： gh_8e24b4a460a1
             */
            OutputStreamWriter out = new OutputStreamWriter(con
                    .getOutputStream());    
            String xmlInfo = getXmlInfo();
            System.out.println("urlStr=" + urlStr);
            System.out.println("xmlInfo=" + xmlInfo);
            out.write(new String(xmlInfo.getBytes("ISO-8859-1")));
            out.flush();
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con
                    .getInputStream()));
            String line = "";
            for (line = br.readLine(); line != null; line = br.readLine()) {
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getXmlInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("    <appid>wx6bb1f48bbbdb6093</appid>");
        sb.append("    <body>建客订单-1203</body>");
        sb.append("    <mch_id>1310329101</mch_id>");
        sb.append("    <nonce_str>Lzt6bMVTPl5atuz3E9RYIL43YeQIP25N</nonce_str>");
        sb.append("    <notify_url>http://101.200.75.226:8083/ArchOnlineSchoolBack/index.jsp</notify_url>");
        
        sb.append("    <out_trade_no>20160602125346</out_trade_no>");
        
        sb.append("    <spbill_create_ip>101.200.75.226</spbill_create_ip>");
        sb.append("    <total_fee>1</total_fee>");
        sb.append("    <trade_type>WAP</trade_type>");
        sb.append("    <sign>B0C622B63A3CB868488A513798314AB7</sign>");
        sb.append("</xml>");
        
        
        StringBuilder sb2 = new StringBuilder();
        sb2.append("</xml>");
        sb2.append("</xml>");
        sb2.append("</xml>");
        
        
        return sb.toString();
        
        /**
         * <xml>
  <body><![CDATA[H5支付测试]]></body>
  <out_trade_no><![CDATA[100001_1433009089]]></out_trade_no>
  <total_fee>1</total_fee>
  //<notify_url><![CDATA[http://www.doucube.com/weixin/demo/notify_url.php]]></notify_url>
  <trade_type><![CDATA[WAP]]></trade_type>
  <device_info>100001</device_info>
  <appid><![CDATA[wx1d065b0628e21103]]></appid>
  <mch_id>1237905502</mch_id>
  <spbill_create_ip><![CDATA[61.129.47.79]]></spbill_create_ip>
  <nonce_str><![CDATA[gwpdlnn0zlfih21gipjj5z53i7vea8e8]]></nonce_str>
  <sign><![CDATA[C5A1E210F9B4402D8254F731882F41AC]]></sign>
</xml>
         */
    }

    public static void main(String[] args) {
        String url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        //https://api.mch.weixin.qq.com/pay/unifiedorder
        new HttpPostTest().testPost(url);
    }
}
