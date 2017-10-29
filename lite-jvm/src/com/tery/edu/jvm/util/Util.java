package com.tery.edu.jvm.util;
/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ10ÈÕ
 *
 */
public class Util {

	public static String byteToHexString(byte[] bs) {
		if(bs.length<=0){
			return null;
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<bs.length;i++){
			int b=bs[i] & 0xFF;
			String value=Integer.toHexString(b);
			if(value.length()<2){
				value="0"+value;
			}
			sb.append(value);
			
		}
		return sb.toString();
	}

	public static int byteToInt(byte[] bs) {
		if(bs.length<=0){
			throw new RuntimeException();
		}
		String s=byteToHexString(bs);
		return Integer.valueOf(s, 16).intValue();
	}

}
