package v2.sample;

import v2.Test;
import v2.TestSuite;

/**
 * @author Create by tery007
 * @date   2017年9月4日
 *一个计算器的TestSuite
 */
public class CalculatorSuite {

	public static Test suite(){
		TestSuite suite=new TestSuite("Calculator All test");
		suite.addTestCase(CalculatorTest.class);
		return suite;
	}
}
