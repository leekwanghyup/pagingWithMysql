package common;

public class Pagination {
	
	public static int PAGE = 10; 
	public static int PER_PAGE =10; 
	
	private int curPage; 
	private int totalCount;
		
	public Pagination(int curPage, int totalCount) {
		this.curPage = curPage;
		this.totalCount = totalCount;
	}
	
	public int getStartPage() {
		return getEndPage()-PAGE + 1; 
	}
	public int getEndPage() {
		int endPage = (int)( Math.ceil(this.curPage/(double)PAGE)*PAGE );
		if( endPage > getPageCnt()) endPage = getPageCnt();
		return   endPage;
	}
	
	public int getPageCnt() {
		return this.totalCount / PER_PAGE + 1; 
	}
}
