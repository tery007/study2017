package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	比较指令：if_icmpeq if_icmpne if_icmplt if_icmpge if_icmpgt 
 *比较栈顶两 int 型数值大小，结果与0比较，进行跳转
 */
public class ComparisionCmd extends TwoOprandCmd{

	protected ComparisionCmd(String opcode,ClassFile clzFile) {
		super(opcode, clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		// TODO Auto-generated method stub
		
	}

}
