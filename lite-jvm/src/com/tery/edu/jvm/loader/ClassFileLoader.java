package com.tery.edu.jvm.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.tery.edu.jvm.clsMsg.ClassFile;

/**
 * @author Create by tery007
 * @date   2017年10月9日
 *	加载类，将其转化为字节码
 */
public class ClassFileLoader {

	List<String> paths=new ArrayList<>();
	public byte[] readBinaryCode(String className){
		className=className.replace('.', File.separatorChar);
		for(String path:this.paths){
			String classFileName=path+File.separatorChar+".class";
			byte[] codes=loadClassFile(classFileName);
			if(null != codes){
				return codes;
			}
		}
		return null;
	}
	private byte[] loadClassFile(String classFileName) {
		try {
			byte[] codes=IOUtils.toByteArray(new FileInputStream(new File(classFileName)));
			if(null !=codes){
				return codes;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addClassPath(String path){
		if(path.contains(path)){
			return;
		}
		paths.add(path);
	}
	
	public String getClassPath(){
		StringBuilder buffer=new StringBuilder();
		for(int i=0;i<paths.size();i++){
			if(i==paths.size()-1){
				buffer.append(paths.get(i));
			}else{
				buffer.append(";"+paths.get(i));
			}
		}
		return buffer.toString();
	}
	
	/**
	 * CommonIo实现的getClassPath
	 */
	public String getClassPathCommon(){
		return StringUtils.join(this.paths, ';');
	}
	
	public ClassFile loadClass(String className){
		byte[] codes=readBinaryCode(className);
		ClassFileParser parser=new ClassFileParser();
		return parser.parse(codes);
	}
}
