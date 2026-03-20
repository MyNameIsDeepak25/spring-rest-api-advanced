package com.first;

public final class ImmutableStudent {
	private final int id;
	private final String name;
	public ImmutableStudent(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	 @Override
	public String toString() {
		return "ImmutableStudent [id=" + id + ", name=" + name + "]";
	}
	public static void main(String[] args) {
		ImmutableStudent theImmutableStudent = new ImmutableStudent(1211213, "Satish");
		ImmutableStudent theImmutableStudent2=new ImmutableStudent(34, "Rajan");
		System.out.println(theImmutableStudent.getId() + " " + theImmutableStudent.getName());
		System.out.println(theImmutableStudent2);
	}
	
	

}
