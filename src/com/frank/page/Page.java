package com.frank.page;

public class Page {

	private int totalCount;
	private int currentPage;
	private int totalPage;
	private int everyPage;
	private boolean hasNextPage;
	private boolean hasPrePage;
	private int beginIndex;
	
	public Page(int totalCount,int currentPage,int totalPage,int everyPage,boolean hasNextPage,boolean hasPrePage,int beginIndex)
	{
		this.totalCount=totalCount;
		this.currentPage=currentPage;
		this.totalPage=totalPage;
		this.everyPage=everyPage;
		this.hasNextPage=hasNextPage;
		this.hasPrePage=hasPrePage;
		this.beginIndex=beginIndex;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getEveryPage() {
		return everyPage;
	}
	public void setEveryPage(int everyPage) {
		this.everyPage = everyPage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public boolean isHasPrePage() {
		return hasPrePage;
	}
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	
}
