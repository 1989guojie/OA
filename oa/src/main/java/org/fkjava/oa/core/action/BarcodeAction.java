package org.fkjava.oa.core.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 二维码生成
 */
public class BarcodeAction extends ActionSupport {
	
	private static final long serialVersionUID = 8083984790410571502L;
	
	public   final static int WIDTH = 300;
	public   final  static int HEIGHT = 300;

	/**
	 * 定义生成在二维码中的URI
	 */
	private String uri;
	
	@Override
	public String execute() throws Exception {
		
		// 设置相应的内容类型
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("images/jpeg");
		
		if (StringUtils.isEmpty(uri)) {
			uri = "http//www.baidu.com";
		}
		
		// 创建二维码字节转换对象
		Map<EncodeHintType, String> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		
		BitMatrix matrix = new MultiFormatWriter().encode(uri, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
		
		// 输出二维码图片
		MatrixToImageWriter.writeToStream(matrix, "jpeg", response.getOutputStream());
		
		return NONE;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
