package com.edu.tery.db2;

import java.sql.Connection;

import com.edu.tery.driver.JDBCDriver;
import com.edu.tery.properties.Properties;

/**
 * @author Create by tery007
 * @date   2017年8月17日
 *	DB2的Driver工厂类，负责创建一个DB2连接
 */
public class DB2Driver implements JDBCDriver{

	
	public Connection create(Properties info){
		return new DB2Connection(info);
	}
}
