package com.edu.study.paySalary.service;


import java.util.List;

import com.edu.study.paySalary.classify.BasePayClassify;
import com.edu.study.paySalary.classify.HourlPayClassify;
import com.edu.study.paySalary.classify.SalesPayClassify;
import com.edu.study.paySalary.domain.Employee;
import com.edu.study.paySalary.domain.HoldMethod;
import com.edu.study.paySalary.domain.PayDetail;
import com.edu.study.paySalary.schedule.MonthEndUtil;
import com.edu.study.paySalary.schedule.OverWeekUtil;
import com.edu.study.paySalary.schedule.WeeklyUtil;


public class PayService {
	public   List<Employee> getAllEmployees(){
		return null;
	}
	public void savePaycheck(PayDetail detail){
		
	}
	
	public Employee addHourlyEmployee(String name, String address, double hourlyRate){
		Employee e = new Employee(name, address);	
		e.setClassification(new HourlPayClassify(hourlyRate));		
		e.setSchedule(new WeeklyUtil());	
		e.setPaymentMethod(new HoldMethod());
		//保存员工到数据库.. 略	
		return e;		
	}
	
	public Employee addSalariedEmployee(String name, String address, double salary){
		Employee e = new Employee(name, address);		
		e.setClassification(new BasePayClassify(salary));		
		e.setSchedule(new MonthEndUtil());	
		e.setPaymentMethod(new HoldMethod());
		//保存员工到数据库.. 略		
		return e;	
	}
	
	public Employee addCommissionedEmployee(String name, String address, double salary, double saleRate){
		Employee e = new Employee(name, address);		
		e.setClassification(new SalesPayClassify(salary, saleRate));		
		e.setSchedule(new OverWeekUtil());		
		e.setPaymentMethod(new HoldMethod());
		//保存员工到数据库.. 略		
		return e;	
	}
}
