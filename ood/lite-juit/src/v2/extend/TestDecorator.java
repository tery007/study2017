package v2.extend;

import v2.Assert;
import v2.Test;
import v2.TestResult;

/**
 * @author Create by tery007
 * @date   2017Äê9ÔÂ4ÈÕ
 *
 */
public class TestDecorator extends Assert implements Test{

	protected Test test;
	public  TestDecorator(Test test) {
		this.test=test;
	}
	@Override
	public int countTestCases() {
		return test.countTestCases();
	}

	@Override
	public void run(TestResult tr) {
		test.run(tr);
	}
	
	public Test getTest(){
		return test;
	}
	
	public void basicRun(TestResult tr){
		run(tr);
	}

}
