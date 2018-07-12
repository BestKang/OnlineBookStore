package action;

import com.opensymphony.xwork2.ActionSupport;

public class SearchBarAction extends ActionSupport {
	private String bookName;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public SearchBarAction(){
		this.bookName="";
	}
	public String SearchBar(){
		return "SUCCESS";
	}
	

}
