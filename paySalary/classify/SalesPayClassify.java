package com.edu.study.paySalary.classify;

import java.util.Date;
import java.util.Map;

import com.edu.study.paySalary.domain.PayClassify;
import com.edu.study.paySalary.domain.PayDetail;
import com.edu.study.paySalary.domain.SalesReceipt;
import com.edu.study.paySalary.util.DateUtil;

/**
 * 提成支付
 * @author tery
 *
 */
public class SalesPayClassify implements PayClassify {
	double salary;
	double rate;
	public SalesPayClassify(double salary , double rate){
		this.salary = salary;
		this.rate = rate;
	}
	Map<Date, SalesReceipt> receipts;
	@Override
	public double calculatePay(PayDetail detail) {
		double commission = 0.0;
		for(SalesReceipt sr : receipts.values()){
			if(DateUtil.between(sr.getSaleDate(), detail.getPayPeriodStartDate(), 
					detail.getPayPeriodEndDate())){
				commission += sr.getAmount() * rate;
			}
		}
		return salary + commission;
	}

}
