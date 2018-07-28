package org.fkjava.oa.core.common.web;
/**
 * 分页实体
 */
public class PageModel {
	
	/** 定义每页显示的数量 */
	private static final int PAGE_SIZE = 2;
	
	/** 当前页码 */
	private int pageIndex;
	/** 每页显示的数量 */
	private int pageSize;
	/** 总记录条数 */
	private int	recordCount;
	
	/** setter and getter method */
	public int getPageIndex() {
		this.pageIndex = pageIndex <= 1 ? 1 : pageIndex;
		/** 不能大于总页数 */
		int totalSize = (this.getRecordCount() - 1) / this.getPageSize() + 1;
		return this.pageIndex >= totalSize ? totalSize : this.pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize <= 0 ? PAGE_SIZE : pageSize;
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
	/**  limit 的第一个问号 */
	public int getStartRow(){
		return (this.getPageIndex() - 1) * this.getPageSize();
	}
}