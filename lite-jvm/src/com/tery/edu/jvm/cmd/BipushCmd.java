package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.Heap;
import com.tery.edu.jvm.engine.JavaObject;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *Bipush byte 
将 byte 带符号扩展为一个 int 类型的值 value，然后将 value 压入到操作数栈中。
 */
public class BipushCmd extends OneOprandCmd{

	protected BipushCmd(String opcode,ClassFile clzFile) {
		super(opcode,clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		int value=this.getOprand();
		JavaObject obj = Heap.getInstance().newInt(value);
		stackFrame.getOprandStack().push(obj);
	}

	
}
