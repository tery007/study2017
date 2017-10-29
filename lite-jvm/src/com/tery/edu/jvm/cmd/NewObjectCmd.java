package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.constant.ConstantPool;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.Heap;
import com.tery.edu.jvm.engine.JavaObject;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	new指令：new  indexbyte1, indexbyte2
 */
public class NewObjectCmd extends TwoOprandCmd{

	protected NewObjectCmd(String opcode,ClassFile clzFile) {
		super(opcode,clzFile);
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		int index=getConstantpoolIndex();
		ConstantPool pool = getConstantPool();
		String className=pool.getUTF8String(index);
		JavaObject obj=Heap.getInstance().newObject(className);
		obj.setClassName(className);
		stackFrame.getOprandStack().push(obj);
	}

}
