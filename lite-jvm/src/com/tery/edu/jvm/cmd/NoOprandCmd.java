package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	没有操作数的字节码指令抽象类
 */
public class NoOprandCmd extends ByteCommand{

	
	protected NoOprandCmd(String opcode, ClassFile clzFile) {
		super(opcode, clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getLength() {
		return 1;
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		// TODO Auto-generated method stub
		
	}

}
