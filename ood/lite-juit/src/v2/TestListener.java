package v2;
/**
 * @author Create by tery007
 * @date   2017年9月3日
 *观察者模式，将测试的结果（数据源）的展示和测试逻辑分离
 */
public interface TestListener {

	public void startTest(Test test);
	public void addFailure(Test test,Throwable t);
	public void addError(Test test,AssertionFailedError error);
	public void endTest(Test test);
}
