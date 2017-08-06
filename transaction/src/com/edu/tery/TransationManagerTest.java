package com.edu.tery;
/**
 * @author Create by tery007
 * @date   2017年8月7日
 *测试类
 */
public class TransationManagerTest {

	public static final String driver="com.mysql.jdbc.Driver";
	public static final String url="jdbc:mysql://192.168.99.121:3306/test";
	public static final String name="root";
	public static final String password="root";
	
	public static void main(String[] args) {
		CommonDataSource source=new CommonDataSource();
		source.setDriver(driver);
		source.setName(name);
		source.setPassword(password);
		source.setUrl(url);
		
		final AchiveDataService service = new AchiveDataService(source);
		Thread thread=new Thread(service);
		thread.start();
	
	}
	
}
