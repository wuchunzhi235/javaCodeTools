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

/**
 * @description 
 * @author wuchunzhi
 * @date 2016年8月5日 上午11:17:27
 */
public class SomeTest {
	static boolean foo(char c) {
		System.out.print(c);
		return true;
	}
	public static void main( String[] argv ) {
		int i =0;
		for ( foo('A'); foo('B')&&(i<2); foo('C')){
			i++ ;
			foo('D');
		}
	}
}
