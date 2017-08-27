package com.edu.tery.command.cmd;

import com.edu.tery.command.Cook;

/**
 * @author Create by tery007
 * @date   2017Äê8ÔÂ27ÈÕ
 *
 */
public class OrderPorkCommand implements Command{

	private Cook cook;
	public OrderPorkCommand(Cook cook) {
		this.cook=cook;
	}
	@Override
	public void excute() {
		cook.cookPork();
	}

}
