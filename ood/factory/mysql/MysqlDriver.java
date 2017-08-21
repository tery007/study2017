package com.edu.tery.factory.mysql;

import java.sql.Connection;

import com.edu.tery.factory.driver.JDBCDriver;
import com.edu.tery.factory.properties.Properties;


/**
 * @author Create by tery007
 * @date   2017Äê8ÔÂ17ÈÕ
 *
 */
public class MysqlDriver implements JDBCDriver{

	Properties info;
	@Override
	public Connection create(Properties info) {

		return new MysqlConnection(info);
	}


}
