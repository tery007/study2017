package com.edu.tery.arraylist;

import java.util.Arrays;

/**
 * @author Create by tery007
 * @date   2017年7月29日
 *
 */
public class ArrayList {

	private int size;
	private static final int CAMACITY = 16;
	private Object[] elementData;

	public int size() {
		return size;
	}

	public ArrayList() {
		elementData = new Object[CAMACITY];
	}

	// 增
	public void add(Object o) {
		if (isFull()) {
			increseSize();
		}
		elementData[size] = o;
		size++;
	}

	// 删
	public Object remove(int index) {
		if (isEmpty()) {
			throw new RuntimeException("the list is null");
		}
		if (index > elementData.length || index < 0) {
			throw new IllegalArgumentException("IllegalArgument index:" + index);
		}
		System.arraycopy(elementData, index + 1, elementData, index, size - index);
		size--;
		return elementData[index];
	}

	// 指定位置增加
	public void add(int index, Object o) {
		if (isFull()) {
			increseSize();
		}
		Object[] elements = new Object[elementData.length];
		for (int i = index; i < size && i >= 0; i++) {
			elements[i + 1] = elementData[i];
		}
		elements[index] = o;
		elementData = elements;
		size++;
		/**
		 * 第二种方式 System.arraycopy(elementData, index, elementData, index+1,
		 * size-index); 从index这里开始拷贝，拷到index+1这个位置，大小为后面所有元素的总个数（size-index）
		 * elementData[index]=o;
		 */

	}

	// 查
	public Object get(int index) {
		if (index < 0) {
			throw new IllegalArgumentException("the argument is an illegalArgument");
		}
		Object o = new Object();
		for (int i = 0; i < size; i++) {
			o = elementData[index];
		}
		return o;
	}

	// 扩容
	public void increseSize() {
		// Object[] newElementData=new Object[CAMACITY*2];
		// for(int i=0;i<newElementData.length;i++){
		// newElementData[i]=elementData[i];
		// }
		elementData = Arrays.copyOf(elementData, size * 2);

	}

	// 数组是否满了
	public boolean isFull() {
		if (size == elementData.length - 1) {
			return true;
		} else {
			return false;
		}
	}

	// 集合是否为空
	public boolean isEmpty() {
		return size <= 0;
	}

	public ListIterator iterator() {
		return new ListIterator();
	}

	/**
	 * 迭代器
	 * 
	 * @author tery
	 *
	 */
	public class ListIterator implements java.util.Iterator<Object> {
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public Object next() {
			Object o = new Object();
			o = elementData[currentIndex++];
			return o;
		}

		/**
		 * 删除当前遍历的对象，先调用next方法，再调用删除方法
		 */
		@Override
		public void remove() {
			System.arraycopy(elementData, currentIndex, elementData, currentIndex - 1, size - currentIndex + 1);
			currentIndex--;// 必须将索引减1，保证索引的正确性
			size--;
		}
	}
}
