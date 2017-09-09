package v2.extend;

import v2.Protectable;
import v2.Test;
import v2.TestResult;

/**
 * @author Create by tery007
 * @date   2017年9月4日
 *装饰者，在测试前后添加setup和teardown方法
 */
public class TestSetUp extends TestDecorator{

	public TestSetUp(Test test) {
		super(test);
	}

	public void run(final TestResult tr){
		Protectable p=new Protectable() {
			@Override
			public void protect() throws Throwable {
				setUp();
				basicRun(tr);//方法内部类只能访问final修饰的变量，因为用了final，jvm在匿名内部类的构造方法中指向一个复制品，对其改变不影响原有的对象
				tearDown();
			}
		};
	}
	private void tearDown() {
		// TODO Auto-generated method stub
		
	}

	private void setUp() {
		// TODO Auto-generated method stub
		
	}
}
