package com.tery.edu.jvm.attr;

import java.util.ArrayList;
import java.util.List;

import com.tery.edu.jvm.util.BinaryCodeIterator;

/**
 * @author Create by tery007
 * @date   2017年10月16日
 *	Method的Code属性的LocalVariableTable属性
 */
public class LocalVariableTable extends AttributeInfo{

	List<LocalVariableItem> items=new ArrayList<>();
	
	public LocalVariableTable(int attrNameIndex, int attrLength) {
		super(attrNameIndex, attrLength);
		// TODO Auto-generated constructor stub
	}
	
	private static class LocalVariableItem{
		private int startPC;
		private int length;
		private int nameIndex;
		private int descriptorIndex;
		private int index;
		public int getStartPC() {
			return startPC;
		}
		public void setStartPC(int startPC) {
			this.startPC = startPC;
		}
		public int getLength() {
			return length;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public int getNameIndex() {
			return nameIndex;
		}
		public void setNameIndex(int nameIndex) {
			this.nameIndex = nameIndex;
		}
		public int getDescriptorIndex() {
			return descriptorIndex;
		}
		public void setDescriptorIndex(int descriptorIndex) {
			this.descriptorIndex = descriptorIndex;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		
	}
	
	public void addLocalVariableItem(LocalVariableItem item){
		this.items.add(item);
	}
	
	public static LocalVariableTable parse(BinaryCodeIterator iter) {
		int attrNameIndex=iter.nextU2ToInt();
		int attrLength=iter.nextU4ToInt();
		LocalVariableTable table=new LocalVariableTable(attrNameIndex, attrLength);
		int localVariableLen=iter.nextU2ToInt();
		for(int i=1;i<=localVariableLen;i++){
			int startPC=iter.nextU2ToInt();
			int length=iter.nextU2ToInt();
			int nameIndex=iter.nextU2ToInt();
			int descriptorIndex=iter.nextU2ToInt();
			int index=iter.nextU2ToInt();
			LocalVariableItem item=new LocalVariableItem();
			item.setStartPC(startPC);
			item.setLength(length);
			item.setNameIndex(nameIndex);
			item.setDescriptorIndex(descriptorIndex);
			item.setIndex(index);
			table.addLocalVariableItem(item);
		}
		return table;
	}

	
}
