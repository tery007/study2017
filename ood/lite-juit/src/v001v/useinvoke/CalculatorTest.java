package v001v.useinvoke;

import v001v.Calculator;

/**
 * @author Create by tery007
 * @date   2017Äê9ÔÂ1ÈÕ
 *
 */
public class CalculatorTest extends TestCase implements Test{

	Calculator calculator=null;
	
	CalculatorTest(String name) {
		super(name);
	}
	public void setUp(){
		calculator=new Calculator();
	}

	public void tearDown(){
		calculator=null;
	}
	
	public void test1(){
		calculator.add(5);
		System.out.println(calculator.getResult());
	}
	
	public void test2(){
		calculator.substract(3);
		System.out.println(calculator.getResult());
	}
}
