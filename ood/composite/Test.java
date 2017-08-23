package com.edu.tery.composite;
/**
 * @author Create by tery007
 * @date   2017年8月23日
 *组合模式试用场景：
 *1、想表达整体与部分的关系
 *2、调用方想忽略整体与部分的区别
 */
public class Test {

	public static void main(String[] args) {
		Picture p=new Picture();
		p.add(new Line());
		p.add(new Rectangle());
		
		Picture sub=new Picture();
		sub.add(new Text());
		sub.add(new Line());
		sub.add(new Rectangle());
		
		p.add(sub);
		p.draw();
	}
}
