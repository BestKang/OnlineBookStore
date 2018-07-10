package db;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class RootPath {
	public static  String getRootPath() {
		ActionContext ac = ActionContext.getContext();
		ServletContext sc =(ServletContext)ac.get(ServletActionContext.SERVLET_CONTEXT);
		String rootPath=sc.getContextPath();
		String temp = ServletActionContext.getRequest().getRealPath("/");
		return temp;
	}
}
