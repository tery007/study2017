package com.edu.tery;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Create by tery007
 * @date   2017年8月6日
 *模拟从数据库取数据Dao类
 */
public class AchieveDataDao {

	private DataSource source;
	
	public AchieveDataDao(DataSource source){
		this.source=source;
	}
	
	public void achieveData() throws SQLException{
		Connection connection=SingletonThreadConnHolder.getConnection(source);
		//取数据操作，省略...
		
		System.out.println("当前取数据线程为："+Thread.currentThread().getName());
		System.out.println("取数据的管道为："+connection.hashCode());
	}
}
