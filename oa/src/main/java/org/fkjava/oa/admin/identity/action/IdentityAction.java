package org.fkjava.oa.admin.identity.action;

import org.fkjava.oa.admin.identity.service.IdentityService;
import org.fkjava.oa.core.common.web.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;

/** 
 * 身份管理控制器
 * 模块级别Action,公共方法 
 */
public class IdentityAction extends ActionSupport {

	private static final long serialVersionUID = 8924267388019164051L;
	
	/** 注入业务对象 */
	@Autowired(required=true)
	@Qualifier("identityService")
	protected IdentityService identityService;
	
	/** 定义分页实体
	 * protected同一包下能访问
	 */
	protected PageModel pageModel = new PageModel();
	
	/** 定义提示消息 */
	private String tip;

	/** 初始化页面，响应数据  */
	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
}
