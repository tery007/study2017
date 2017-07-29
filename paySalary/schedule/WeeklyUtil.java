package com.edu.study.paySalary.schedule;

import java.util.Date;

import com.edu.study.paySalary.domain.PayDateUtil;
import com.edu.study.paySalary.util.DateUtil;



public class WeeklyUtil implements PayDateUtil {

	@Override
	public boolean isPayDate(Date date) {		
		return DateUtil.isFriday(date);
	}
	@Override
	public Date getPayPeriodStartDate(Date payPeriodEndDate) {		
		return DateUtil.add(payPeriodEndDate, -6);
	}

}
