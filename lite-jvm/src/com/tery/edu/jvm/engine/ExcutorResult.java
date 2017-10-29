package com.tery.edu.jvm.engine;

import com.tery.edu.jvm.method.Method;

/**
 * @author Create by tery007
 * @date 2017年10月20日 函数栈帧执行结果 4种类型：执行完一条再执行下面一条;暂停当前栈帧的执行，
 *       创建新的栈帧;跳转到另外一行指令去执行;退出当前栈帧
 * 
 */
public class ExcutorResult {

	public static final int RUN_NEXT_CMD = 1;
	public static final int JUMP = 2;
	public static final int EXIT_CURR_FRAME = 3;
	public static final int PAUSE_AND_NEW_FRAME = 4;
	private Method nextMethod;
	private int nextCmdOffset;
	
	public int getNextCmdOffset() {
		return nextCmdOffset;
	}

	public void setNextCmdOffset(int nextCmdOffset) {
		this.nextCmdOffset = nextCmdOffset;
	}

	public int getNextAction() {
		return nextAction;
	}

	public void setNextAction(int nextAction) {
		this.nextAction = nextAction;
	}

	public void setNextMethod(Method nextMethod) {
		this.nextMethod = nextMethod;
	}

	public Method getNextMethod() {
		return nextMethod;
	}

	private int nextAction = RUN_NEXT_CMD;
	
	public boolean isPauseAndRunNextFrame() {
		return this.nextAction==PAUSE_AND_NEW_FRAME;
	}
	
	public boolean isJump(){
		return this.nextAction==JUMP;
	}
	
	public boolean isRunNextCmd(){
		return this.nextAction==RUN_NEXT_CMD;
	}
	public boolean isExitCurrentFrame(){
		return this.nextAction==EXIT_CURR_FRAME;
	}
}
