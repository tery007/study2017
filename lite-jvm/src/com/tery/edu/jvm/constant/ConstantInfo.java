package com.tery.edu.jvm.constant;


/**
 * @author Create by tery007
 * @date   2017年10月9日
 *常量项抽象类
 */
public abstract class ConstantInfo {

	public static final int UTF8_INFO=1;
	public static final int FLOAT_INFO=4;
	public static final int CLASS_INFO=7;
	public static final int STRING_INFO=8;
	public static final int FIELD_INFO=9;
	public static final int METHOD_INFO=10;
	public static final int NAME_AND_TYPE_INFO=12;
	protected ConstantPool pool;
	
	public ConstantInfo(){
		
	}
	public ConstantInfo(ConstantPool pool){
		this.pool=pool;
	}
}
