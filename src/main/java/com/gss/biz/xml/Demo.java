package com.gss.biz.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.gss.uitls.FileToolUtils;
import com.gss.uitls.TransmitterPropertyConfigs.FilePath;

/**
 * @Description: 读取文件并解析xml，错误文件进行移除
 * @author-lsh
 * @date 2018年5月23日 下午10:49:30
 */
public class Demo {

	
	public static void main(String[] args) {
		//获取文件夹的所有xml
		FileToolUtils.getAllDataFile(FilePath.RECEIVE_PATH, 5, "xml");
	}
}
