package com.ara.beans;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class KeyCheckAdvice implements AfterReturningAdvice {

	public void afterReturning(Object ret, Method method, Object[] args,
			Object target) throws Throwable {

		// weak key has been generated so discard
		if ((Integer) ret <= 0) {
			throw new IllegalArgumentException("Key len no supported/weak key generated");
		}
	}

}
