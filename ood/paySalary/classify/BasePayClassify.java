package com.edu.study.paySalary.classify;

import com.edu.study.paySalary.domain.PayClassify;
import com.edu.study.paySalary.domain.PayDetail;

/**
 * 固薪支付
 * @author tery
 *
 */
public class BasePayClassify implements PayClassify {
	private double salary;
	public BasePayClassify(double salary){
		this.salary = salary;
	}
	@Override
	public double calculatePay(PayDetail pc) {		
		return salary;
	}

}
