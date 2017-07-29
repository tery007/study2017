package com.edu.study.paySalary.domain;
/**
 * 支付策略接口
 * @author tery
 *
 */
public interface PayClassify {
	public double calculatePay(PayDetail detail); 
}
