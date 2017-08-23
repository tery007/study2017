package com.edu.tery.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by tery007
 * @date   2017年8月23日
 *组合模式的变体
 */
public class Employee {

	private String name;
	private String dept;//部门
	private List<Employee> subordinates=new ArrayList<>();//下属
	
	public void add(Employee employee){
		this.subordinates.add(employee);
	}
	
	public List<Employee> getSubordinates(){
		return this.subordinates;
	}
	
	public String toString(){
		return ("Employee :[name:"+name+",dept:"+dept+"]");
	}
}
