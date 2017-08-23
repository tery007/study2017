package com.edu.tery.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by tery007
 * @date   2017Äê8ÔÂ23ÈÕ
 *
 */
public class Picture implements Shape{

	List<Shape> shapes=new ArrayList<>();
	@Override
	public void draw() {		for(Shape shape: shapes){
			shape.draw();
		}
	}
	
	public void add(Shape shape){
		this.shapes.add(shape);
	}

}
