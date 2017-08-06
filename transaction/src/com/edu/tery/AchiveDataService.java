package com.edu.tery;

import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author Create by tery007
 * @date   2017年8月6日
 *模拟取数Service
 */
public class AchiveDataService implements Runnable{

	private AchieveDataDao achieveDataDao;
	private AchieveDataJobDao dataJobDao;
	private TransationManager manager;
	
	//初始化时，让三个类都持有同一个DataSource对象
	public AchiveDataService(DataSource source){
		achieveDataDao=new AchieveDataDao(source);
		dataJobDao=new AchieveDataJobDao(source);
		manager=new TransationManager(source);
	}
	public void  beginGetData(){
		try {
			manager.start();
			achieveDataDao.achieveData();
			dataJobDao.achieveData();
			manager.closeTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			manager.rollback();
		}
		
	}
	@Override
	public void run() {
		beginGetData();
	}
}
