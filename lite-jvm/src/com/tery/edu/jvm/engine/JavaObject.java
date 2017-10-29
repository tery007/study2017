package com.tery.edu.jvm.engine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Create by tery007
 * @date   2017年10月20日
 *	模拟java对象，分为4种类型
 */
public class JavaObject {

	public static final int OBJECT=1;
	public static final int STRING=2;
	public static final int INT=3;
	public static final int FLOAT=4;
	
	private int type;
	private String className;
	private String sValue;
	private int intValue;
	private float floatValue;
	private Map<String, JavaObject> fieldValue=new HashMap<>();
	public String getsValue() {
		return sValue;
	}
	public void setsValue(String sValue) {
		this.sValue = sValue;
	}
	public int getIntValue() {
		return intValue;
	}
	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}
	public float getFloatValue() {
		return floatValue;
	}
	public void setFloatValue(float floatValue) {
		this.floatValue = floatValue;
	}
	public void setClassName(String className){
		this.className=className;
	}
	public JavaObject(int type){
		this.type=type;
	}
	public JavaObject getFieldValue(String name) {
		return fieldValue.get(name);
	}
	public Map<String, JavaObject> getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String nameAndType,JavaObject fieldValue) {
		this.fieldValue.put(nameAndType, fieldValue);
	}
}
