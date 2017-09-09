package v2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by tery007
 * @date   2017年9月1日
 *	测试类错误搜集
 */
public class TestResult {

	List<TestFailure> failures;
	List<TestFailure> errors;
	List<TestListener> listeners;
	int testCount;
	boolean stop;
	
	public TestResult(){
		this.failures=new ArrayList<>();
		this.errors=new ArrayList<>();
		this.listeners=new ArrayList<>();
		testCount=0;
		stop=false;
	}
	
	public void addFailure(Test t,AssertionFailedError error){
		failures.add(new TestFailure(t,error));
		//发出广播，让所有观察者获取数据
		for(TestListener listener:listeners){
			listener.addError(t, error);
		}
	}
	public List<TestFailure> getFailures(){
		return failures;
	}
	public List<TestFailure> getErrors(){
		return errors;
	}
	public void addErrors(Test t,Throwable throwable){
		errors.add(new TestFailure(t,throwable));
		for(TestListener listener:listeners){
			listener.addFailure(t, throwable);
		}
	}
	
	public void startTest(Test t){
		int count=t.countTestCases();
		testCount+=count;
		for(TestListener listener:listeners){
			listener.startTest(t);
		}
	}
	
	public void endTest(Test t){
		for(TestListener listener:listeners){
			listener.endTest(t);
		}
	}
	
	//开始执行
	public void run(final TestCase t){
		startTest(t);
		try{
			t.doRun();
		}catch(AssertionFailedError e){
			addFailure(t, e);
		}catch(Throwable e){
			addErrors(t, e);
		}
		endTest(t);
	}
	
	public int runCount(){
		return testCount;
	}
	
	public void runProtected(Test t,Protectable p){
		try{
			p.protect();
		}catch(AssertionFailedError e){
			addFailure(t, e);
		}catch(Throwable e){
			addErrors(t, e);
		}
	}
	
	public boolean shouStop(){
		return stop;
	}
	
	public int errorCount(){
		return errors.size();
	}
	
	public int failedCount(){
		return failures.size();
	}
	public void addListener(TestListener listener){
		listeners.add(listener);
	}
	
	public void removeListener(TestListener listener){
		listeners.remove(listener);
	}
	
	public boolean isSuccess(){
		return failures.size()==0&&errors.size()==0;
	}
}
