package com.ara.test;

import org.springframework.aop.framework.ProxyFactory;

import com.ara.beans.KeyCheckAdvice;
import com.ara.beans.KeyGenerator;

public class ARATest {

	public static void main(String[] args) {
		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(new KeyGenerator());
		pf.addAdvice(new KeyCheckAdvice());
		
		KeyGenerator proxy = (KeyGenerator) pf.getProxy();
		int key = proxy.generateKey(10);
		System.out.println("Key : "+key);
		
		key = proxy.generateKey(7);
		System.out.println("Key : "+key);
	}
}
