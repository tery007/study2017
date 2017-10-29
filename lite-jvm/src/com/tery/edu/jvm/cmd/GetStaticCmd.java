package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.constant.FieldRefInfo;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.Heap;
import com.tery.edu.jvm.engine.JavaObject;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *getstatic indexbyte1 indexbyte2 
 *获取指定类的静态域，并将其值压入栈顶。 
 */
public class GetStaticCmd extends TwoOprandCmd{

	protected GetStaticCmd(String opcode, ClassFile clzFile) {
		super(opcode, clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		FieldRefInfo info=(FieldRefInfo)getConstantPool().getConstantInfo(getConstantpoolIndex());
		String fieldName=info.getFieldName();
		String className=info.getClzName();
		String type=info.getFieldType();
		if("Ljava/lang/System".equals(className)&&"out".equals(fieldName)&&"Ljava/io/PrintStream".equals(type)){
			JavaObject obj=Heap.getInstance().newObject(className);
			stackFrame.getOprandStack().push(obj);
		}else{
			//非System.out的情况处理：
		}
	}

}
