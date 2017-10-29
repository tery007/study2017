package com.tery.edu.jvm.constant;
/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ9ÈÕ
 *CONSTANT_NameAndType_info 
 */
public class NameAndTypeInfo extends ConstantInfo{

	private int type=ConstantInfo.NAME_AND_TYPE_INFO;
	private int nameIndex;
	private int descIndex;
	public NameAndTypeInfo(ConstantPool pool){
		super(pool);
	}
	public int getNameIndex() {
		return nameIndex;
	}
	public void setNameIndex(int nameIndex) {
		this.nameIndex = nameIndex;
	}
	public int getDescIndex() {
		return descIndex;
	}
	public void setDescIndex(int descIndex) {
		this.descIndex = descIndex;
	}
	public String getFieldName(){
		Utf8Info info=(Utf8Info)pool.getConstantInfo(getNameIndex());
		return info.getValue();
	}
	public String getFieldType(){
		Utf8Info info=(Utf8Info)pool.getConstantInfo(getDescIndex());
		return info.getValue();
	}
}
