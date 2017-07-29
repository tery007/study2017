package com.edu.study.paySalary.domain;

import java.util.Date;
/**
 * 支付日期接口
 * @author tery
 *
 */
public interface PayDateUtil {
	public boolean isPayDate(Date date);
	public Date getPayPeriodStartDate( Date endDate);
}
