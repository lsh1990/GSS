package com.basis.serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Description: 序列化测试
 * @author-lsh
 * @date 2018年5月16日 下午5:21:56
 */
public class SerializationTest {
	
	public static void main(String[] args) throws IOException {
		
		User user = new User();
		user.setName("张三");
		user.setAge(20);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream obj = new ObjectOutputStream(out);
		
		obj.writeObject(user);
		
		
	}
	
	

}
