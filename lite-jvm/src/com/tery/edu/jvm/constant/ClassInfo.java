package com.tery.edu.jvm.constant;
/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ9ÈÕ
 *
 */
public class ClassInfo extends ConstantInfo{

	private int tag=ConstantInfo.CLASS_INFO;
	private int utf8Index;
	
	public ClassInfo(ConstantPool pool){
		super(pool);
	}
	
	public int getTag() {
		return tag;
	}
	public int getUtf8Index() {
		return utf8Index;
	}
	public void setUtf8Index(int utf8Index){
		this.utf8Index=utf8Index;
	}
	public String getClassName(){
		int index=getUtf8Index();
		Utf8Info utf8Info=(Utf8Info)pool.getConstantInfo(index);
		return utf8Info.getValue();
	}
	
}
