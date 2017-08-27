package com.edu.tery.observer;

import java.util.List;

import com.edu.tery.iterator.ArrayList;

/**
 * @author Create by tery007
 * @date   2017年8月25日
 * 数据源
 */
public class Subject {

	List<Obsever> obsevers=new ArrayList<>();
	
	public void addObsever(Obsever obsever){
		if(!this.obsevers.contains(obsever)){
			obsevers.add(obsever);
		}
	}
	
	public void removeObserver(Obsever obsever){
		if(this.obsevers.contains(obsever)){
			obsevers.remove(obsever);
		}
	}
	
	public void notifyObsevers(Object data){
		for(Obsever obsever :obsevers ){
			obsever.update(this, data);
		}
	}
	
}
