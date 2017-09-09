package v001v.useinvoke;

import java.lang.reflect.Method;

/**
 * @author Create by tery007
 * @date   2017年9月1日
 *封装一个测试执行模板
 */
public abstract class TestCase implements Test{

	private String name;
	TestCase(String name){
		this.name=name;
	}
	public void run(){
		setUp();
		try{
			runTest();
		}catch(Throwable e){
			e.printStackTrace();
		}finally{
			tearDown();
		}
	}
	protected void tearDown() {
		// TODO Auto-generated method stub
		
	}
	//make a agreement that each method has a unique name,and the name's index is 'test'
	//throw this way to find the test methods ,use invoke to call different method 
	protected void runTest() throws Throwable {
		Method method=this.getClass().getMethod(name, new Class[0]);
		method.invoke(this, new Object[0]);
	}
	protected void setUp() {
		// TODO Auto-generated method stub
		
	}
}
