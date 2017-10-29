package com.tery.edu.jvm.attr;
/**
 * @author Create by tery007
 * @date   2017年10月15日
 *	Field和Method的属性抽象类
 */
public class AttributeInfo {

	public static final String CONSTANT_VALUE="ConstantValue";
	public static final String CODE="Code";
	public static final String STACKMAPTABLE="StackMapTable";
	public static final String EXCEPTIONS="Exceptions";
	public static final String LINENUMBERTABLE="LineNumberTable";
	public static final String LOCALVARIABLETABLE="LocalVariableTable";
	
	private int attrNameIndex;
	private int attrLength;
	public AttributeInfo(int attrNameIndex,int attrLength){
		this.attrLength=attrNameIndex;
		this.attrNameIndex=attrNameIndex;
	}
	
}
