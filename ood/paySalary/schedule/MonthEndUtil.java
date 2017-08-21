package com.edu.study.paySalary.schedule;

import java.util.Date;

import com.edu.study.paySalary.domain.PayDateUtil;
import com.edu.study.paySalary.util.DateUtil;



public class MonthEndUtil implements PayDateUtil {

	@Override
	public boolean isPayDate(Date date) {		
		return DateUtil.isLastDayOfMonth(date);
	}

	@Override
	public Date getPayPeriodStartDate(Date payPeriodEndDate) {		
		return DateUtil.getFirstDay(payPeriodEndDate);
	}

}
