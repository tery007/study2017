package com.edu.tery.driver;

import java.sql.Connection;

import com.edu.tery.properties.Properties;

/**
 * @author Create by tery007
 * @date   2017年8月17日
 *
 *JDBC的DriverFactory，是所有数据库驱动的超类
 */
public interface JDBCDriver {

	public Connection create(Properties info);
}
