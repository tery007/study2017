package com.edu.tery.bridge;

import com.edu.tery.bridge.draw.Draw;
import com.edu.tery.bridge.draw.DrawGL1;
import com.edu.tery.bridge.draw.DrawGL2;
import com.edu.tery.bridge.shape.CircleShape;
import com.edu.tery.bridge.shape.Shape;
import com.edu.tery.bridge.shape.TriangleShape;

/**
 * @author Create by tery007
 * @date   2017Äê8ÔÂ26ÈÕ
 *
 */
public class Test {

	public static void main(String[] args) {
		Shape triangle=new TriangleShape(1, 2, 3, 50);
		Shape circle=new CircleShape(10, 20, 100);
		Draw lib1=new DrawGL1();
		Draw lib2=new DrawGL2();
		triangle.setDrawing(lib1);
		triangle.draw();
		triangle.setDrawing(lib2);
		triangle.draw();
		
		circle.setDrawing(lib1);
		circle.draw();
		circle.setDrawing(lib2);
		circle.draw();
	}
}
