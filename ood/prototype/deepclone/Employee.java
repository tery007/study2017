package com.edu.tery.prototype.deepclone;


/**
 * @author Create by tery007
 * @date   2017年8月21日
 *深克隆,让对象中的引用对象分别实现clone方法
 */
public class Employee implements Cloneable {
	private String name;
	private String address;
	private Company company;
	
	public Employee(String name,String address,Company company){
		this.name=name;
		this.address=address;
		this.company=company;
	}
	/**
	 * 重写clone方法
	 * @throws CloneNotSupportedException 
	 */
	public Object clone() throws CloneNotSupportedException{
		Employee e=(Employee)super.clone();
		e.company=(Company)company.clone();
		return e;
	}
	static class Company implements Cloneable{
		public Object clone() throws CloneNotSupportedException{
			return super.clone();
		}
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee e1=new Employee("li", "linkeng street", new Company());
		Employee e2=(Employee) e1.clone();
		System.out.println(e1.company);
		System.out.println(e2.company);
	}
}
