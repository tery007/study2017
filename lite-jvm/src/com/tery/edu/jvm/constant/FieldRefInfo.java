package com.tery.edu.jvm.constant;
/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ9ÈÕ
 *	CONSTANT_Fieldref_info 
 */
public class FieldRefInfo extends ConstantInfo{

	private int type=ConstantInfo.FIELD_INFO;
	private int classIndex;
	private int nameAndTypeIndex;
	public FieldRefInfo(ConstantPool pool){
		super(pool);
	}
	public int getClassIndex() {
		return classIndex;
	}
	public void setClassIndex(int classIndex) {
		this.classIndex = classIndex;
	}
	public int getNameAndTypeIndex() {
		return nameAndTypeIndex;
	}
	public void setNameAndTypeIndex(int nameAndTypeIndex) {
		this.nameAndTypeIndex = nameAndTypeIndex;
	}
	public String getClzName(){
		ClassInfo clzInfo=(ClassInfo)pool.getConstantInfo(classIndex);
		Utf8Info utf8Info=(Utf8Info)pool.getConstantInfo(clzInfo.getUtf8Index());
		return utf8Info.getValue();
	}
	public String getFieldName(){
		NameAndTypeInfo info=(NameAndTypeInfo)pool.getConstantInfo(getNameAndTypeIndex());
		return info.getFieldName();
	}
	
	public String getFieldType(){
		NameAndTypeInfo info=(NameAndTypeInfo)pool.getConstantInfo(getNameAndTypeIndex());
		return info.getFieldType();
	}
}
