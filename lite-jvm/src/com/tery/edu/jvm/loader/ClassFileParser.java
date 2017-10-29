package com.tery.edu.jvm.loader;

import java.io.UnsupportedEncodingException;

import com.tery.edu.jvm.clsMsg.AccessFlag;
import com.tery.edu.jvm.clsMsg.ClassFile;
import com.tery.edu.jvm.clsMsg.ClassIndex;
import com.tery.edu.jvm.constant.ClassInfo;
import com.tery.edu.jvm.constant.ConstantPool;
import com.tery.edu.jvm.constant.FieldRefInfo;
import com.tery.edu.jvm.constant.MethodRefnfo;
import com.tery.edu.jvm.constant.NameAndTypeInfo;
import com.tery.edu.jvm.constant.NullConstantInfo;
import com.tery.edu.jvm.constant.StringInfo;
import com.tery.edu.jvm.constant.Utf8Info;
import com.tery.edu.jvm.field.Field;
import com.tery.edu.jvm.method.Method;
import com.tery.edu.jvm.util.BinaryCodeIterator;

/**
 * @author Create by tery007
 * @date   2017年10月9日
 *	接收一个字节数组，转化成若干解析后需要存储信息的类
 */
public class ClassFileParser {

	public ClassFile parse(byte[] codes) {
		ClassFile clzFile=new ClassFile();
		BinaryCodeIterator iter=new BinaryCodeIterator(codes);
		String magicNumber=iter.nextU4ToHexString();//魔数
		if(!"cafebabe".equals(magicNumber)){
			return null;
		}
		parseJavaVersion(iter,clzFile);
		
		parseConstantPool(iter,clzFile);
		
		parseAccessFlag(iter,clzFile);//类访问标识
		
		parseClassIndex(iter,clzFile);//类在常量池中索引
		
		parseInterfaces(iter,clzFile);
		
		parseFields(iter,clzFile);
		
		parseMethods(iter,clzFile);
		return null;
	}

	private void parseJavaVersion(BinaryCodeIterator iter, ClassFile clzFile) {
		clzFile.setMinorVersion(iter.nextU2ToInt());//次版本号
		clzFile.setMajorVersion(iter.nextU2ToInt());//主版本号
	}

	private void parseMethods(BinaryCodeIterator iter, ClassFile clzFile) {
		int methodCount=iter.nextU2ToInt();
		for(int i=1;i<methodCount;i++){
			Method m=Method.parseMethod(iter,clzFile);
			clzFile.addMethod(m);
		}
	}

	//接口未作解析
	private void parseInterfaces(BinaryCodeIterator iter, ClassFile clzFile) {
		int superClassCount=iter.nextU2ToInt();
		System.out.println("super class number:"+superClassCount);
	}

	private void parseFields(BinaryCodeIterator iter,ClassFile clzFile) {
		int fieldCount=iter.nextU2ToInt();
		for(int i=0;i<fieldCount;i++){
			Field f=Field.parseFields(iter,clzFile);
			clzFile.addField(f);
		}
	}

	private void parseClassIndex(BinaryCodeIterator iter, ClassFile clzFile) {
		ClassIndex cIndex=new ClassIndex(iter.nextU2ToInt(),iter.nextU2ToInt());
		clzFile.setClassIndex(cIndex);
	}

	private void parseAccessFlag(BinaryCodeIterator iter, ClassFile clzFile) {
		AccessFlag aflag=new AccessFlag(iter.nextU2ToInt());
		clzFile.setAccessFlag(aflag);
	}

	private void parseConstantPool(BinaryCodeIterator iter, ClassFile clzFile) {
		int constantNumber=iter.nextU2ToInt();
		ConstantPool pool=new ConstantPool();
		pool.addConstantInfo(new NullConstantInfo());
		for(int i=1;i<=constantNumber-1;i++){
			int index=iter.nextU1ToInt();
			if(index==1){//utf8_info
				int len=iter.nextU2ToInt();
				byte[] bytes=iter.getBytes(len);
				String infos=null;
				try {
					infos = new String(bytes,"UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Utf8Info utf8Info=new Utf8Info(pool);
				utf8Info.setLength(len);
				utf8Info.setValue(infos);
				pool.addConstantInfo(utf8Info);
			}else if(index==7){//Class_info
				int nameIndex=iter.nextU2ToInt();
				ClassInfo clzInfo=new ClassInfo(pool);
				clzInfo.setUtf8Index(nameIndex);
				pool.addConstantInfo(clzInfo);
			}else if(index==8){//String_info
				int stringIndex=iter.nextU2ToInt();
				StringInfo sInfo=new StringInfo(pool);
				sInfo.setStringIndex(stringIndex);
				pool.addConstantInfo(sInfo);
			}else if(index==9){//Field_info
				int classIndex=iter.nextU2ToInt();
				int nameAndTypeIndex=iter.nextU2ToInt();
				FieldRefInfo info=new FieldRefInfo(pool);
				info.setClassIndex(classIndex);
				info.setNameAndTypeIndex(nameAndTypeIndex);
				pool.addConstantInfo(info);
			}else if(index==10){//Method_ref_info
				int classIndex=iter.nextU2ToInt();
				int nameAndTypeIndex=iter.nextU2ToInt();
				MethodRefnfo info=new MethodRefnfo(pool);
				info.setClzIndex(classIndex);
				info.setNameAndTypeIndex(nameAndTypeIndex);
				pool.addConstantInfo(info);
			}else if(index==12){//NameAndType_info
				int nameIndex=iter.nextU2ToInt();
				int descIndex=iter.nextU2ToInt();
				NameAndTypeInfo info=new NameAndTypeInfo(pool);
				info.setNameIndex(nameIndex);
				info.setDescIndex(descIndex);
				pool.addConstantInfo(info);
			}else{
				throw new RuntimeException("the tag:"+index+" has not been realize");
			}
		}
		clzFile.setConstantPool(pool);
	}

}
