package com.tery.edu.jvm.constant;
/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ9ÈÕ
 *
 */
public class Utf8Info extends ConstantInfo{

	private int tag=ConstantInfo.UTF8_INFO;
	private int length;
	private String value;
	
	public Utf8Info(ConstantPool pool){
		super(pool);
	}
	
	
	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getTag() {
		return tag;
	}


	public void setValue(String value){
		this.value=value;
	}
	public String getValue() {
		return value;
	}

}
