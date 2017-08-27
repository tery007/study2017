package com.edu.tery.observer;
/**
 * @author Create by tery007
 * @date   2017年8月25日
 *观察者模式：
 *1、实现数据层与表现层的分离
 *2、通过抽象的方式实现低耦合
 *3、支持广播通信
 *4、实现了开闭原则
 */
public interface Obsever {

	public void update(Object obj,Object data);
}
