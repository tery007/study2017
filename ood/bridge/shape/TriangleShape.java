package com.edu.tery.bridge.shape;

import com.edu.tery.bridge.draw.Draw;

/**
 * @author Create by tery007
 * @date   2017Äê8ÔÂ26ÈÕ
 *
 */
public class TriangleShape implements Shape{

	private Draw draw;
	private int a,b,c,degree;
	
	public TriangleShape(int a,int b,int c,int degree) {
		this.a=a;
		this.b=b;
		this.c=c;
		this.degree=degree;
	}
	@Override
	public void setDrawing(Draw draw) {
		this.draw=draw;
	}

	public void draw(){
		draw.drawTriangle(a, b, c, degree);
	}
}
