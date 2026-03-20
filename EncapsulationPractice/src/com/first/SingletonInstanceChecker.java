package com.first;

public class SingletonInstanceChecker {
	
	private static SingletonInstanceChecker theSingletonInstanceChecker;

	
	
	public static SingletonInstanceChecker getTheSingletonInstanceChecker() {
		
		if (theSingletonInstanceChecker == null) {
			return new SingletonInstanceChecker();
		}
		return theSingletonInstanceChecker;
	
	}
	
	public static void main(String[] args) {
	SingletonInstanceChecker s1 =	SingletonInstanceChecker.getTheSingletonInstanceChecker();
	SingletonInstanceChecker s2 =	SingletonInstanceChecker.getTheSingletonInstanceChecker();
		System.out.println(s1 == s2);
		
	}
	
	     
	

}
