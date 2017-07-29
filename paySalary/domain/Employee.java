package com.edu.study.paySalary.domain;

import java.util.Date;


public class Employee {
	private String id;
	private String name;
	private Integer age;
	private Integer sex;
	private PayClassify classify;//支付策略类型
	private PayDateUtil payDateUtil;//支付时间抽象类
	private PaymentMethod paymentMethod;//支付方式
	private Reduce reduce;//扣除项

	public Employee(String id, String name){
		this.id = id;
		this.name = name;
	}
	public boolean isPayDay(Date d) {
		return this.payDateUtil.isPayDate(d);
	}

	public Date getStartDate(Date d) {
		return this.payDateUtil.getPayPeriodStartDate(d);
	}

	public void payDay(PayDetail detail){
		 double grossPay = classify.calculatePay(detail);
		 double deductions = reduce.calculateDeductions(detail);
		 double netPay = grossPay - deductions;
		 detail.setGrossPay(grossPay);
		 detail.setDeductions(deductions);
		 detail.setNetPay(netPay);
		 paymentMethod.pay(detail);
	}
	
	public void setClassification(PayClassify classify) {
		this.classify = classify;
	}
	public void setSchedule(PayDateUtil payDateUtil) {
		this.payDateUtil = payDateUtil;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}

