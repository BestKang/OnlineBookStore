package service;

import java.util.ArrayList;
import java.util.Map;

import dao.DbMethod;
import bean.UserBean;

public class LoginService {

	public ArrayList<Map<String,Object>> login(UserBean user) {
		return this.LoginSearch(user);
	}

	private ArrayList<Map<String,Object>> LoginSearch(UserBean user) {
		// TODO Auto-generated method stub
		String userAccount=user.getUserAccount();
		String userPassword=user.getUserPassword();
		System.out.println("用户名:"+userAccount+"\n密码:"+userPassword);
		DbMethod db=new DbMethod();
		ArrayList<Map<String,Object>> arr=db.search("select idUser,userName from user where userAccount='"+userAccount+"' and userPassword='"+userPassword+"'",2,"idUser","userName");
		System.out.println("arraySize:"+arr.size());
		db.closeConn();
		return arr;
	}

}
