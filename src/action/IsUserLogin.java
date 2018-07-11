package action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import bean.ClientTime;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import db.MySession;
import db.Request;

/*
 * 用于前端每个页面初始化加载时判断是否用户已登录，若登录则显示跟用户相关的信息，比如购物车页面，订单查询等页面需判断用户是否登录，只有登录状态才能访问本页面
 */
public class IsUserLogin extends ActionSupport  implements ModelDriven<ClientTime>{
	Map<String,Object> userInfo;
	private ClientTime time;
	public ClientTime getTime() {
		return time;
	}
	public void setTime(ClientTime time) {
		this.time = time;
	}
	public Map<String, Object> getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Map<String, Object> userInfo) {
		this.userInfo = userInfo;
	}
	public IsUserLogin(){
		this.userInfo=new HashMap<String, Object>();
		this.time=new ClientTime();
	}
	public String isUserLoginRs(){
		System.out.println("已响应前端查询是否登录请求,请求时间:"+this.time.getT());
		HttpSession ses=MySession.getSession();
		System.out.println(ses.getAttribute("idUser"));
		if(ses.getAttribute("idUser")!=null)
		{
			userInfo.put("idUser",ses.getAttribute("idUser") );
			userInfo.put("userName", ses.getAttribute("userName"));
			userInfo.put("result", "已登录");
			System.out.println("用户是否登录："+userInfo.get("result"));
			System.out.println("用户Id:"+userInfo.get("idUser"));
			System.out.println("用户名:"+userInfo.get("userName"));
			return SUCCESS;
		}
		userInfo.put("result","未登录");
		System.out.println("22222"+ses.getAttribute("idUser"));
		System.out.println("用户是否登录："+userInfo.get("result"));
		return SUCCESS;
	}
	@Override
	public ClientTime getModel() {
		// TODO Auto-generated method stub
		return this.time;
	}
}
