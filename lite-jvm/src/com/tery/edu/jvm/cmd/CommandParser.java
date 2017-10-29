package com.tery.edu.jvm.cmd;

import java.util.ArrayList;
import java.util.List;

import com.tery.edu.jvm.clsMsg.ClassFile;

/**
 * @author Create by tery007
 * @date   2017年10月18日
 *	解析方法中的字节码指令集
 */
public class CommandParser {

	public static ByteCommand[] parse(ClassFile clzFile, String code) {
		if(code.length()==0 || code==null || (code.length()%2)!=0){
			throw new RuntimeException("the code is null");
		}
		code=code.toUpperCase();
		CommandIterator iter=new CommandIterator(code);
		List<ByteCommand> cmds=new ArrayList<>();
		while(iter.hasNext()){
			String opcode=iter.next2CharToString();
			if(ByteCommand.new_object.equals(opcode)){
				NewObjectCmd cmd=new NewObjectCmd(opcode,clzFile);
				cmd.setOprand1(iter.next2CharToInt());
				cmd.setOprand2(iter.next2CharToInt());
				cmds.add(cmd);
			}else if(ByteCommand.bipush.equals(opcode)){
				BipushCmd cmd=new BipushCmd(opcode,clzFile);
				cmd.setOprand(iter.next2CharToInt());
				cmds.add(cmd);
			}else if(ByteCommand.getfield.equals(opcode)){
				GetFieldCmd cmd = new GetFieldCmd(opcode,clzFile);
				cmd.setOprand1(iter.next2CharToInt());
				cmd.setOprand2(iter.next2CharToInt());
				cmds.add(cmd);
			}else if(ByteCommand.getstatic.equals(opcode)){
				GetStaticCmd cmd=new GetStaticCmd(opcode,clzFile);
				cmd.setOprand1(iter.next2CharToInt());
				cmd.setOprand2(iter.next2CharToInt());
				cmds.add(cmd);
			}else if(ByteCommand.iinc.equals(opcode)){
				IncrementCmd cmd =new IncrementCmd(opcode,clzFile);
				cmd.setOprand1(iter.next2CharToInt());
				cmd.setOprand2(iter.next2CharToInt());
				cmds.add(cmd);
			}else if(ByteCommand.invokespecial.equals(opcode)){
				InvokeSpecialCmd cmd=new InvokeSpecialCmd(opcode,clzFile);
				cmd.setOprand1(iter.next2CharToInt());
				cmd.setOprand2(iter.next2CharToInt());
				cmds.add(cmd);
			}else if(ByteCommand.invokevirtual.equals(opcode)){
				InvokeVirtualCmd cmd=new InvokeVirtualCmd(opcode,clzFile);
				cmd.setOprand1(iter.next2CharToInt());
				cmd.setOprand2(iter.next2CharToInt());
				cmds.add(cmd);
			}else if(ByteCommand.ldc.equals(opcode)){
				LdcCmd cmd=new LdcCmd(opcode,clzFile);
				cmd.setOprand(iter.next2CharToInt());
				cmds.add(cmd);
			}else if(ByteCommand.putfield.equals(opcode)){
				PutFieldCmd cmd=new PutFieldCmd(opcode,clzFile);
				cmd.setOprand1(iter.next2CharToInt());
				cmd.setOprand2(iter.next2CharToInt());
				cmds.add(cmd);
			}else if(ByteCommand.dup.equals(opcode) 
					|| ByteCommand.aload_0.equals(opcode) 
					|| ByteCommand.aload_1.equals(opcode) 
					|| ByteCommand.aload_2.equals(opcode)
					|| ByteCommand.iload_1.equals(opcode) 
					|| ByteCommand.iload_2.equals(opcode) 
					|| ByteCommand.iload_3.equals(opcode)
					|| ByteCommand.fload_3.equals(opcode) 
					|| ByteCommand.iconst_0.equals(opcode)
					|| ByteCommand.iconst_1.equals(opcode)
					|| ByteCommand.istore_1.equals(opcode)
					|| ByteCommand.istore_2.equals(opcode)
					|| ByteCommand.voidreturn.equals(opcode) 
					|| ByteCommand.iadd.equals(opcode)
					|| ByteCommand.astore_1.equals(opcode)
					|| ByteCommand.ireturn.equals(opcode)){
				NoOprandCmd cmd=new NoOprandCmd(opcode,clzFile);
				cmds.add(cmd);
			}
		}
		calculateOffset(cmds);
		ByteCommand[] result=new ByteCommand[cmds.size()];
		cmds.toArray(result);
		return result;
	}

	private static void calculateOffset(List<ByteCommand> cmds) {
		int offset=0;
		for(ByteCommand cmd:cmds){
			cmd.setOffset(offset);
			offset+=cmd.getLength();
		}
	}

	public static class CommandIterator{
		private String code;
		private int pos=0;
		public CommandIterator(String code) {
			this.code=code;
		}
		public String next2CharToString(){
			String c=code.substring(2);
			pos+=2;
			return c;
		}
		
		public int next2CharToInt(){
			int i=Integer.parseInt(code.substring(2));
			pos+=2;
			return i;
		}
		public boolean hasNext(){
			return pos<code.length();
		}
	}
}
