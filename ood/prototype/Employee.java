package com.edu.tery.prototype;
/**
 * @author Create by tery007
 * @date   2017年8月21日
 *
 *浅克隆，实现cloneable接口
 *下面的代码展示的浅拷贝，
 *1、e1与e2指向不同的对象
 *2、对象中的company对象指向的是同一个company对象
 */
public class Employee implements Cloneable{

	private String name;
	private String address;
	private Company company;
	
	public Employee(String name,String address,Company company){
		this.name=name;
		this.address=address;
		this.company=company;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1=new Employee("li", "linkeng street", new Company());
		Employee e2=(Employee) e1.clone();
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e1.getCompany()==e2.getCompany());//true
		System.out.println(e1.getAddress()==e2.getAddress());//true
	}
}
