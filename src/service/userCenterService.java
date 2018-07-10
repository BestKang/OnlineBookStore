package service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import dao.DbMethod;
import db.RootPath;
import bean.userCenter;

public class userCenterService {
	private  DbMethod db;
	public DbMethod getDb() {
		return db;
	}
	public void setDb(DbMethod db) {
		this.db = db;
	}
	public userCenterService(){
		this.db=new DbMethod();
	}
	public boolean uploadUserPic(userCenter uc){
		System.out.println("头像图片类型:"+uc.getUserPicContentType());
		System.out.println("头像图片名称:"+uc.getUserPicFileName());
		String temp=new RootPath().getRootPath();
		System.out.println("img文件夹路径:"+temp+"img\\");
		String filePath=temp+"img\\"+uc.getUserPicFileName();
		File saveFile=new File(filePath);
		try {
			FileUtils.copyFile(uc.getUserPic(), saveFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean updateUserInfo(userCenter uc){
		if(!this.uploadUserPic(uc))
			return false;
		List<String> attr=new ArrayList<String>();
		List<String> value=new ArrayList<String>();
		attr.add("UserPassword");
		attr.add("UserAddress");
		attr.add("UserPhone");
		attr.add("UserPictureUrl");
		attr.add("UserName");
		value.add(uc.getUpdateUserPassword());
		value.add(uc.getUpdateUserAddress());
		value.add(uc.getUpdateUserPhone());
		value.add(uc.getUserPicFileName());
		value.add(uc.getUpdateUserName());
		if(!db.update("user", attr, value, "where userAccount='"+uc.getUserAccount()+"'"))
			return false;
		return true;
	}

}
