package com.first;

public class Employee {
	
	  private int age = 10;

	public Employee(int age) {
		
		if (age<18) {
			throw new RuntimeException("Invalid age");
		}
		this.age=age;
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	    @Override
	public String toString() {
		return "Employee [age=" + age + "]";
	}

		public static void main(String[] args) {
			Employee e = new Employee(10);
			System.out.println(e);
		}
	  
	

}
