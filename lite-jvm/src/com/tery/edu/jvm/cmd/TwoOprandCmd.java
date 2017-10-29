package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	两个操作数的字节码指令抽象类
 */
public abstract class TwoOprandCmd extends ByteCommand{

	private int oprand1;
	private int oprand2;
	protected TwoOprandCmd(String opcode,ClassFile clzFile) {
		super(opcode, clzFile);
		// TODO Auto-generated constructor stub
	}
	public int getOprand1() {
		return oprand1;
	}
	public void setOprand1(int oprand1) {
		this.oprand1 = oprand1;
	}
	public int getOprand2() {
		return oprand2;
	}
	public void setOprand2(int oprand2) {
		this.oprand2 = oprand2;
	}
	@Override
	public int getLength() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	public int getConstantpoolIndex(){
		int indexByte1=this.oprand1;
		int indexByte2=this.oprand2;
		int index=indexByte1<<8 | indexByte2;
		return index;
	}
}
