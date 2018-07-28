package org.fkjava.oa.core.common.io;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

/**
 * FileTools
 */
public final class FileTools {

	/**
	 * 公用的文件上传方法
	 * @param srcFile 原文件
	 * @param srcFileName 原文件名
	 * @param filePath 路径
	 * @return 路径 + 新文件名
	 * @throws Exception
	 */
	public static String upload(File srcFile, String srcFileName, String filePath) throws Exception{
		/** 获取项目的部署路径 + 图片存储路径 */
		String realPath = ServletActionContext.getServletContext().getRealPath("/" + filePath);
		/** 生成新的文件名 */
		String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(srcFileName); // jpg
		/** 文件拷贝  */
		FileUtils.copyFile(srcFile, new File(realPath + File.separator + newFileName));
		/** 最后返回文件路径 */
		return "/" + filePath + newFileName;
	}
	
	/**
	 * 删除部署路径下文件的方法
	 * @param oldUrl 文件的相对路径
	 */
	public static void deleteFile(String oldUrl) {
		/** 获取项目的部署路径  */
		String realPath = ServletActionContext.getServletContext().getRealPath("/");
		File file = new File(realPath + oldUrl);
		if (file.exists() && file.isFile()){
			file.delete();
		}
	}
}
