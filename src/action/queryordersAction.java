package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.ModelDriven;

import bean.bookListBean;
import bean.user;
import service.BookOrdersService;

public class queryordersAction extends ActionSupport {
	user user = new user();
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	Map<String,Object> map=new HashMap<String, Object>();
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
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
	public String queryorderslist() {
		BookOrdersService bookOrdersService=new BookOrdersService();
		List<Map<String,Object>> orderlist=new ArrayList<Map<String,Object>>();
		
		
		
		
		orderlist=bookOrdersService.getOrderList(user);
		map.put("order", orderlist);
		return SUCCESS;
	}
}
