package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	Invokevirtual indexbyte1 indexbyte2
	调用实例方法，依据实例的类型进行分派 (多态！！)
 */
public class InvokeVirtualCmd extends TwoOprandCmd{

	protected InvokeVirtualCmd(String opcode, ClassFile clzFile) {
		super(opcode, clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		// TODO Auto-generated method stub
		
	}

}
