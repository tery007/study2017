package com.tery.edu.jvm.cmd;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.constant.ConstantPool;
import com.tery.edu.jvm.engine.ExcutorResult;
import com.tery.edu.jvm.engine.StackFrame;

/**
 * @author Create by tery007
 * @date 2017年10月18日 字节码指令抽象类
 */
public abstract class ByteCommand {

	public String opcode;// 操作数，占一个字节
	public int offset;// 字节码指令偏移量
	private ClassFile clzFile;

	protected ByteCommand(String opcode, ClassFile clzFile) {
		this.opcode = opcode;
		this.clzFile = clzFile;
	}

	public String getOpcode() {
		return opcode;
	}

	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public ClassFile getClzFile() {
		return clzFile;
	}

	public void setClzFile(ClassFile clzFile) {
		this.clzFile = clzFile;
	}

	public abstract int getLength();
	public ConstantPool getConstantPool(){
		return getClzFile().getConstantPool();
	}
	public static final String aconst_null = "01";
	public static final String new_object = "BB";
	public static final String lstore = "37";
	public static final String invokespecial = "B7";
	public static final String invokevirtual = "B6";
	public static final String getfield = "B4";
	public static final String putfield = "B5";
	public static final String getstatic = "B2";
	public static final String ldc = "12";
	public static final String dup = "59";
	public static final String bipush = "10";
	public static final String aload_0 = "2A";
	public static final String aload_1 = "2B";
	public static final String aload_2 = "2C";
	public static final String iload = "15";
	public static final String iload_1 = "1B";
	public static final String iload_2 = "1C";
	public static final String iload_3 = "1D";
	public static final String fload_3 = "25";

	public static final String voidreturn = "B1";
	public static final String ireturn = "AC";
	public static final String freturn = "AE";

	public static final String astore_1 = "4C";
	public static final String if_icmp_ge = "A2";
	public static final String if_icmple = "A4";
	public static final String goto_no_condition = "A7";
	public static final String iconst_0 = "03";
	public static final String iconst_1 = "04";
	public static final String istore_1 = "3C";
	public static final String istore_2 = "3D";
	public static final String iadd = "60";
	public static final String iinc = "84";

	public abstract void excute(StackFrame stackFrame, ExcutorResult result);

}
