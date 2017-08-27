package com.edu.tery.bridge.draw;
/**
 * @author Create by tery007
 * @date   2017年8月26日
 *
 */
public class DrawGL1 implements Draw{

	@Override
	public void drawCircle(int x, int y, int r) {
		System.out.println("画一个圆心为("+x+","+y+"),直径为："+r+"的圆形");
	}

	@Override
	public void drawTriangle(int a, int b, int c,int degree) {
		System.out.println("画一个边长分别为a:"+a+" b:"+b+" c:"+c+" a与b的夹角为:"+degree+"°的三角形");
		
	}

}
