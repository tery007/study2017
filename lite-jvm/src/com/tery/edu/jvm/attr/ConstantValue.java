package com.tery.edu.jvm.attr;
/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ15ÈÕ
 *
 */
public class ConstantValue extends AttributeInfo{

	private int  constantvalueIndex;
	public ConstantValue(int attrNameIndex, int attrLength) {
		super(attrNameIndex, attrLength);
	}
	public void  setConstantValueIndex(int constValueIndex){
		this.constantvalueIndex=constValueIndex;
	}

}
