package com.tery.edu.jvm.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.tery.edu.jvm.cmd.ByteCommand;
import com.tery.edu.jvm.method.Method;

/**
 * @author Create by tery007
 * @date 2017年10月20日
 *
 */
public class StackFrame {

	private Stack<JavaObject> oprandStack = new Stack<JavaObject>();
	private List<JavaObject> localVariableTable = new ArrayList<>();
	private Method method;
	private int index = 0;

	private StackFrame callerFrame;
	public void setCallerFrame(StackFrame frame) {
		this.callerFrame = frame;
	}
	public StackFrame getCallerFrame(){
		return this.callerFrame;
	}
	private StackFrame(Method mainMethod) {
		this.method = mainMethod;
	}

	public Stack<JavaObject> getOprandStack() {
		return oprandStack;
	}

	public void setOprandStack(Stack<JavaObject> oprandStack) {
		this.oprandStack = oprandStack;
	}

	public List<JavaObject> getLocalVariableTable() {
		return localVariableTable;
	}

	public void setLocalVariableTable(List<JavaObject> localVariableTable) {
		this.localVariableTable = localVariableTable;
	}

	public static StackFrame create(Method mainMethod) {
		StackFrame frame = new StackFrame(mainMethod);
		return frame;
	}

	// ExcutorResult只保存当前执行命令的执行结果
	public ExcutorResult excute() {
		ByteCommand[] cmds = method.getCmds();
		while (index < cmds.length) {
			ExcutorResult result = new ExcutorResult();
			result.setNextAction(ExcutorResult.RUN_NEXT_CMD);
			cmds[index].excute(this, result);
			if (result.isRunNextCmd()) {
				index++;
			} else if (result.isExitCurrentFrame()) {
				return result;
			} else if (result.isPauseAndRunNextFrame()) {
				index++;
				return result;
			} else if (result.isJump()) {
				int offset = result.getNextCmdOffset();
				this.index = getCmdIndex(offset);
			} else {
				index++;
			}
		}
		ExcutorResult result = new ExcutorResult();
		result.setNextAction(ExcutorResult.EXIT_CURR_FRAME);
		return result;
	}

	private int getCmdIndex(int offset) {
		ByteCommand[] cmds = this.method.getCmds();
		for (int i = 0; i < cmds.length; i++) {
			if (cmds[i].getOffset() == i) {
				return i;
			}
		}
		return 0;
	}


	public Method getMethod() {
		return this.method;
	}

}
