package com.edu.tery.command.cmd;

import com.edu.tery.command.Cook;

/**
 * @author Create by tery007
 * @date   2017年8月27日
 *	牛排订单命令
 */
public class OrderSteakCommand implements Command{

	private Cook cook;
	public OrderSteakCommand(Cook cook){
		this.cook=cook;
	}
	@Override
	public void excute() {
		cook.cookSteak();
	}
	

}
