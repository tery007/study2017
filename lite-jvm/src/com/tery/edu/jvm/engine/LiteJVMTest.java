package com.tery.edu.jvm.engine;


/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ20ÈÕ
 *	JVM Test
 */
public class LiteJVMTest {

	public static final String PATH="D:\\study\\mycode\\codings\\group22\\1595414159\\lite-jvm\\bin\\com\\tery\\edu\\jvm\\model";
	public static final String CLASSNAME="lite-jvm.src.com.tery.edu.jvm.model.EmployeeV1";
	public static void main(String[] args) {
		LiteJVM jvm=new LiteJVM();
		String[] classPaths={PATH};
		jvm.run(classPaths,CLASSNAME);
	}
}
