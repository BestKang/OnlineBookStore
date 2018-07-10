package action;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import bean.Pbook;
import bean.user;
import service.BookOrdersService;

public class shoppingAction extends ActionSupport{
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	Map<String,Object> map=new HashMap<String, Object>();
	Pbook pbook;
	user user;
	int number;
	String rcname;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getRcname() {
		return rcname;
	}
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Pbook getPbook() {
		return pbook;
	}
	public void setPbook(Pbook pbook) {
		this.pbook = pbook;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public String shopping(){
		BookOrdersService bookOrdersService=new BookOrdersService();
		//List<Map<String,Object>> orderlist=new ArrayList<Map<String,Object>>();
		
		
		
		
		if (bookOrdersService.insertpbookorder(pbook, user, number, rcname)) {
			map.put("shoppingResult", "成功");
			return SUCCESS;
		}
		return "fail";
	}
	
}
