package com.ara.beans;

public class KeyGenerator {
	public int generateKey(int len) {
		if (len < 8) {
			return 0; // weak key
		}
		return 1;
	}
}
