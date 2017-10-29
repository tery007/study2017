package com.tery.edu.jvm.attr;

import java.util.ArrayList;
import java.util.List;

import com.tery.edu.jvm.util.BinaryCodeIterator;

/**
 * @author Create by tery007
 * @date   2017年10月16日
 *	Method的Code属性的LineNumberTable属性
 */
public class LineNumberTable extends AttributeInfo{

	List<LineNumberItem> items=new ArrayList<>();
	public LineNumberTable(int attrNameIndex, int attrLength) {
		super(attrNameIndex, attrLength);
		// TODO Auto-generated constructor stub
	}

	private static class LineNumberItem{
		private int startPC;
		private int lineNumber;
		
		public int getStartPC() {
			return startPC;
		}
		public void setStartPC(int startPC) {
			this.startPC = startPC;
		}
		public int getLineNumber() {
			return lineNumber;
		}
		public void setLineNumber(int lineNumber) {
			this.lineNumber = lineNumber;
		}
	}
	public void addLineNumberItem(LineNumberItem item){
		items.add(item);
	}
	
	public static LineNumberTable parse(BinaryCodeIterator iter) {
		int attrNameIndex=iter.nextU2ToInt();
		int attrLength=iter.nextU4ToInt();
		LineNumberTable lineNumberTable=new LineNumberTable(attrNameIndex, attrLength);
		int lineNumberTableLength=iter.nextU2ToInt();//line_number_table[]数组的成员个数
		for(int i=1;i<lineNumberTableLength;i++){
			LineNumberItem item=new LineNumberItem();
			item.setStartPC(iter.nextU2ToInt());
			item.setLineNumber(iter.nextU2ToInt());
			lineNumberTable.addLineNumberItem(item);
		}
		return lineNumberTable;
	}

	
}
