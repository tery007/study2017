package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	iinc index const 
 *index 是一个代表当前栈帧中局部变量表的索引的无符号 byte 类
型整数，const 是一个有符号的 byte 类型数值.由 index 定位到的局部变
量必须是 int 类型，const 首先带符号扩展成一个 int 类型数值，然后加到
由 index 定位到的局部变量中
 */
public class IncrementCmd extends TwoOprandCmd{

	protected IncrementCmd(String opcode, ClassFile clzFile) {
		super(opcode, clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		// TODO Auto-generated method stub
		
	}

}
