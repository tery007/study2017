package com.tery.edu.jvm.attr;

import com.tery.edu.jvm.util.BinaryCodeIterator;

/**
 * @author Create by tery007
 * @date   2017年10月16日
 *	Method的Code属性的StackMapTable属性
 */
public class StackMapTable extends AttributeInfo{

	private String originalCode;
	public void setOriginalCode(String code){
		this.originalCode=code;
	}
	public StackMapTable(int attrNameIndex, int attrLength) {
		super(attrNameIndex, attrLength);
		// TODO Auto-generated constructor stub
	}
	public static StackMapTable parse(BinaryCodeIterator iter) {
		int attrNameIndex=iter.nextU2ToInt();
		int attrLength=iter.nextU4ToInt();
		StackMapTable mapTable=new StackMapTable(attrNameIndex, attrLength);
		//StackMapTable属性较为复杂，没有作解析，只是保存了字节码
		String code=iter.nextUxToHexString(attrLength);
		mapTable.setOriginalCode(code);
		return mapTable;
	}

	
}
