package com.edu.tery.chainOfResposibility;
/**
 * @author Create by tery007
 * @date   2017年8月27日
 *责任链模式：
 *应用场景：当一个请求不知道由谁处理的时候
 */
public abstract class Logger {

	Logger nextLogger;
	public String type;
	
	public static final String DEBUG="debug";
	public static final String NOTICE="notice";
	public static final String ERR="error";
	public Logger setNext(Logger logger) {
		this.nextLogger=logger;
		return this;
	}

	public abstract void message(String msg, String type);
	

}
