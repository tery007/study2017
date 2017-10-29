package com.tery.edu.jvm.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by tery007
 * @date   2017年10月9日
 *	常量池
 */
public class ConstantPool {

	List<ConstantInfo> infos=new ArrayList<>();//与常量项构成组合模式
	public void addConstantInfo(ConstantInfo info){
		infos.add(info);
	}
	public ConstantInfo getConstantInfo(int index) {
		return infos.get(index);
	}
	public String getUTF8String(int attrNameIndex) {
		Utf8Info info=(Utf8Info)getConstantInfo(attrNameIndex);
		return info.getValue();
	}

}
