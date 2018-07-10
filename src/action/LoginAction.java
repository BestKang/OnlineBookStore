package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import service.LoginService;

import bean.UserBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import db.MySession;
import db.Request;

public class LoginAction extends ActionSupport implements ModelDriven<UserBean> {
	private UserBean user=new UserBean();
	private Map<String, Object> dataMap;//编码统一使用utf-8 
	public LoginAction(){
		//dataMap.clear();
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	@Override
	public UserBean getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public String LoginExcute(){
		ArrayList<Map<String,Object>> loginInfo =new LoginService ().login(user);
		if(loginInfo.size()==0)
		{
			dataMap=new HashMap<String, Object>();
			dataMap.put("result", "login fail");
			System.out.println("return login result:"+dataMap.get("result"));
			return SUCCESS;
		}
		HttpSession session=MySession.getSession();
		session.setAttribute("idUser", loginInfo.get(0).get("idUser"));
		session.setAttribute("userName",loginInfo.get(0).get("userName"));
		System.out.println("idUser:"+session.getAttribute("iduser"));
		dataMap=new HashMap<String, Object>();
		dataMap.put("result", "login success");
		System.out.println("return login result:"+dataMap.get("result"));
		return SUCCESS;
	}

}
