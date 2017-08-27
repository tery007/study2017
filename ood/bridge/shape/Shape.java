package com.edu.tery.bridge.shape;

import com.edu.tery.bridge.draw.Draw;

/**
 * @author Create by tery007
 * @date   2017年8月26日
 *bridge桥接模式，将变化的部分分成两个独立的部分A、B，A持有B
 *此案例中有一个图形库，有一个工具库，不同的图形库中的对象可以利用工具库的不同工具类来实现画图
 */
public interface Shape {

	void setDrawing(Draw draw);
	void draw();
}
