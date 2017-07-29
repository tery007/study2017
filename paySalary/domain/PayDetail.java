package com.edu.study.paySalary.domain;

import java.util.Date;
import java.util.Map;

public class PayDetail {
	private Date start;
	private Date end;
	private double grossPay;//应付
	private double netPay;//实发
	private double deductions;//扣除
	private Map<String, String> itsFields;
	public PayDetail(Date start, Date end){
		this.start = start;
		this.end = end;
	}
	public void setGrossPay(double grossPay) {
		this.grossPay = grossPay;
		
	}
	public void setDeductions(double deductions) {
		this.deductions  = deductions;		
	}
	public void setNetPay(double netPay){
		this.netPay = netPay;
	}
	public Date getPayPeriodEndDate() {
		
		return this.end;
	}
	public Date getPayPeriodStartDate() {
		
		return this.start;
	}
}
