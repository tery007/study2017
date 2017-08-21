package com.edu.tery.factory.domain;

import java.sql.Connection;

import com.edu.tery.factory.driver.JDBCDriver;
import com.edu.tery.factory.properties.Properties;


/**
 * @author Create by tery007
 * @date   2017年8月17日
 *模拟客户端获取mysql连接
 */
public class Client {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			Class<?> clz=Class.forName("com.edu.tery.mysql.MysqlDriver");//装载MysqlDriver
			JDBCDriver factory=(JDBCDriver)clz.newInstance();
			Properties info=new Properties();
			info.put("host", "localhost");
			info.put("port", "3306");
			info.put("database", "student");
			info.put("username", "root");
			info.put("password", "root");
			//创建MysqlConnection
			Connection conn=factory.create(info);
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
