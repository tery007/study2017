package com.edu.study.paySalary.reduce;

import java.util.Date;
/**
 * 会员费用
 * @author tery
 *
 */
public class ServiceCharge {

	private Date date;
	private double amount;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
