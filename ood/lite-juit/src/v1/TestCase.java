package v1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Create by tery007
 * @date   2017年9月1日
 * 测试流程模板
 */
public abstract class TestCase extends Assert implements Test{
	
	private String name;
	
	public TestCase(String name){
		this.name=name;
	}
	
	public int countTestCases(){
		return 1;
	}
	
	public void run(TestResult tr){
		tr.run(this);
	}
	
	//执行模板
	public void doRun() {
		setUp();
		try{
			runTest();
		}finally{
			tearDown();
		}
		
	}

	protected void tearDown() {
		
	}

	//反射执行测试方法
	protected void runTest() {
		Method method=null;
		try {
			method=getClass().getDeclaredMethod(name, new Class<?>[0]);
		} catch (NoSuchMethodException e) {
			fail("Method \""+name+"\" not found");
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		if(!Modifier.isPublic(method.getModifiers())){
			fail("Method \""+name+"\" is not public");
		}
		try {
			method.invoke(name, new Object[0]);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

}
