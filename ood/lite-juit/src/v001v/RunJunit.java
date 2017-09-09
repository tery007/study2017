package v001v;
/**
 * @author Create by tery007
 * @date   2017年9月1日
 *
 *用匿名内部类的方式解决：一个runTest()与多个测试方法的冲突
 */
public class RunJunit {

	public static void main(String[] args) {
		TestCase tc1=new CalculatorTest("test1"){//匿名内部类，这个类是继承于CalculatorTest的，只是为了不需要重新写一个类，所以采用了匿名的方式
			protected void runTest(){//runTest()方法是继承于TestCase的
				test1();
			}
		};
		TestCase tc2=new CalculatorTest("test2"){
			protected void runTest(){
				test2();
			}
		};
		tc1.run();
		tc2.run();
	}
}
