package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.deploy.model.DDBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import service.BookOrdersService;
import bean.bookListBean;
//import bean.bookListBean;
import bean.bookorders;
import bean.user;
import service.getBookList;

public class bookOrdersAction extends ActionSupport implements ModelDriven<user>{
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	Map<String,Object> map=new HashMap<String, Object>();
	private bookorders bookorders = new bookorders();
	user user;
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	public bookorders getBookorders() {
		return bookorders;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public void setBookorders(bookorders bookorders) {
		this.bookorders = bookorders;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public String getOrder(){
		//getBookList gbl=new getBookList();
		BookOrdersService bookOrdersService = new BookOrdersService();
		List<Map<String,Object>> orderlist=new ArrayList<Map<String,Object>>();
		
		orderlist=bookOrdersService.getOrderList(user);
		
		map.put("order", orderlist);
			System.out.println("EB长度:"+map.get("PBookList"));
		return SUCCESS;
	}
	@Override
	public user getModel() {
		
		// TODO Auto-generated method stub
		return this.user;
	
}
}