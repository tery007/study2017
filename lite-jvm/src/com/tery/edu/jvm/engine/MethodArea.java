package com.tery.edu.jvm.engine;

import java.util.HashMap;
import java.util.Map;

import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.loader.ClassFileLoader;
import com.tery.edu.jvm.method.Method;

/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ20ÈÕ
 *
 */
public class MethodArea {

	private ClassFileLoader loader;
	public static final MethodArea instance = new MethodArea();
	private Map<String, ClassFile> clzss=new HashMap<>();
	public void addClassLoader(ClassFileLoader loader) {
		this.loader=loader;
	}
	private MethodArea(){
	}
	public Method getMainMethod(String className) {
		ClassFile clz=findClass(className);
		return clz.getMainMethod();
	}
	private ClassFile findClass(String className) {
		if(this.clzss.containsKey(className)){
			return clzss.get(className);
		}
		ClassFile clz=loader.loadClass(className);
		clzss.put(className, clz);
		return clz;
	}
	public static MethodArea getInstance() {
		return instance;
	}

}
