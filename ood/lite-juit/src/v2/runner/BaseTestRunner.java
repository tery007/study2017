package v2.runner;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import v2.Test;
import v2.TestListener;
import v2.TestSuite;

/**
 * @author Create by tery007
 * @date   2017年9月3日
 *运行测试的主类，同时将自己做为listener注册（观察者）
 */
public abstract class BaseTestRunner implements TestListener{
	
	public static final String SUITE_METHODNAME="suite";
	
	public static String getFilteredTrace(Throwable t) { 
		StringWriter stringWriter= new StringWriter();
		PrintWriter writer= new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		StringBuffer buffer= stringWriter.getBuffer();
		String trace= buffer.toString();
		return trace;
		//return BaseTestRunner.filterStack(trace);
	}
	/**
	 * 通过类名加载testsuite
	 * @param className
	 * @return
	 */
	protected Test getTest(String className) {
		if(className==null || className==""){
			return null;
		}
		Class<?> clz=null;
		try {
			clz=loadSuiteClass(className);
		} catch (ClassNotFoundException e) {
			String clzName=e.getMessage();
			if(clzName==null){
				clzName=className;
				runFailed("Class Not found"+clzName);
			}
			e.printStackTrace();
		}
		Method suiteMethod=null;
		try {
			suiteMethod=clz.getMethod(SUITE_METHODNAME, new Class[0]);
		} catch (Exception e) {
			return new TestSuite(clz);//返回一个新的TestSuite对象
		}
		Test test=null;
		try {
			test=(Test)suiteMethod.invoke(null, new Object[0]);
		} catch (IllegalAccessException e) {
			runFailed("failed to invoke suite:"+e.toString());
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			runFailed("failed to invoke suite:"+e.getTargetException().toString());
			e.printStackTrace();
		}
		return test;
	}

	protected abstract void runFailed(String string);

	private Class<?> loadSuiteClass(String className) throws ClassNotFoundException {
		return Class.forName(className);
	}
}
