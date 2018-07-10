package action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import bean.UpLoadUserPic;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class upLoadUserPicAction extends ActionSupport implements ModelDriven<UpLoadUserPic>{
	UpLoadUserPic picFile;
	Map<String,Object> result=new HashMap<String, Object>();
	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public upLoadUserPicAction(){
		this.picFile=new UpLoadUserPic();
	}
	
	public UpLoadUserPic getPicFile() {
		return picFile;
	}

	public void setPicFile(UpLoadUserPic picFile) {
		this.picFile = picFile;
	}
	public String hh(){
		System.out.println(picFile.getUserPicContentType());
		System.out.println(picFile.getUserPicFileName());
		ActionContext ac = ActionContext.getContext();
		ServletContext sc =(ServletContext)ac.get(ServletActionContext.SERVLET_CONTEXT);
		String rootPath=sc.getContextPath();
		String temp = ServletActionContext.getRequest().getRealPath("/");
		System.out.println("img文件夹路径:"+temp+"img\\");
		String filePath=temp+"img\\"+picFile.getUserPicFileName();
		File saveFile=new File(filePath);
		try {
			FileUtils.copyFile(picFile.getUserPic(), saveFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("result", "上传失败!");
			return SUCCESS;
		}
		result.put("result","上传成功!");
		return SUCCESS;
	}
	@Override
	public UpLoadUserPic getModel() {
		// TODO Auto-generated method stub
		return this.picFile;
	}
	

}
