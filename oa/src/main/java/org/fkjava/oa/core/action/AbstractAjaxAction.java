package org.fkjava.oa.core.action;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 最基础的异步请求控制器
 */
public abstract class AbstractAjaxAction extends ActionSupport {

	private static final long serialVersionUID = 3661718449513857824L;
	
	@Override
	public String execute() throws Exception {
		
		/** 调用子类的方法 */
		String json = this.ajaxTask();
		
		System.out.println("json:" + json);
		
		/** 对响应的文本做GZIP压缩, 为了提高网站的响应速度 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(bos);
		gzip.write(json.getBytes("utf-8"));
		gzip.flush();
		gzip.close();
		
		/** 获取响应对象 */
		HttpServletResponse response = ServletActionContext.getResponse();
		/** 告诉浏览器我们的内容是用GZIP压缩的 */
		response.setHeader("Content-Encoding", "GZIP");
		/** 设置响应的内容的类型与编码 */
		response.setContentType("text/html; charset=utf-8");
		response.getOutputStream().write(bos.toByteArray());
		return NONE;
	}
	
	/** 定义抽像方法，由所有的子类实现(处理请求) */
	protected abstract String ajaxTask() throws Exception;
}
