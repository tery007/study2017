package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	有一个操作数的字节码指令抽象类
 */
public abstract class OneOprandCmd extends ByteCommand{

	private int oprand;//操作码，一至多个字节
	protected OneOprandCmd(String opcode,ClassFile clzFile) {
		super(opcode,clzFile);
		// TODO Auto-generated constructor stub
	}
	public int getOprand() {
		return oprand;
	}
	public void setOprand(int oprand) {
		this.oprand = oprand;
	}
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 2;
	}

}
