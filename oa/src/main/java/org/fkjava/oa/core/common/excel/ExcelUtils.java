package org.fkjava.oa.core.common.excel;

import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Excel操作工具类
 */
public class ExcelUtils {

	public static void exportExcel(String sheetname, String[] titles, List<?> data, 
				HttpServletResponse response, String excleFileName) throws Exception{
		/** 创建工作簿 */
		HSSFWorkbook workbook = new HSSFWorkbook();
		/** 创建工作单 */
		HSSFSheet sheet = workbook.createSheet(sheetname);
		
		/** 创建第一行作为标题行 */
		HSSFRow row = sheet.createRow(0);
		/** 循环创建第一行中的列 */
		for (int i = 0; i < titles.length; i++){
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(titles[i]);
		}
		
		/** 创建数据行 */
		for (int i = 0; i < data.size(); i++){
			/** 创建一行 */
			row = sheet.createRow(i + 1);
			/** 获取集合中的元素(实体) */
			Object obj = data.get(i);
			/** 获取所有的Field */
			Field[] fields = obj.getClass().getDeclaredFields();
			/** 迭代字段 */
			for (int j = 0; j < fields.length; j++){
				/** 创建列 */
				HSSFCell cell = row.createCell(j);
				/** 获取一个字段 */
				Field field = fields[j];
				/** 设置访问权限 */
				field.setAccessible(true);
				/** 获取字段的值  */
				Object res = field.get(obj);
				/** 设置列中的内容 */
				cell.setCellValue(res == null ? "" : res.toString());
			}
		}
		
		/** 下载时文件为中文乱码解决 */
		excleFileName = URLDecoder.decode(excleFileName, "gbk");
		excleFileName = new String(excleFileName.getBytes("gbk"), "iso8859-1"); 
		/** 设置响应头 */
		response.setHeader("Content-Disposition", "attachment;filename="+ excleFileName +".xls");
		/** 输出 */
		workbook.write(response.getOutputStream());
	}
}