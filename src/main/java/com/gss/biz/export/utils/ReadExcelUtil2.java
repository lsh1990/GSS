package com.gss.biz.export.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gss.biz.export.model.InfoModel;
import com.gss.uitls.DBCPUtils;



/**
 * @Description: 读取excel数据
 * @author-lsh
 * @date 2018年4月12日 下午3:12:13
 */
public class ReadExcelUtil2 {
	
	
	public static void main(String[] args) {
		
		String filePath = "F:\\\\测试 - 副本.xlsx";
		readExcel(filePath,"");
	}
	
	
	
	 public static Map<String, InfoModel> readExcel(String filePath, String title) {
	        Map<String, InfoModel> map = new HashMap<String, InfoModel>();
	        FileOutputStream outputStream = null;
	        try {
	        	outputStream = new FileOutputStream("F:\\测试 - 副本-测试.xlsx");
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
	 
	        // 创建对Excel工作簿文件的引用
	        try {
	        	//filePath是文件地址。
	        	XSSFWorkbook wookbook = new XSSFWorkbook(new FileInputStream(filePath));
	            // 在Excel文档中，第一张工作表的缺省索引是0
	 
	            XSSFSheet sheet = wookbook.getSheetAt(0);
	 
	            // 获取到Excel文件中的所有行数
	            int rows = sheet.getPhysicalNumberOfRows();
	            int max_cells = 0;
	            
//	            Connection conn = JDBCTest.getConnection();
	            DataSource dataSource = DBCPUtils.getDataSource();
	            Connection conn = dataSource.getConnection();
	            // 获取最长的列，在实践中发现如果列中间有空值的话，那么读到空值的地方就停止了。所以我们需要取得最长的列。<br data-filtered="filtered">　　　　　　　　　　　　　　//如果每个列正好都有一个空值得话，通过这种方式获得的列长会比真实的列要少一列。所以我自己会在将要倒入数据库中的EXCEL表加一个表头<br data-filtered="filtered">　　　　　　　　　　　　　　//防止列少了，而插入数据库中报错。
	            for (int i = 0; i < rows; i++) {
	                XSSFRow row = sheet.getRow(i);
	                if (row != null) {
	                    int cells = row.getPhysicalNumberOfCells();
	                    if (max_cells < cells) {
	                        max_cells = cells;
	                    }
	 
	                }
	            }
//	            System.out.println(max_cells);
	            // 遍历行
	            for (int i = 1; i < rows; i++) {
	                // 读取左上端单元格
	                XSSFRow row = sheet.getRow(i);
	                
//	                if (i == 10) {
//						break;
//					}
	                
	                // 行不为空
	                if (row != null) {
						String value = "";
						//遍历列
						String b_id = null;
						//获取列的值
						XSSFCell cell = row.getCell(0);
						if (cell != null) {
							//条码号
							String barcode = String.valueOf(row.getCell(0));
							System.out.println(barcode);
							XSSFCell cell2 = row.getCell(2);
							if ("待查验".equals(String.valueOf(cell2))) {
								
								QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
								
								
								
								
//								if (model.getCreateTime() != null && model.getPassType() != null) {
//									System.out.println("查询有结果:" + barcode);
//									row.createCell(3);
//									row.createCell(4);
//									row.getCell(3).setCellValue(model.getCreateTime());
//									row.getCell(4).setCellValue(model.getPassType());
//								}
							}
						}
						
					}
	             }
	            wookbook.write(outputStream);
	            wookbook.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        return map;
	    }
	 
	 public static InfoModel getResultSet(String barcode) {
		 
		 QueryRunner qr = new QueryRunner(DBCPUtils.getDataSource());
		 InfoModel model = new InfoModel();
		 
		 String sql = "SELECT * FROM running_package WHERE barcode = ";
		 sql += barcode;
		 
		 
		return null;
	 } 
	 
	}
