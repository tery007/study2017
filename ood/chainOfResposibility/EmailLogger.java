package com.edu.tery.chainOfResposibility;
/**
 * @author Create by tery007
 * @date   2017Äê8ÔÂ27ÈÕ
 *
 */
public class EmailLogger extends Logger{

	public EmailLogger(String type){
		this.type=type;
	}
	@Override
	public void message(String msg, String type) {
		if(this.type.equals(type)){
			System.out.println(msg);
			return;
		}
		if(nextLogger!=null){
			nextLogger.message(msg, type);
		}
	}
	


}
