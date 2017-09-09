package v001v;
/**
 * @author Create by tery007
 * @date   2017年9月1日
 * 测试用例的抽象类，封装了一个执行模板
 */
public abstract class TestCase implements Test{
	
	private String name;
	
	public TestCase(String name){
		this.name=name;
	}
	
	@Override
	public void run() {
		setUp();
		try{
			runTest();
		}finally{
			tearDown();
		}
		
	}

	protected void tearDown() {
		// TODO Auto-generated method stub
		
	}

	protected void runTest() {
		// TODO Auto-generated method stub
		
	}

	protected void setUp() {
		// TODO Auto-generated method stub
		
	}

}
