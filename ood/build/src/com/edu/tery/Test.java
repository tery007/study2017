package com.edu.tery;

import com.edu.tery.User.Builder;

/**
 * @author Create by tery007
 * @date   2017年8月20日
 *
 */
public class Test {

	public static void main(String[] args) {
		User user=new User.Builder("", "").build();//构建了一个只有name和idCardNum的User
		Builder builder=new Builder("", "");//静态内部类可以不用绑定User就可以new出来
		builder.address("");
		
	}
}
