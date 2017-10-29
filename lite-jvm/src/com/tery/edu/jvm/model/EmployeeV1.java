package com.tery.edu.jvm.model;
/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ9ÈÕ
 *
 */
public class EmployeeV1 {

	private String name;
	private int age;
	public EmployeeV1(String name,int age){
		this.name=name;
		this.age=age;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public void setAge(int age){
		this.age=age;
	}
	public void sayHello(){
		System.out.println("hello , this is class EmployeeV1");
	}
	public static void main(String[] args) {
		EmployeeV1 employee=new EmployeeV1("Andy", 29);
		employee.sayHello();
	}
	
}
