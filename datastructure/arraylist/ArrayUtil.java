package com.edu.tery.arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by tery007
 * @date   2017年7月29日
 *
 */
public class ArrayUtil {
	
	/**
	 * 给定一个整形数组a , 对该数组的值进行置换
		例如： a = [7, 9 , 30, 3]  ,   置换后为 [3, 30, 9,7]
		如果     a = [7, 9, 30, 3, 4] , 置换后为 [4,3, 30 , 9,7]
	 * @param origin
	 * @return
	 */
	//这里涉及到值传递，new一个数组是实现不了的，按照下面的方式可以实现
	public void reverseArray(int[] origin){
		int start=0;
		while(start<origin.length/2){
			int temp=origin[start];
			origin[start++]=origin[origin.length-start-1];
			origin[origin.length-start-1]=temp;
		}
	}
	
	/**
	 * 现在有如下的一个数组：   int oldArr[]={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}   
	 * 要求将以上数组中值为0的项去掉，将不为0的值存入一个新的数组，生成的新数组为：   
	 * {1,3,4,5,6,6,5,4,7,6,7,5}  
	 * @param oldArray
	 * @return
	 */
	
	public Integer[] removeZero(int[] oldArray){
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<oldArray.length;i++){
			if(oldArray[i]!=0){
				list.add(oldArray[i]);
			}
		}
		Integer[] newArray=new Integer[list.size()];
		//list.toArray(T[] a)方法将list中所有元素塞入到一个数组中
		return list.toArray(newArray);
	}
	
	/**
	 * 给定两个已经排序好的整形数组， a1和a2 ,  创建一个新的数组a3, 使得a3 包含a1和a2 的所有元素， 并且仍然是有序的
	 * 例如 a1 = [3, 5, 7,8]   a2 = [4, 5, 6,7]    则 a3 为[3,4,5,6,7,8]    , 注意： 已经消除了重复
	 * @param array1
	 * @param array2
	 * @return
	 */
	
	public int[] merge(int[] array1, int[] array2){
		int m=0,n=0,k=0;
		int[] arr=new int[array1.length+array2.length];
		while(m<array1.length&&n<array2.length){
			if(array1[m]<array2[n]){
				arr[k++]=array1[m++];
			}else{
				arr[k++]=array2[n++];
			}
		}
		while(m<array1.length){
			arr[k++]=array1[m++];
		}
		while(n<array2.length){
			arr[k++]=array2[n++];
		}
		return  arr;
	}
	/**
	 * 把一个已经存满数据的数组 oldArray的容量进行扩展， 扩展后的新数据大小为oldArray.length + size
	 * 注意，老数组的元素在新数组中需要保持
	 * 例如 oldArray = [2,3,6] , size = 3,则返回的新数组为
	 * [2,3,6,0,0,0]
	 * @param oldArray
	 * @param size
	 * @return
	 */
	public int[] grow(int [] oldArray,  int size){
		int[] newArr=new int[oldArray.length+size];
		for(int i=oldArray.length-1;i<newArr.length;i++){
			newArr[i]=0;
		}
		return newArr;
	}
	
	/**
	 * 斐波那契数列为：1，1，2，3，5，8，13，21......  ，给定一个最大值， 返回小于该值的数列
	 * 例如， max = 15 , 则返回的数组应该为 [1，1，2，3，5，8，13]
	 * max = 1, 则返回空数组 []
	 * @param max
	 * @return
	 */
	public int[] fibonacci(int max){
		if(max<=1){
			return null;
		}
		int[] arr=new int[max];
		arr[0]=1;
		arr[1]=1;
		for(int i=0;i<max;i++){
			if(arr[i]<max){
				arr[i+2]=arr[i+1]+arr[i];
			}
		}
		return arr;
	}
	
	/**
	 * 返回小于给定最大值max的所有素数数组
	 * 例如max = 23, 返回的数组为[2,3,5,7,11,13,17,19]
	 * @param max
	 * @return
	 */
	public Integer[] getPrimes(int max){
		if(max<=1){
			throw new IllegalArgumentException();
		}
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<max;i++){
			if(isPrime(i)){//大象拆解
				list.add(i);
			}
		}
		Integer[] arr=new Integer[list.size()];
		return list.toArray(arr);
	}
	/**
	 * 判断是否为素数
	 * @param num
	 * @return
	 */
	private boolean isPrime(int num){
		for(int i=2;i<num;i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	/**
	 * 所谓“完数”， 是指这个数恰好等于它的因子之和，例如6=1+2+3
	 * 给定一个最大值max， 返回一个数组， 数组中是小于max 的所有完数
	 * @param max
	 * @return
	 */
	public Integer[] getPerfectNumbers(int max){
		List<Integer> list=new ArrayList<>();
		for(int i=1;i<=max;i++){
			if(isPerfect(i)){//大象拆分
				list.add(i);
			}
		}
		Integer[] arr=new Integer[list.size()];
		return list.toArray(arr);
	}
	
	private boolean isPerfect(int num) {
		int sum=0;
		for(int i=1;i<num;i++){
			if(num%i==0){
				sum+=i;
			}
		}
		if(sum==num){
			return true;
		}
		return false;
	}

	/**
	 * 用seperator 把数组 array给连接起来
	 * 例如array= [3,8,9], seperator = "-"
	 * 则返回值为"3-8-9"
	 * @param array
	 * @param s
	 * @return
	 */
	public String join(int[] array, String seperator){
		return null;
	}
	

}
