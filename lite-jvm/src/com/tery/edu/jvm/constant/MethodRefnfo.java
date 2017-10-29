package com.tery.edu.jvm.constant;
/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ9ÈÕ
 *	CONSTANT_Methodref_info 
 */
public class MethodRefnfo extends ConstantInfo{

	private int type=ConstantInfo.METHOD_INFO;
	private int clzIndex;
	private int nameAndTypeIndex;
	public MethodRefnfo(ConstantPool pool){
		super(pool);
	}
	public int getClzIndex() {
		return clzIndex;
	}
	public void setClzIndex(int clzIndex) {
		this.clzIndex = clzIndex;
	}
	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}
	public void setNameAndTypeIndex(int nameAndTypeIndex) {
		this.nameAndTypeIndex = nameAndTypeIndex;
	}
	
	public String getClassName(){
		ClassInfo clzInfo=(ClassInfo)pool.getConstantInfo(getClzIndex());
		Utf8Info utf8Info=(Utf8Info)pool.getConstantInfo(clzInfo.getUtf8Index());
		return utf8Info.getValue();
	}
	
	public String getMethodName(){
		NameAndTypeInfo info=(NameAndTypeInfo)pool.getConstantInfo(getNameAndTypeIndex());
		return info.getFieldName();
	}
	
	public String getParameterAndReturnType(){
		NameAndTypeInfo info=(NameAndTypeInfo)pool.getConstantInfo(getNameAndTypeIndex());
		return info.getFieldType();
	}
	
}
