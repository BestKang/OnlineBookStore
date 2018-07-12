package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import service.BookOrdersService;
import service.BusketService;

import bean.BusketBean;
import bean.Pbook;
import bean.user;
import db.MySession;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Busket extends ActionSupport implements ModelDriven<BusketBean>{
	Map<String,Object> dataMap=new HashMap<String, Object>();
	private BusketBean bsk=new BusketBean();
	
	Pbook pbook=new Pbook();
	String idPbook;
	String pbookName;
	user user=new user();
	double pbookPrice;
	public Pbook getPbook() {
		return pbook;
	}

	public void setPbook(Pbook pbook) {
		this.pbook = pbook;
	}

	public String getIdPbook() {
		return idPbook;
	}

	public void setIdPbook(String idPbook) {
		this.idPbook = idPbook;
	}

	public String getPbookName() {
		return pbookName;
	}

	public void setPbookName(String pbookName) {
		this.pbookName = pbookName;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public double getPbookPrice() {
		return pbookPrice;
	}

	public void setPbookPrice(double pbookPrice) {
		this.pbookPrice = pbookPrice;
	}

	public String getPbookPictureUrl() {
		return pbookPictureUrl;
	}

	public void setPbookPictureUrl(String pbookPictureUrl) {
		this.pbookPictureUrl = pbookPictureUrl;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRcname() {
		return rcname;
	}

	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	String pbookPictureUrl;
	String idUser;   
	int number;
	String rcname;
	
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
			System.out.println("正在响应结算业务...");   //通过获得购物车中书籍的信息，用户的信息，收货人的信息，购买的数量 完成结算业务
	
			HttpSession ses=MySession.getSession();
			BookOrdersService bookOrdersService=new BookOrdersService();
			if(ses.getAttribute("idUser")!=null){						//获取用户id
				idUser=ses.getAttribute("idUser").toString();
				if(ses.getAttribute("busketList")!=null){						//获取session中存储的书籍信息列表
					ArrayList<Map<String, Object>> arrayList = (ArrayList<Map<String, Object>>)ses.getAttribute("busketList");
					user.setIdUser((String)ses.getAttribute("idUser"));
					Map<String,Object> mapobj=new HashMap<String, Object>();
					for (int i = 0; i < arrayList.size(); i++) {							//循环遍历，购买生成订单
						mapobj=arrayList.get(i);
						if (mapobj.get("bookType").toString().equals("pbook")) {
							pbook.setIdPbook(mapobj.get("bookId").toString());
							number=Integer.valueOf(mapobj.get("num").toString());
							pbook.setPbookName(mapobj.get("PbookName").toString());
							pbook.setPbookPictureUrl(mapobj.get("PbookPictureUrl").toString());
							pbook.setPbookPrice(Double.valueOf(mapobj.get("PbookPrice").toString()));
							user.setIdUser(idUser);	
							user.setUserAddress("随便填的");
							rcname="不知道是谁的收货人";
							if (bookOrdersService.buybuybuy(pbook, user, number, rcname,mapobj.get("bookType").toString())) {
								dataMap.put("shoppingResult:"+i+"", "成功");
								
							}else {
								dataMap.put("shoppingResult"+i+"", "shibai");
							}
							
						}
						if (mapobj.get("bookType").toString().equals("obook")) {
							pbook.setIdPbook(mapobj.get("bookId").toString());
							number=Integer.valueOf(mapobj.get("num").toString());
							pbook.setPbookName(mapobj.get("obookName").toString());
							pbook.setPbookPictureUrl(mapobj.get("obookPictureUrl").toString());
							pbook.setPbookPrice(Double.valueOf(mapobj.get("obookPrice").toString()));
							user.setIdUser(idUser);	
							user.setUserAddress("随便填的");
							rcname="不知道是谁的收货人";
							if (bookOrdersService.buybuybuy(pbook, user, number, rcname,mapobj.get("bookType").toString())) {
								dataMap.put("shoppingResult:"+i+"", "成功");
								
							}else {
								dataMap.put("shoppingResult"+i+"", "shibai");
							}
							
						}
						
					}
				}
			}
			return SUCCESS;
					
			/*if(BS.payAll())
			{
				return SUCCESS;
			}*/
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
