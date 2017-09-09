package v2.testui;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

import v2.AssertionFailedError;
import v2.Test;
import v2.TestFailure;
import v2.TestResult;
import v2.runner.BaseTestRunner;

/**
 * @author Create by tery007
 * @date   2017年9月3日
 *
 */
public class TestRunner extends BaseTestRunner{

	protected PrintStream writer=System.out;//打印流
	protected int column=0;//打印行数
	
	
	@Override
	public synchronized void startTest(Test test) {
		writer.print(".");
		if(column++>=40){
			writer.println();
			column=0;
		}
	}

	@Override
	public synchronized void addFailure(Test test, Throwable t) {
		writer.print("F");
	}

	@Override
	public synchronized void addError(Test test, AssertionFailedError error) {
		writer.println("E");
	}

	@Override
	public void endTest(Test test) {
	}

	public static void main(String[] args){
		TestRunner runner=new TestRunner();
		try{
			TestResult result=runner.start(args);
			if(result.isSuccess()){
				System.exit(-1);
			}
			System.exit(0);//正常停止JVM
		}catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}

	private TestResult start(String[] args) {
		if(args.length<=0){
			throw new RuntimeException("the args is null");
		}
		String className=args[0];
		Test t=getTest(className);
		return doRun(t);
	}

	private TestResult doRun(Test t) {
		TestResult result=new TestResult();
		result.addListener(this);
		long startTime=System.currentTimeMillis();
		t.run(result);
		long endTime=System.currentTimeMillis();
		writer.println();
		writer.print("执行测试时间："+excuteTimeToString(startTime,endTime)+"ms");
		writer.println();
		printResult(result);
		return result;
	}

	private void printResult(TestResult result) {
		printErrors(result);
		printFailures(result);
		printHeaders(result);
	}

	private void printHeaders(TestResult result) {
		if(result.isSuccess()){
			writer.println("Success! all test is pass");
			writer.println("total test number:"+result.runCount());
		}else{
			writer.println("Fail !");
			writer.println("Tests run: "+result.runCount()+  ",  Failures: "+result.failedCount()+ ",  Errors: "+result.errorCount());
		}
	}

	private void printFailures(TestResult result) {
		List<TestFailure> failures=result.getFailures();
		if(failures.isEmpty() || failures==null ||result.failedCount()==0){
			return;
		}
		writer.println("there is "+result.failedCount()+" failures:");
		for(TestFailure f : failures){
			writer.println(f.getFaildedTest());
			writer.println(getFilteredTrace(f.thrownException()));
		}
		
	}

	private void printErrors(TestResult result) {
		List<TestFailure> errors=result.getErrors();
		if(errors.isEmpty() || errors==null ||result.errorCount()==0){
			return;
		}
		writer.print("there is "+result.errorCount()+" errors");
		for(TestFailure e : errors){
			writer.println(e.getFaildedTest());
			writer.println(getFilteredTrace(e.thrownException()));
		}
	}

	private String excuteTimeToString(long startTime, long endTime) {
		long excuteTime=endTime-startTime;
		return Long.toString(excuteTime);
	}

	@Override
	protected void runFailed(String msg) {
		System.out.println(msg);
		System.exit(-1);//停止运行JVM
	}

	


}
