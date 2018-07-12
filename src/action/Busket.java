package action;

import java.util.HashMap;
import java.util.Map;

import service.BusketService;

import bean.BusketBean;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Busket extends ActionSupport implements ModelDriven<BusketBean>{
	Map<String,Object> dataMap=new HashMap<String, Object>();
	private BusketBean bsk=new BusketBean();
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	public String busket(){
		System.out.println("已响应前端购物车业务请求。。。bookId为:"+bsk.getBookId()+" bookType为:"+bsk.getBookType()+" option为："+bsk.getOption());
		BusketService BS=new BusketService();
		if(bsk.getOption().equals("add")){
			System.out.println("正在响应添加到购物车业务...");
			if(BS.AddToBusket(bsk))
			{
				dataMap.put("result", "已成功添加到购物车");
				System.out.println("busketResultDataMap:"+dataMap.get("result"));
				return SUCCESS;
			}
			dataMap.put("result", "添加到购物车失败");
			System.out.println("busketResultDataMap:"+dataMap.get("result"));
			return SUCCESS;
		}
		else if(bsk.getOption().equals("removeAll")){
			System.out.println("正在响应清空购物车业务...");
			if(BS.removeAllBusket())
			{
				dataMap.put("result", "清空购物车成功");
				System.out.println("busketResultDataMap:"+dataMap.get("result"));
				return SUCCESS;
			}
			dataMap.put("result", "清空购物车失败");
			System.out.println("busketResultDataMap:"+dataMap.get("result"));
			return SUCCESS;
		}
		else if(bsk.getOption().equals("payAll")){
			System.out.println("正在响应结算业务...");
			if(BS.payAll())
			{
				return SUCCESS;
			}
		}
		else if(bsk.getOption().equals("removeOne")){
			System.out.println("正在响应清除指定一件业务...");
			if(!BS.removeOne(bsk))
			{
				dataMap.put("result", "清空购物车中指定书籍失败");
				System.out.println("busketResultDataMap:"+dataMap.get("result"));
				return SUCCESS;
			}
			dataMap.put("result", "清空购物车中指定书籍成功");
			System.out.println("busketResultDataMap:"+dataMap.get("result"));
			return SUCCESS;
		}
		dataMap.put("result", "error");
		return SUCCESS;
	}

	@Override
	public BusketBean getModel() {
		// TODO Auto-generated method stub
		return this.bsk;
	}

}
