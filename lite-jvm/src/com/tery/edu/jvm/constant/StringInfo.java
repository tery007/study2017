package com.tery.edu.jvm.constant;
/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ9ÈÕ
 *
 */
public class StringInfo extends ConstantInfo{

	private int type=ConstantInfo.STRING_INFO;
	private int stringIndex;
	public int getStringIndex(){
		return this.stringIndex;
	}
	public void setStringIndex(int stringIndex){
		this.stringIndex=stringIndex;
	}
	
	public StringInfo(ConstantPool pool){
		super(pool);
	}
	public String getStringValue(){
		int sindex=getStringIndex();
		Utf8Info info=(Utf8Info)pool.getConstantInfo(sindex);
		return info.getValue();
	}
}
