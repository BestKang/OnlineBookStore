package action;

import java.util.HashMap;
import java.util.Map;

import service.BusketService;

import com.opensymphony.xwork2.ActionSupport;

public class getAllMoney extends ActionSupport{
	Map<String,Object> dataMap;

	public getAllMoney() {
		super();
		this.dataMap =new HashMap<String, Object>();
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String getAllMoney(){
		BusketService BS=new BusketService();
		Double AllMoney=BS.getAllMoney();
		if(AllMoney>=0)
		{
			dataMap.put("AllMoney", AllMoney);
			System.out.println("费用总额："+AllMoney);
			return "SUCCESS";
		}
		dataMap.put("AllMoney", "-1");
		System.out.println("费用总额："+AllMoney);
		return "SUCCESS";
	}
	
}
