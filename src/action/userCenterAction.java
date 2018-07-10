package action;

import java.util.HashMap;
import java.util.Map;

import service.userCenterService;

import bean.userCenter;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class userCenterAction extends ActionSupport implements ModelDriven<userCenter> {
	private userCenter uc;
	Map<String,Object> dataMap;
	public userCenterAction(){
		this.uc=new userCenter();
		this.dataMap=new HashMap<String, Object>();
	}
	public userCenter getUc() {
		return uc;
	}

	public void setUc(userCenter uc) {
		this.uc = uc;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	@Override
	public userCenter getModel() {
		// TODO Auto-generated method stub
		return this.uc;
	}
	public String userCenterRs(){
		System.out.println("userCenterRs method start excuting...");
		userCenterService ucs=new userCenterService();
		System.out.println("更改后姓名:"+this.uc.getUpdateUserName());
		if(!ucs.updateUserInfo(uc))
		{
			dataMap.put("result", "更新个人信息失败");
			System.out.println("userCenterRs 更新遇到异常");
			ucs.getDb().closeConn();
			return SUCCESS;
		}
		dataMap.put("result", "更新个人信息成功");
		System.out.println("userCenterRs 更新成功");
		ucs.getDb().closeConn();
		return SUCCESS;
		
	}

}
