package com.ssp.bean;

import java.util.List;

public class Page<T> { 
	public static final Integer PAGE_SIZE = 3; 
	// 当前页码 
	private Integer pageNo = 1; 
	// 总页码 
	private Integer pageTotal; 
	// 当前页显示数量 
	private Integer pageSize = PAGE_SIZE; 
	// 总记录数 
	private Integer pageTotalCount; 
	// 当前页数据 
	private List<T> items;
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageTotal=" + pageTotal + ", pageSize=" + pageSize + ", pageTotalCount="
				+ pageTotalCount + ", items=" + items + "]";
	}
	public Page() {
		super();
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(Integer pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	
	
}