package v1;

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
	int testCount;
	boolean stop;
	public TestResult(){
		this.failures=new ArrayList<>();
		this.errors=new ArrayList<>();
		testCount=0;
		stop=false;
	}
	
	public void addFailure(Test t,AssertionFailedError error){
		failures.add(new TestFailure(t,error));
	}
	
	public void addErrors(Test t,Throwable throwable){
		errors.add(new TestFailure(t,throwable));
	}
	
	public void startTest(Test t){
		int count=t.countTestCases();
		testCount+=count;
	}
	
	public void endTest(Test t){
		
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
	
	public boolean isSuccess(){
		return failures.size()==0&&errors.size()==0;
	}
}
