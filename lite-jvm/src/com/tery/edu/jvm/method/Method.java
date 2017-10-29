package com.tery.edu.jvm.method;

import java.util.ArrayList;
import java.util.List;

import com.tery.edu.jvm.attr.AttributeInfo;
import com.tery.edu.jvm.attr.CodeAttr;
import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.cmd.ByteCommand;
import com.tery.edu.jvm.constant.ConstantPool;
import com.tery.edu.jvm.constant.Utf8Info;
import com.tery.edu.jvm.engine.JavaObject;
import com.tery.edu.jvm.util.BinaryCodeIterator;

/**
 * @author Create by tery007
 * @date   2017年10月15日
 *	Method
 */
public class Method {

	private int accessFlags;
	private int nameIndex;
	private int descriptorIndex;
	private CodeAttr codeAttr;
	private ClassFile clzFile;
	public Method(int accessFlags,int nameIndex,int descriptorIndex,ClassFile clzFile){
		this.accessFlags=accessFlags;
		this.nameIndex=nameIndex;
		this.descriptorIndex=descriptorIndex;
		this.clzFile=clzFile;
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
	public CodeAttr getCodeAttr() {
		return this.codeAttr;
	}
	public void setCodeAttr(CodeAttr codeAttr) {
		this.codeAttr = codeAttr;
	}
	public static Method parseMethod(BinaryCodeIterator iter, ClassFile clzFile) {
		ConstantPool pool=clzFile.getConstantPool();
		int accessFlags=iter.nextU2ToInt();
		int nameIndex=iter.nextU2ToInt();//方法名
		int descriptorIndex=iter.nextU2ToInt();
		int attributesCount=iter.nextU2ToInt();
		
		Method m=new Method(accessFlags, nameIndex,descriptorIndex,clzFile);
		for(int i=1;i<=attributesCount;i++){
			int attrNameIndex=iter.nextU2ToInt();//属性名
			String attrName=pool.getUTF8String(attrNameIndex);
			iter.back(2);
			if(AttributeInfo.CODE.equalsIgnoreCase(attrName)){
				CodeAttr codeAttr=CodeAttr.parseCode(iter,clzFile);
				m.setCodeAttr(codeAttr);
			}else{
				throw new RuntimeException("the method's attribute:"+attrName+" has not been realized");
			}
		}
		return m;
	}
	public List<String> getParameterList() {
		// e.g. (Ljava/util/List;Ljava/lang/String;II)V
		String paramsAndReturnType = getParamAndReturnType();
		int first = paramsAndReturnType.indexOf("(");
		int last = paramsAndReturnType.lastIndexOf(")");
		String params = paramsAndReturnType.substring(first+1, last);
		List<String> paramList = new ArrayList<>();
		if("".equals(params) || null ==params){
			return paramList;
		}
		while(params.length()>0){
			int pos = 0;
			if("L".equals(params.charAt(pos))){
				int endIndex = params.charAt(';');
				if(-1 == endIndex){
					throw new RuntimeException("can't find ; for object type");
				}
				paramList.add(params.substring(pos+1, endIndex));
				pos = endIndex + 1;
			}else if("I".equals(params.charAt(pos))){
				paramList.add(params.substring(pos,1));
				pos++;
			}else if("F".equals(params.charAt(pos))){
				paramList.add(params.substring(pos,1));
				pos++;
			}else{
				throw new RuntimeException("the param has unsupported type:" + params);
			}
			params = params.substring(pos);
		}
		return paramList;
	}
	public String getParamAndReturnType() {
		return this.clzFile.getConstantPool().getUTF8String(getDescriptorIndex());
	}
	
	public ByteCommand[] getCmds() {
		return this.getCodeAttr().getCmds();
	}
	
}
