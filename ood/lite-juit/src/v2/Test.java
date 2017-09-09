package v2;
/**
 * @author Create by tery007
 * @date   2017年9月1日
 *	测试用例的超类
 */
public interface Test {

	//记录运行了多少个测试用例
	public abstract int countTestCases();
	//run方法中，用tr来记录测试结果
	public void run(TestResult tr);
}
