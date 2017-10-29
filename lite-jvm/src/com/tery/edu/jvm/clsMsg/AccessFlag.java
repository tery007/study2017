package com.tery.edu.jvm.clsMsg;
/**
 * @author Create by tery007
 * @date   2017年10月9日
 *	访问标志,很多场景下会用到，所以抽象成一个类
 */
public class AccessFlag {

	private int accessFlagValue;

	public AccessFlag(int accessFlagValue){
		this.accessFlagValue=accessFlagValue;
	}
	public int getAccessFlagValue() {
		return accessFlagValue;
	}

	public void setAccessFlagValue(int accessFlagValue) {
		this.accessFlagValue = accessFlagValue;
	}
	/**
	 * 是否是PUBLIC
	 * @return
	 */
	public boolean isPublicAccess(){
		return (this.accessFlagValue & 0x0001) != 0;
	}
	/**
	 * 是否是FINAL
	 * @return
	 */
	public boolean isFinalAccess(){
		return (this.accessFlagValue & 0x0010) != 0;
	}
}
