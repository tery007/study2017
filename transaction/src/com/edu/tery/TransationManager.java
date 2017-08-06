package com.edu.tery;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Create by tery007
 * @date   2017年8月6日
 *事物管理类
 */
public class TransationManager {

	private DataSource source;
	
	public TransationManager(DataSource source){
		this.source=source;
	}
	
	public Connection getConnection() throws SQLException{
		return SingletonThreadConnHolder.getConnection(source);
	}
	
	//开启事物
	public void start() throws SQLException{
		Connection connection=getConnection();
		connection.setAutoCommit(false);
	}
	
	//回滚事物
	public void rollback(){
		Connection connection=null;
		try {
			connection=getConnection();
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//关闭事物
	public void closeTransaction(){
		Connection connection=null;
		try {
			connection=getConnection();
			connection.setAutoCommit(false);
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
