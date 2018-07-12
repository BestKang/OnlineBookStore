package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import service.BusketService;

import com.opensymphony.xwork2.ActionSupport;

public class showBusketInfo extends ActionSupport {
	ArrayList<Map<String,Object>> dataMap=new ArrayList<Map<String,Object>>();
	Map<String,Object> map;
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public ArrayList<Map<String, Object>> getDataMap() {
		return dataMap;
	}
	public void setDataMap(ArrayList<Map<String, Object>> dataMap) {
		this.dataMap = dataMap;
	}
	public String showBusketInfo(){
		BusketService BS=new BusketService();
		dataMap=BS.showBusketData();
		if(dataMap==null){
			map=new HashMap<String, Object>();
			map.put("result", "用户还没有创建购物车");
			return "FAIL";
		}
		return "SUCCESS";
	}

}
