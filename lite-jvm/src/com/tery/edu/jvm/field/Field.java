package com.tery.edu.jvm.field;

import com.tery.edu.jvm.attr.AttributeInfo;
import com.tery.edu.jvm.attr.ConstantValue;
import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.constant.ConstantPool;
import com.tery.edu.jvm.util.BinaryCodeIterator;

/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ15ÈÕ
 *	Field
 */
public class Field {

	private int accessFlags;
	private int nameIndex;
	private int descriptorIndex;
	private ConstantPool pool;
	private AttributeInfo constantValue;
	public Field(int accessFlags,int nameIndex,int descIndex,ConstantPool pool){
		this.accessFlags=accessFlags;
		this.nameIndex=nameIndex;
		this.descriptorIndex=descIndex;
		this.pool=pool;
	}
	public int getAccessFlags() {
		return accessFlags;
	}
	public void setAccessFlags(int accessFlags) {
		this.accessFlags = accessFlags;
	}
	public int getNameIndex() {
		return nameIndex;
	}
	public void setNameIndex(int nameIndex) {
		this.nameIndex = nameIndex;
	}
	public int getDescriptorIndex() {
		return descriptorIndex;
	}
	public void setDescriptorIndex(int descriptorIndex) {
		this.descriptorIndex = descriptorIndex;
	}
	
	public AttributeInfo getConstantValue() {
		return constantValue;
	}
	public void setConstantValue(AttributeInfo constantValue) {
		this.constantValue = constantValue;
	}
	public static Field parseFields(BinaryCodeIterator iter, ClassFile clzFile) {
		ConstantPool pool=clzFile.getConstantPool();
		int accessFlags=iter.nextU2ToInt();
		int nameIndex=iter.nextU2ToInt();
		int descIndex=iter.nextU2ToInt();
		Field f=new Field(accessFlags, nameIndex, descIndex, pool);
		int attrCount=iter.nextU2ToInt();
		for(int i=1;i<=attrCount;i++){
			int attrNameIndex=iter.nextU2ToInt();
			String attrName=pool.getUTF8String(attrNameIndex);
			if(attrName.equals(AttributeInfo.CONSTANT_VALUE)){
				int attrLength=iter.nextU4ToInt();
				ConstantValue constantValue=new ConstantValue(attrNameIndex,attrLength);
				constantValue.setConstantValueIndex(iter.nextU2ToInt());
				f.setConstantValue(constantValue);
			}else {
				throw new RuntimeException("the field's attribute_info:"+attrName+" has not been realized!");
			}
		}
		return f;
	}
	
}
