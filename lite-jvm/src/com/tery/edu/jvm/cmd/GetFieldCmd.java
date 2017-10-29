package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.constant.ClassInfo;
import com.tery.edu.jvm.constant.FieldRefInfo;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.JavaObject;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 * getfield indexbyte1 indexbyte2 
 *获取对象的字段值:无符号数 indexbyte1 和 indexbyte2 用于构建一个
	当前类的运行时常量池的索引值，构建方式为（indexbyte1 << 8）
| indexbyte2，该索引所指向的运行时常量池项应当是一个字段 
 */
public class GetFieldCmd extends TwoOprandCmd{

	protected GetFieldCmd(String opcode, ClassFile clzFile) {
		super(opcode, clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		FieldRefInfo info=(FieldRefInfo)getConstantPool().getConstantInfo(this.getConstantpoolIndex());
		String name=info.getFieldName();
		JavaObject obj=stackFrame.getOprandStack().pop();
		JavaObject fieldValue=obj.getFieldValue(name);
		stackFrame.getOprandStack().push(fieldValue);
		
	}

}
