package db;

import javax.servlet.http.HttpSession;

public class MySession {
	public static HttpSession getSession(){
		HttpSession session=Request.getRequest().getSession();
		return session;	
	}
}
