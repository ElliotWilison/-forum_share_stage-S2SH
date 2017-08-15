package com.frank.page;

public class PageUtil {
	
	public static Page getPage(int everyPage,int totalCount,int currentPage)
	{
		everyPage=getEveryPage(everyPage);
		currentPage=getCurrentPage(currentPage);
		int totalPage=getTotalPage(totalCount, everyPage);
		int beginIndex=getBeginIndex(everyPage, currentPage);
		boolean hasNextPage=getHasNextPage(totalPage, currentPage);
		boolean hasPrePage=getHasPrePage(currentPage);
		return new Page(totalCount,currentPage,totalPage,everyPage,hasNextPage,hasPrePage,beginIndex);
	}

	public static int getEveryPage(int everyPage)
	{
		return everyPage==0? 10:everyPage;
	}
	public static int getCurrentPage(int currentPage)
	{
		return currentPage==0? 1:currentPage;
	}
	
	public static int getBeginIndex(int everyPage,int currentPage)
	{
		return everyPage*(currentPage-1);
		
	}
	public static int getTotalPage(int totalCount,int everyPage)
	{
		int totalPage=0;
		if(totalCount%everyPage==0)
			totalPage=totalCount/everyPage;
		else
			totalPage=(totalCount/everyPage)+1;
		return totalPage;
	}
	
	public static boolean getHasNextPage(int totalPage,int currentPage)
	{
		return currentPage==totalPage||totalPage==0 ? false:true;
		
	}
	public static boolean getHasPrePage(int currentPage)
	{
		return currentPage==1? false:true;
	}
	
}
