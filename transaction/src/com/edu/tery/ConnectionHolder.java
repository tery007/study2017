package com.edu.tery;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

/**
 * @author Create by tery007
 * @date   2017年8月6日
 * 
 *实现DataSource到数据库管道的路由
 *非线程安全
 */
public class ConnectionHolder {

	//用map保证每个数据源与connection对象一一对应
	private Map<DataSource,Connection> map=new HashMap<DataSource, Connection>();
	//外部获取connection的接口
	public Connection getConnection(DataSource source) throws SQLException{
		Connection conn=map.get(source);
		if(conn==null || conn.isClosed()){
			conn=source.getConnection();
			map.put(source, conn);
		}
		return conn;
	}
	
}
