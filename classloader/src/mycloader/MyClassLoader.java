package mycloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Create by tery007
 * @date   2017Äê10ÔÂ8ÈÕ
 *
 */
public class MyClassLoader extends ClassLoader{

	protected Class<?> findClass(String name){
		byte[] classBytes;
		classBytes = loadClassBytes(name);
		return defineClass(name,classBytes,0,classBytes.length);
	}

	private byte[] loadClassBytes(String name) {
		String fileName="C:\\temp"+name+File.separatorChar+name.replace('.', File.separatorChar)+".class";
		InputStream is=null;
		try {
			is=new FileInputStream(new File(fileName));
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			byte[] bytes=new byte[1024];
			int len=0;
			while((len=is.read(bytes))!=-1){
				baos.write(bytes, 0, len);
			}
			return baos.toByteArray();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null !=is){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
