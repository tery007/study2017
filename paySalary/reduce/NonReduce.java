package com.edu.study.paySalary.reduce;

import com.edu.study.paySalary.domain.PayDetail;

/**
 * 空对象
 * @author tery
 *
 */
public class NonReduce implements Reduce{
	@Override
	public double calculateDeductions(PayDetail detail) {
		
		return 0;
	}
}
