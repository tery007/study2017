package com.edu.tery.map;
/**
 * @author Create by tery007
 * @date   2017年8月9日
 *
 */
public class MyHashMap<K,V> implements MyMap<K, V>{

	//数组初始化长度为8
	private static final int INITIAL_CAPACITY=1<<4;
	//阈值比例
	private static final float LOAD_FACTOR=0.75f;
	//自定义的数组大小
	private int size;
	//自定义的阈值
	private float factor;
	
	//Map当中Entry的数量
	private int entrySize;
	
	//Entry数组
	private Entry<K,V>[] table=null;
	//门面模式
	public  MyHashMap() {
		this(INITIAL_CAPACITY,LOAD_FACTOR);
	}
	@SuppressWarnings("unchecked")
	private MyHashMap(int size,float factor){
		if(size<0){
			throw new IllegalArgumentException("illegal size:"+size);
		}
		if(factor<0||Float.isNaN(factor)){
			throw new IllegalArgumentException("illegal factor:"+factor);
		}
		this.size=size;
		this.factor=factor;
		table=new Entry[this.size];
	}
	
	
	@Override
	public V put(K k, V v) {
		if(size>=entrySize*factor){
			resize(2*entrySize);
			
		}
		V oldValue=null;
		int index=getIndex(k,entrySize);
		if(table[index]==null){
			table[index]=new Entry<K,V>(k,v,null);
			entrySize++;
		}else{
			Entry<K,V> entry=table[index];
			Entry<K,V> e=entry;
			//遍历所有链表节点，去掉key值重复的元素
			while(e!=null){
				//如果key相同，则覆盖旧值并返回旧值
				if(k==e.getKey() || k.equals(e.getKey())){
					oldValue=e.value;
					e.value=v;
					return oldValue;
				}
				e=e.next;
			}
			//不重复、index位置上有元素:将该位置原先的值设置为新entry的next
			table[index]=new Entry<K,V>(k,v,entry);
		}
		return null;
	}

	private int getIndex(K k, int entrySize2) {
		int m=entrySize-1;//最后一个元素的下标
		int index=hash(k.hashCode())&m;
		return index>=0?index:-index;
	}
	private int hash(int hashCode) {
		hashCode=hashCode^((hashCode>>>20)^(hashCode>>>12));  
        return hashCode^((hashCode>>>7)^(hashCode>>>4));  
	}
	private void resize(int newSize) {
		Entry<K,V>[] oldEntry=table;
		int oldSize=table.length;
		Entry<K,V>[] newEntry=new Entry[newSize];
		transfer(newEntry);
	}
	private void transfer(Entry<K, V>[] newEntry) {
		int newSize=newEntry.length;
		for(Entry<K,V> e:table){
			while(null !=e){
				Entry<K,V> next=e.next;
				int index=getIndex(e.getKey(),newSize);
				e.next=newEntry[index];//将当前entry的next指向新的索引位置
				newEntry[index]=e;//给新的entry位置赋值
				e=next;
			}
		}
	}
	@Override
	public V get(K k) {
		// TODO Auto-generated method stub
		return null;
	}
	
	static class Entry<K,V> implements MyMap.Entry<K, V>{

		private K key;
		private V value;
		private Entry<K,V> next;//链表的下一个对象
		public Entry(){
			
		}
		
		public Entry(K key,V value,Entry<K,V> next){
			this.key=key;
			this.value=value;
			this.next=next;
		}
		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}
		
	}

}
