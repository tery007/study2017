package com.tery.edu.jvm.clsMsg;

import java.util.List;

import com.tery.edu.jvm.constant.ConstantPool;
import com.tery.edu.jvm.constant.FieldRefInfo;
import com.tery.edu.jvm.constant.MethodRefnfo;
import com.tery.edu.jvm.field.Field;
import com.tery.edu.jvm.method.Method;

/**
 * @author Create by tery007
 * @date   2017年10月9日
 * class文件中字节码包含的信息
 */
public class ClassFile {

	private int minorVersion;
	private int majorVersion;
	private AccessFlag aflag;
	private ClassIndex cIndex;
	private List<Field> fields;
	private List<Method> methods;
	public void setAccessFlag(AccessFlag aflag){
		this.aflag=aflag;
	}
	public void setClassIndex(ClassIndex cIndex){
		this.cIndex=cIndex;
	}
	private ConstantPool pool;
	public void setMinorVersion(int minorVersion) {
		this.minorVersion=minorVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion=majorVersion;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public void setConstantPool(ConstantPool pool) {
		this.pool=pool;
	}
	
	public ConstantPool getConstantPool(){
		return this.pool;
	}
	public void addField(Field field) {
		this.fields.add(field);
	}
	public Field getFieldRefInfo(int index){
		return this.fields.get(index);
	}
	public void addMethod(Method m) {
		methods.add(m);
	}
	public Method getMethod(int index){
		return methods.get(index);
	}
	public Method getMainMethod(){
		return getMainMethod("main","([Ljava/lang/String;)V");
	}
	public Method getMainMethod(String mName , String desc) {
		for(Method m : this.methods){
			String name=pool.getUTF8String(m.getNameIndex());
			String descriptor=pool.getUTF8String(m.getDescriptorIndex());
			if(name.equals(mName) && descriptor.equals(desc)){
				return m;
			}
		}
		return null;
	}

}
