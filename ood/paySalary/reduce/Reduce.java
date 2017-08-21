package com.edu.study.paySalary.reduce;

import com.edu.study.paySalary.domain.PayDetail;

public interface Reduce {

	public double calculateDeductions(PayDetail detail);
}
