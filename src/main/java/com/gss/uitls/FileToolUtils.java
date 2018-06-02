package com.gss.uitls;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gss.uitls.Constant.FileSymbol;

public class FileToolUtils {
	private static Logger logger = LoggerFactory.getLogger(FileToolUtils.class);
	private static final DateFormat FORMAT = new SimpleDateFormat("yyyyMMdd");
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmssSSS");  // 实例化模板对象
	private static String WEB_INF = "WEB-INF";

	public static String move(File srcFile, String destPath) {
		String finalFileName = srcFile.getName();

		// Destination directory
		File dir = new File(destPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		// Move file to new directory
		File oldFile = new File(destPath + finalFileName);
		if (oldFile.exists() && oldFile.isFile()) {
			oldFile.delete();
		}
		boolean success = srcFile.renameTo(new File(dir, finalFileName));
		if (success) {
			return oldFile.getAbsolutePath();
		}

		return "";
	}
	
	public static boolean moveAndValidate(File srcFile, String destPath) {
		String finalFileName = srcFile.getName();
		
		// Destination directory
		File dir = new File(destPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		// Move file to new directory
 		File oldFile = new File(destPath + finalFileName);
		if (oldFile.exists() && oldFile.isFile()) {
			oldFile.delete();
		}
		return srcFile.renameTo(oldFile);
		
	}
	
	/**  
     * 删除单个文件  
     *   
     * @param filePath 被删除文件的全路径
     * @return 单个文件删除成功返回true，否则返回false  
     */  
    public static boolean deleteFile(String filePath) {  
        boolean flag = false;  
        File file = new File(filePath);  
        // 路径为文件且不为空则进行删除  
        if (file.isFile() && file.exists()) {  
        	flag = file.delete();  
        }  
        return flag;  
    }  

	public static List<File> getFiles(File fileDir, String fileType, int size) {
		List<File> lfile = new ArrayList<File>();
		File[] fs = fileDir.listFiles();
		
		if(fs == null || fs.length < 1){
			return null;
		}
		for (File file : fs) {
			if (file.isFile()) {
				String type = file.getName().substring(file.getName().lastIndexOf(".") + 1, file.getName().length());
				type = type.toUpperCase();
				if (fileType.equalsIgnoreCase(type)) {
					lfile.add(file);
				}
				
				//获取最大处理能力的文件数目
	        	if(!lfile.isEmpty() && lfile.size() >= size){
	        		return lfile;
	        	}
	        	
			} else {
				List<File> ftemps = getFiles(file, fileType, size);
				lfile.addAll(ftemps);
			}
		}
		return lfile;
	}

	/**
	 * @detail 保存文件
	 * @param pathDir
	 * @param is
	 * @param reportType
	 * @param fileName
	 * @param saveFileName
	 * @return
	 */
	public static String saveFile(InputStream is, String rootDir, String reportType, String saveFileName){
		FileOutputStream fos = null;
		Date date = new Date();
		String dateDir = FORMAT.format(date);
		String path = "";
		
		if (rootDir.contains("bak")) {
			if(StringUtils.isBlank(reportType)){
				path = rootDir + dateDir + FileSymbol.UNIX_SEPARATOR;
			}else {
				path = rootDir + dateDir + FileSymbol.UNIX_SEPARATOR + reportType + FileSymbol.UNIX_SEPARATOR;
			}
		} else {
			if(StringUtils.isBlank(reportType)){
				path = rootDir;
			}else {
				path = rootDir + reportType + FileSymbol.UNIX_SEPARATOR;
			}
		}
		
		File savePath = new File(path);
		if(!savePath.exists()){
			boolean mkDir = savePath.mkdirs();
			logger.info("创建edi目录:{}, 结果：{}",path, mkDir == true ? "成功":"失败");
		}

		//文件后面重新命名，添加时间
		String fileNameArray[] = saveFileName.split("\\.");    
		StringBuffer sb = new StringBuffer();
		sb.append(fileNameArray[0]).append("_" + SDF.format(new Date())).append(Constant.XML_FILE_POSTFIX_SEPARATOR);
		
		String savedFileName = path + sb.toString();
		try {
			fos = new FileOutputStream(savedFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int ch = 0;
		try {
			while((ch = is.read()) != -1){
				fos.write(ch);	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if (fos!= null) {
					fos.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return savedFileName;
	}
	
	public static String saveFileToLocal(InputStream is, String fileName, String reportSavePath, String prefix){
   		//固化到本地
		String localFileName = saveFile(is, reportSavePath, prefix, fileName);
		
		File savedFile = new File(localFileName);
		if(!savedFile.exists()){
			logger.error("本地文件保存为{}不存在。", localFileName);
			return "";
		}
		if(!savedFile.isFile()){
			logger.error("本地文件保存为{}失败。", localFileName);
			return "";
		}
		return localFileName;
    }

	/**
	 * 根据文件类型生成文件夹路径
	 * 
	 * @param rootDir
	 * @return
	 */
	public static String getFolder(String rootDir, String prefix){
		Date date = new Date();
		String dateDir = FORMAT.format(date);
		String path = rootDir;
		
		//只有bak文件夹才有日期
		if(StringUtils.contains(rootDir, "bak") || StringUtils.contains(rootDir, "error")){
			path = rootDir + dateDir + FileSymbol.UNIX_SEPARATOR + prefix + FileSymbol.UNIX_SEPARATOR;
		}
		
		File savePath = new File(path);
		if(!savePath.exists()){
			boolean mkDir = savePath.mkdirs();
			logger.info("FileTools.getFolder ## 创建当天接收数据文件目录. #result:#{}", mkDir);
		}
		return savePath.getAbsolutePath() + FileSymbol.UNIX_SEPARATOR;
	}

	/**
	 * InputStream转化为String
	 * 
	 * @param InputStream
	 * @return
	 */
	public static String inputStream2String(InputStream is) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i = -1;
		while ((i = is.read()) != -1) {
			baos.write(i);
		}
		return baos.toString();
	}

	/**
	 * 写入文件
	 * 
	 * @param String
	 *            fileName
	 * @param String
	 *            content
	 */
	public static void writeToFile(String fileName, String content) {
		try {
			FileUtils.write(new File(fileName), content, "utf-8", false);
			logger.info("文件 " + fileName + " 写入成功!");
		} catch (IOException e) {
			logger.error("文件 " + fileName + " 写入失败! " + e.getMessage());
		}
	}

	/**
	 * 写入文件
	 * 
	 * @param String
	 *            fileName
	 * @param InputStream
	 *            is
	 */
	public static void writeToFile(String fileName, InputStream is) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int ch = 0;
		try {
			while ((ch = is.read()) != -1) {
				fos.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos!= null) {
					fos.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * @Description: 获取指定目录下的所有指定类型文件
	 * @param path 文件夹地址
	 * @param size 一次获取的文件数量
	 * @param fileType 获取的文件类型  例:xml 
	 * @return 
	 */
	public static List<File> getAllDataFile(String path, int size, String fileType) {
		List<File> dataFileList = new ArrayList<File>();
		File fileDir = new File(path);//sortingline.receive.path=D:/Temp/receive
		if (fileDir.exists()) {
			List<File> fileList = FileToolUtils.getFiles(fileDir, fileType, size);
			if (fileList != null && !fileList.isEmpty()) {
				dataFileList.addAll(fileList);
			}
		}
		return dataFileList;
	}

	public static boolean deleteFiles(List<String> needDeleteFilePaths) {
		
		boolean isSuccess = true;
		
		if(needDeleteFilePaths.isEmpty()){
			return isSuccess;
		}
		
		for (String filePath : needDeleteFilePaths) {
			boolean deleteFile = deleteFile(filePath);
    		if(deleteFile){
				logger.info("FileToolUtils.deleteFiles ## 删除文件夹中信息报文,处理状态：成功.#fileName:#{}", filePath);
			}else{
				isSuccess = false;
				logger.error("FileToolUtils.deleteFiles ## 删除文件夹中信息报文,处理状态：失败.#fileName:#{}", filePath);
			}
			
		}
		
		return isSuccess;
	}
	
	/**
	 * 获取当前web工程的绝对路径 + 工程目录下某个文件夹
	 * 
	 * @param filePath 文件夹路径(例如:aaa/bbb,取得web工程下面的目录aaa/bbb的绝对路径)
	 * 
	 * @return web工程的绝对路径 + 工程目录下某个文件夹
	 */
	public static String getFilePath(String filePath){
	    //按照 WEB-INF进行分割，取前一段
	    String currentPath = getCurrentPath();
	    String path = currentPath.substring(0, currentPath.indexOf(WEB_INF)) + filePath;
	    
	    //去掉path字符串中最前面的"/"
	    if(path.indexOf("/") == 0) {
	        path = path.substring(1);
	    }
		return path;
	}
	
	/**
	 * 获取当前应用程序的所在绝对路径
	 * 
	 * @return 路径全称
	 */
	private static String getCurrentPath() {
	    return FileUtils.class.getClassLoader().getResource("").getPath();
	}
	
}
