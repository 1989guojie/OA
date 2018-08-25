package org.fkjava.oa.core.common.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 分页标签库处理类
 */
public class PageTag extends SimpleTagSupport {
	
	// selectNotice.action?pageIndex={0}
	private static final String TAG = "{0}";
	
	/** 当前页码 */
	private int pageIndex;
	/** 每页显示的数量 */
	private int pageSize;
	/** 总记录条数 */
	private int	recordCount;
	/** 样式名 */
	private String style = "sabrosus";
	/** 请求的URL */
	private String submitUrl;
	
	/** 总页数 */
	private int totalPage;

	@Override
	public void doTag() throws JspException, IOException {
		
		StringBuilder res = new StringBuilder();
		StringBuilder str = new StringBuilder();
		/** 判断总记录条数  */
		if (recordCount > 0){
			/** 需要分页(显示分页信息) */
			/** 计算出总页数 */
			this.totalPage = ((this.recordCount - 1) / this.pageSize) + 1;
			/** 控制【上一页】与【下一页】需不需要加a标签 */
			if (pageIndex == 1){ // 首页
				str.append("<span class='disabled'>上一页</span>");
				
				/** 计算中间页码的方法 */
				calcPage(str);
				
				if (pageIndex == totalPage){ // 只有一页
					str.append("<span class='disabled'>下一页</span>");
				}else{
					String tempUrl = this.submitUrl.replace(TAG, String.valueOf(pageIndex + 1));
					str.append("<a href='"+ tempUrl +"'>下一页</a>");
				}
			}else if (pageIndex == totalPage){ // 尾页
				String tempUrl = this.submitUrl.replace(TAG, String.valueOf(pageIndex - 1));
				str.append("<a href='"+ tempUrl +"'>上一页</a>");
				
				/** 计算中间页码的方法 */
				calcPage(str);
				
				str.append("<span class='disabled'>下一页</span>");
			}else{ // 中间
				String tempUrl = this.submitUrl.replace(TAG, String.valueOf(pageIndex - 1));
				str.append("<a href='"+ tempUrl +"'>上一页</a>");
				
				/** 计算中间页码的方法 */
				calcPage(str);
				
				tempUrl = this.submitUrl.replace(TAG, String.valueOf(pageIndex + 1));
				str.append("<a href='"+ tempUrl +"'>下一页</a>");
			}
			/** 计算出开始条数与结束条数 */
			int startNum = (pageIndex - 1) * pageSize + 1;
			int endNum = pageIndex == totalPage ? recordCount : pageIndex * pageSize;
			
			/** 拼最终的结果 */
			res.append("<table width='98%' align='center' style='font-size:13px;' class='"+ style +"'>")
			   .append("<tr><td>")
			   .append(str.toString() + "跳转到<input type='text' size='2' id='pager_jump_num'/>")
			   .append("<input type='button' value='确定' id='pager_jump_btn'/>")
			   .append("</td></tr>")
			   .append("<tr align='center'><td>总共<font color='red'>"+ this.recordCount +"</font>条记录，当前显示"+ startNum +"-"+ endNum +"条记录。</td>")
			   .append("</tr></table>");
			res.append("<script type='text/javascript'>")
			   .append("   document.getElementById('pager_jump_btn').onclick = function(){")
			   .append("      var page_num = document.getElementById('pager_jump_num').value;")
			   .append("      if (!/^\\d+$/.test(page_num) || page_num < 1 || page_num > "+ totalPage +"){")
			   .append("          alert('请输入[1-"+ totalPage +"]之间的页码！')")
			   .append("      }else{")
			   .append("         var submitUrl = '" + submitUrl + "';")
			   .append("         window.location = submitUrl.replace('"+ TAG +"', page_num)")
			   .append("      }")
			   .append("}")
			   .append("</script>");
				
		}else{
			res.append("<table align='center'><tr>")
			   .append("<td>总共<font color='red'>0</font>条记录，当前显示0-0条记录。</td>")
			   .append("</tr></table>");
		}
		this.getJspContext().getOut().print(res.toString());
	}

	/** 计算中间页码的方法 */
	private void calcPage(StringBuilder str) {
		/** 判断总页数 */
		if (totalPage <= 11){
			for (int  i = 1; i <= totalPage; i++){
				/** 判断是不是当前页码 */
				if (pageIndex == i){
					str.append("<span class='current'>"+ i +"</span>");
				}else{
					String tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
					str.append("<a href='"+ tempUrl +"'>"+ i +"</a>");
				}
			}
		}else{
			// 靠首页近些：123456789...100
			if (pageIndex - 8 <= 1){
				for (int i = 1; i <= 10; i++){
					/** 判断是不是当前页码 */
					if (pageIndex == i){
						str.append("<span class='current'>"+ i +"</span>");
					}else{
						String tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
						str.append("<a href='"+ tempUrl +"'>"+ i +"</a>");
					}
				}
				String tempUrl = this.submitUrl.replace(TAG, String.valueOf(totalPage));
				str.append("...")
				   .append("<a href='"+ tempUrl +"'>"+ totalPage +"</a>");
			}
			// 靠尾页近些：1...9293949596979899100
			else if(pageIndex + 8 >= totalPage){
				
				String tempUrl = this.submitUrl.replace(TAG, String.valueOf(1));
				str.append("<a href='"+ tempUrl +"'>1</a>").append("...");
				for (int i = totalPage - 10; i <= totalPage; i++){
					/** 判断是不是当前页码 */
					if (pageIndex == i){
						str.append("<span class='current'>"+ i +"</span>");
					}else{
						tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
						str.append("<a href='"+ tempUrl +"'>"+ i +"</a>");
					}
				}
			}
			// 中间：1...464748495051525354...100
			else{
				String tempUrl = this.submitUrl.replace(TAG, String.valueOf(1));
				str.append("<a href='"+ tempUrl +"'>1</a>").append("...");
				
				for (int i = pageIndex - 4; i <= pageIndex + 4; i++){
					/** 判断是不是当前页码 */
					if (pageIndex == i){
						str.append("<span class='current'>"+ i +"</span>");
					}else{
						tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
						str.append("<a href='"+ tempUrl +"'>"+ i +"</a>");
					}
				}
				
				tempUrl = this.submitUrl.replace(TAG, String.valueOf(totalPage));
				str.append("...").append("<a href='"+ tempUrl +"'>"+ totalPage +"</a>");
			}
		}
	}


	/** setter and getter method */
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		System.out.println("pageSize: " + pageSize);
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getSubmitUrl() {
		return submitUrl;
	}
	public void setSubmitUrl(String submitUrl) {
		this.submitUrl = submitUrl;
	}
}