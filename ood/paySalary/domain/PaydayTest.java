package com.edu.study.paySalary.domain;

import java.util.Date;
import java.util.List;

import com.edu.study.paySalary.service.PayService;



public class PaydayTest {
	private Date date;
	private PayService payService;
	
	public void execute(){
		List<Employee> employees = payService.getAllEmployees();
		for(Employee e : employees){
			if(e.isPayDay(date)){
				PayDetail detail = new PayDetail(e.getStartDate(date),date);
				e.payDay(detail);
				payService.savePaycheck(detail);
			}
		}
	}
}

