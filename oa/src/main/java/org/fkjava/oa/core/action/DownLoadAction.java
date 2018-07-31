package org.fkjava.oa.core.action;

import java.io.InputStream;
import java.net.URLDecoder;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 公用的文件下载控制器
 */
public class DownLoadAction extends ActionSupport {

	private static final long serialVersionUID = 3829746686631048329L;
	/** 文件下载 */
	private String downFileName;
	/** 文件的URL */
	private String fileUrl;
	/** 文件名 */
	private String fileName;
	
	/** stream的类型 inputName属性 */
	public InputStream getFileStream() throws Exception{
		InputStream inputStream = ServletActionContext.getServletContext().getResourceAsStream(fileUrl);
		// tomcat7
		// fileName = new String(fileName.getBytes("iso8859-1"), "utf-8");
		
		// 响应的过程：utf-8 --> iso8859-1 --> utf-8 (firefox、chrome、opera)
		// 响应的过程：utf-8 --> gbk --> iso8859-1 --> gbk (msie、firefox、chrome、opera)
		// utf-8 --> gbk
		fileName = URLDecoder.decode(fileName, "gbk");
		fileName = new String(fileName.getBytes("gbk"), "iso8859-1");
		downFileName =  fileName + "." + FilenameUtils.getExtension(fileUrl);
		return inputStream;
	}

	/** setter and getter method */
	public String getDownFileName() {
		return downFileName;
	}
	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
