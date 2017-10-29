package com.tery.edu.jvm.clsMsg;

import com.tery.edu.jvm.constant.ClassInfo;
import com.tery.edu.jvm.constant.ConstantPool;

/**
 * @author Create by tery007
 * @date   2017年10月9日
 *	类的引用，指向常量池的有效索引
 */
public class ClassIndex {

	private int thisClassIndex;
	private int superClassIndex;
	private ConstantPool pool;
	public void setConstantPool(ConstantPool pool){
		this.pool=pool;
	}
	public ClassIndex(int thisClassIndex,int superClassIndex){
		this.thisClassIndex=thisClassIndex;
		this.superClassIndex=superClassIndex;
	}
	public int getThisClassIndex() {
		return thisClassIndex;
	}
	public void setThisClassIndex(int thisClassIndex) {
		this.thisClassIndex = thisClassIndex;
	}
	public int getSuperClassIndex() {
		return superClassIndex;
	}
	public void setSuperClassIndex(int superClassIndex) {
		this.superClassIndex = superClassIndex;
	}
	public ClassInfo getClassInfo(){
		return (ClassInfo)this.pool.getConstantInfo(thisClassIndex);
	}
}
