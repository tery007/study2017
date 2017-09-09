package v2.sample;

import v2.Assert;
import v2.Calculator;
import v2.TestCase;

/**
 * @author Create by tery007
 * @date   2017年9月4日
 *	一个具体的测试用例
 */
public class CalculatorTest extends TestCase {

	public CalculatorTest(String name) {
		super(name);
	}
	Calculator cal=null;
	
	public void setUp(){
		cal=new Calculator();
	}
	
	public void tearDown(){
		cal=null;
	}
	
	public void testAdd(){
		cal.add(5);
		Assert.assertEquals(5, cal.getResult());
	}
	
	public void testSubtract(){
		cal.substract(9);
		Assert.assertEquals(9, cal.getResult());
	}
	public static void main(String[] args) {
		CalculatorTest test1=new CalculatorTest("testAdd"){
			public void runTest(){
				setUp();
				testAdd();
				tearDown();
			}
		};
//		test1.runTest();
	}

}
