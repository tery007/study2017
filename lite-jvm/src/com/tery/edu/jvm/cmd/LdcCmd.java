package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.constant.ConstantInfo;
import com.tery.edu.jvm.constant.ConstantPool;
import com.tery.edu.jvm.constant.StringInfo;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.Heap;
import com.tery.edu.jvm.engine.JavaObject;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	ldc index
	从运行时常量池中提取数据压入栈中
 */
public class LdcCmd extends OneOprandCmd{

	protected LdcCmd(String opcode, ClassFile clzFile) {
		super(opcode, clzFile);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void excute(StackFrame stackFrame, ExcutorResult result) {
		ConstantPool pool = getConstantPool();
		ConstantInfo info=pool.getConstantInfo(this.getOprand());
		if(info instanceof StringInfo){
			String value=((StringInfo) info).getStringValue();
			JavaObject obj=Heap.getInstance().newString(value);
			stackFrame.getOprandStack().push(obj);
		}else{
			throw new RuntimeException("info's other type hasn't been realized:"+info);
		}
	}

}
