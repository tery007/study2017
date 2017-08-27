package com.edu.tery.chainOfResposibility;
/**
 * @author Create by tery007
 * @date   2017年8月27日
 *
 */
public class Test {

	public static void main(String[] args) {
		Logger logger=new StandardLogger(Logger.DEBUG).setNext(new EmailLogger(Logger.NOTICE).setNext(new FileLogger(Logger.ERR)));
		logger.message("进入计算", Logger.DEBUG);
		logger.message("发送邮件", Logger.NOTICE);
	}
}
