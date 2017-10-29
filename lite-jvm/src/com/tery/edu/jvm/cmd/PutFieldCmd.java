package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.constant.FieldRefInfo;
import com.tery.edu.jvm.constant.NameAndTypeInfo;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.JavaObject;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *putfield indexbyte1 indexbyte2 
 *设置对象字段 :
 *无符号数 indexbyte1 和 indexbyte2 用于构建一个当前类的运
行时常量池的索引值，构建方式为（indexbyte1 << 8）| indexbyte2，
该索引所指向的运行时常量池项应当是一个字段的符号引用，它包
含了字段的名称和描述符，以及包含该字段的类的符号引用。
 */
public class PutFieldCmd extends TwoOprandCmd{

	protected PutFieldCmd(String opcode,ClassFile clzFile) {
		super(opcode,clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		FieldRefInfo info=(FieldRefInfo)getConstantPool().getConstantInfo(getConstantpoolIndex());
		String fieldName=info.getFieldName();
		JavaObject fieldValue=stackFrame.getOprandStack().pop();
		JavaObject ref=stackFrame.getOprandStack().pop();
		ref.setFieldValue(fieldName,fieldValue);
	}

}
