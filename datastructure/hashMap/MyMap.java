package com.edu.tery.map;
/**
 * @author Create by tery007
 * @date   2017年8月9日
 *Map接口
 */
public interface MyMap<K,V> {

	public V put(K k,V v);
	public V get(K k);
	
	/**
	 * 内部接口
	 * @author tery
	 *
	 * @param <K>
	 * @param <V>
	 */
	interface Entry<K,V>{
		public K getKey();
		public V getValue();
	}
}
