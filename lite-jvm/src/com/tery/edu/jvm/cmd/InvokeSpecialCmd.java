package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	invokespecial  indexbyte1 indexbyte2 
	对一个对象进行初始化， 父类的初始化， 调用私有方法
 *
 */
public class InvokeSpecialCmd extends TwoOprandCmd{

	protected InvokeSpecialCmd(String opcode, ClassFile clzFile) {
		super(opcode, clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		
	}

}
