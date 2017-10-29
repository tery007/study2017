package com.tery.edu.jvm.attr;

import java.util.List;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.cmd.ByteCommand;
import com.tery.edu.jvm.cmd.CommandParser;
import com.tery.edu.jvm.util.BinaryCodeIterator;

/**
 * @author Create by tery007
 * @date   2017年10月16日
 *	方法的CODE属性
 */
public class CodeAttr extends AttributeInfo{

	private int maxStack;
	private int maxLocals;
	private int codeLength;
	private String code;
	private List<AttributeInfo> codeAttrs;
	private ByteCommand[] cmds;
	public CodeAttr(int attrNameIndex, int attrLength,int maxStack,int maxLocals,int codeLength,String code,ByteCommand[] cmds) {
		super(attrNameIndex, attrLength);
		this.maxStack=maxStack;
		this.maxLocals=maxLocals;
		this.codeLength=codeLength;
		this.code=code;
		this.cmds=cmds;
	}

	public ByteCommand[] getCmds(){
		return this.cmds;
	}
	public void addCodeAttrs(AttributeInfo attr) {
		this.codeAttrs.add(attr);
	}

	public int getMaxStack() {
		return maxStack;
	}
	public void setMaxStack(int maxStack) {
		this.maxStack = maxStack;
	}
	public int getMaxLocals() {
		return maxLocals;
	}
	public void setMaxLocals(int maxLocals) {
		this.maxLocals = maxLocals;
	}
	public static CodeAttr parseCode(BinaryCodeIterator iter, ClassFile clzFile) {
		int attrNameIndex=iter.nextU2ToInt();
		int attrLength=iter.nextU4ToInt();
		int maxStacks=iter.nextU2ToInt();
		int maxLocals=iter.nextU2ToInt();
		int codeLength=iter.nextU4ToInt();
		
		String code=iter.nextUxToHexString(codeLength);
		//解析字节码指令集
		ByteCommand[] cmds=CommandParser.parse(clzFile,code);
		
		int exceptionTableLength=iter.nextU2ToInt();
		System.out.println("exception count:"+exceptionTableLength);
		
		CodeAttr codeAttr=new CodeAttr(attrNameIndex, attrLength,maxStacks,maxLocals,codeLength,code,cmds);
		
		int subAttrCounts=iter.nextU2ToInt();
		
		for(int i=1;i<=subAttrCounts;i++){
			int subAttrNameIndex=iter.nextU2ToInt();
			iter.back(2);
			String attributeName=clzFile.getConstantPool().getUTF8String(subAttrNameIndex);
			if(AttributeInfo.LINENUMBERTABLE.equalsIgnoreCase(attributeName)){
				LineNumberTable lineNumTable=LineNumberTable.parse(iter);
				codeAttr.addCodeAttrs(lineNumTable);
			}else if(AttributeInfo.LOCALVARIABLETABLE.equalsIgnoreCase(attributeName)){
				LocalVariableTable localVariTable=LocalVariableTable.parse(iter);
				codeAttr.addCodeAttrs(localVariTable);
			}else if(AttributeInfo.LOCALVARIABLETABLE.equalsIgnoreCase(attributeName)){
				StackMapTable stackMapTable=StackMapTable.parse(iter);
				codeAttr.addCodeAttrs(stackMapTable);
			}else{
				throw new RuntimeException("the Code's attribute:"+subAttrNameIndex+" has not been realized");
			}
		}
		return null;
	}
	
}
