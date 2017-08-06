package com.edu.tery;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Create by tery007
 * @date   2017年8月6日
 *线程安全
 *保证一个线程对数据库的多次操作，对应的connection都是同一个
 *无锁编程
 */
public class SingletonThreadConnHolder {

	//ThreadLocal给每个线程都创建了一个Connection副本
	private static ThreadLocal<ConnectionHolder> threadLocal=new ThreadLocal<>();
	
	//为每个线程创建一个connectionHolder对象
	public static ConnectionHolder getConnectionHolder(){
		ConnectionHolder holder=threadLocal.get();
		if(holder==null){
			holder=new ConnectionHolder();
			threadLocal.set(holder);
		}
		return holder;
	}
	
	//用connectionHolder对象获取数据库连接
	public static Connection getConnection(DataSource source) throws SQLException{
		return getConnectionHolder().getConnection(source);
	}
}
