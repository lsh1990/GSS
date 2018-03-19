package com.gss.uitls;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 创建本地数据库
 * @author-lsh
 * @date 2018年3月15日 下午8:42:54
 */
@Slf4j
public class H2DBUtils {

	/**
	 * @Description: 创建数据库到本地
	 */
	public static void create() {
		//本地数据库存放路径
		File dbfile = new File(H2DB.H2_DB_LOCAL_PATH);
		//如果已经存在，并且文件非空，则直接加载即可
		if (dbfile.exists()) {
			log.info("H2DBUtils.create ## H2数据库已存在!");
			return;
		}
		//获取classPath下的文件
		InputStream stream = H2DBUtils.class.getClassLoader().getResourceAsStream(H2DB.H2_DB_PATH);
		//写到临时文件
		File srcFile = writeToFile(stream, H2DB.H2_DB_LOCAL_PATH);
		try {
			FileUtils.copyFileToDirectory(srcFile, dbfile, true);
			log.info("H2DBUtils.create ## H2数据库创建完毕!");
		} catch (IOException e) {
			log.error("H2DBUtils.create ## 创建数据库到本地失败",e);
		}
	}
	
	/**
	 * @Description:H2相关常量-后期存放到配置文件
	 * @author-lsh
	 * @date 2018年3月15日 下午8:45:54
	 */
	public static class H2DB{
		//缓存文件名称
		public static String H2_DB_TEMP_PATH = "wincc.mv.db";
		//程序下的库文件
		public static String H2_DB_PATH = "h2-data/wincc.mv.db";
		//h2数据库本地存储路径
		public static String H2_DB_LOCAL_PATH = "D:/software/h2-wincc-data/";
	}
	
	/**
	 * @Description: 将输入流中的内容，写入到File中
	 * @param is
	 * @param temporaryFile
	 * @return 
	 */
	public static File writeToFile(InputStream is, String temporaryFile){
		File root = new File("");
		String srcFilePath = root.getAbsolutePath() + File.separator + temporaryFile;
		//创建文件
		File srcFile = new File(srcFilePath);
		FileOutputStream os;
		try {
			os = new FileOutputStream(srcFile);
			//IO流写入文件
			int i;
			byte[] buf = new byte[1024];
			try {
				while ((i = is.read(buf)) != -1) {
					os.write(buf, 0, i);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					is.close();
					os.close();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		} catch (FileNotFoundException e3) {
			e3.printStackTrace();
		}
		return srcFile;
	}
	
	public static void main(String[] args) {
		File dbfile = new File(H2DB.H2_DB_LOCAL_PATH);
		if (dbfile.exists()) {
			System.out.println("cunzai");
		}
	}
}
