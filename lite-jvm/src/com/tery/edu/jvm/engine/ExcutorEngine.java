package com.tery.edu.jvm.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.tery.edu.jvm.method.Method;

/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ20ÈÕ
 *
 */
public class ExcutorEngine {

	private Stack<StackFrame> stack = new Stack<>();
	
	public void excute(Method mainMethod) {
		StackFrame mainframe = StackFrame.create(mainMethod);
		stack.push(mainframe);
		while(!stack.isEmpty()){
			StackFrame frame = stack.peek();
			ExcutorResult result = frame.excute();
			if(result.isPauseAndRunNextFrame()){
				Method nextMethod = result.getNextMethod();
				StackFrame nextFrame = StackFrame.create(nextMethod);
				nextFrame.setCallerFrame(frame);
				setFuntionCallParams(frame,nextFrame);
				stack.push(nextFrame);
			}else{
				stack.pop();
			}
		}
		
	}

	private void setFuntionCallParams(StackFrame frame, StackFrame nextFrame) {
		Method nextMethod = nextFrame.getMethod();
		List<String> params = nextMethod.getParameterList();
		int paramNum = params.size()+1;
		List<JavaObject> values = new ArrayList<>();
		while(paramNum>0){
			values.add(frame.getOprandStack().pop());
			paramNum--;
		}
		//µ¹Ðò
		List<JavaObject> paramList = new ArrayList<>();
		for(int i=values.size()-1; i>=0; i++){
			paramList.add(values.get(i));
		}
		nextFrame.setLocalVariableTable(paramList);
	}

}
