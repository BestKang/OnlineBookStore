package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.DbMethod;
import db.MySession;
import bean.BusketBean;

public class BusketService {
	private DbMethod dm;
	public DbMethod getDm() {
		return dm;
	}
	public void setDm(DbMethod dm) {
		this.dm = dm;
	}
	private HttpSession ses;
	public BusketService(){
		this.ses=MySession.getSession();
		this.dm=new DbMethod();
	}
	public HttpSession getSes() {
		return ses;
	}
	public void setSes(HttpSession ses) {
		this.ses = ses;
	}
	public boolean AddToBusket(BusketBean bsk){//添加到购物车
		if(this.ses.getAttribute("idUser")!=null){//检测是否登录
			ArrayList<Map<String,Object>> busketList;
			Map<String,Object> map = new HashMap<String, Object>();
			map=this.getMapInfo(bsk);
			if(map==null)
				return false;
			if(ses.getAttribute("busketList")==null){
				System.out.println("没有购物车,新建购物车后新增...");
				 busketList=new ArrayList<Map<String,Object>>();//购物车物品列表
				 busketList.add(map);
				ses.setAttribute("busketList",busketList);
				ses.setAttribute("AllMoney", 0);
				return true;
			}
			else{
				System.out.println("用户已有购物车，新增物品...");
				busketList=(ArrayList<Map<String,Object>>)ses.getAttribute("busketList");//获取已有的物品列表
				Double OldAllMoney=this.getAllMoney();
			    Double increaseMoney = (double) 0;
			    int number=Integer.parseInt((String) map.get("num"));
			    Double price=(double) 0;
			    if(bsk.getBookType().equals("ebook")){
			    	price=Double.parseDouble((String) map.get("ebookPrice"));
			    }
			    else if(bsk.getBookType().equals("pbook")){
			    	price=Double.parseDouble((String) map.get("PbookPrice"));
			    }
			    else if(bsk.getBookType().equals("obook")){
			    	price=Double.parseDouble((String) map.get("obookPrice"));
			    }
			    else{
			    	System.out.println("addtobusket时发生系统错误:session中存在不属于三种类型书籍的bug");
			    	return false;
			    }
			    increaseMoney=price*number;
			    Double NewAllMoney=OldAllMoney+increaseMoney;//得到新的总费用
				busketList.add(map);
				ses.removeAttribute("busketList");
				ses.setAttribute("busketList", busketList);
				ses.removeAttribute("AllMoney");
				ses.setAttribute("AllMoney", NewAllMoney);
				return true;
			}
		}
		System.out.println("没有检测到用户登录!新增失败");
		return false;
	}
	public boolean removeAllBusket(){//清空所有
		if(this.ses.getAttribute("idUser")!=null){
			if(this.ses.getAttribute("busketList")!=null){
				this.ses.removeAttribute("busketList");
				System.out.println("removeAllBusket执行完毕");
				return true;
			}
			return true;
		}
		System.out.println("没有检测到用户登录!清空购物车失败");
		return false;
	}
	public boolean removeOne(BusketBean bsk){//清除指定一件
		if(this.ses.getAttribute("idUser")!=null){
			ArrayList<Map<String,Object>> busketList;
			if(this.ses.getAttribute("busketList")!=null)
			{
				busketList=(ArrayList<Map<String, Object>>) this.ses.getAttribute("busketList");
				if(busketList.size()==0)
				{
					System.out.println("购物车里没有东西，无法删除");
					return false;
				}
				else {
					boolean isRemove=false;
					for(int i=0;i<busketList.size();i++)
					{
						if(busketList.get(i).get("bookId").equals(bsk.getBookId())&&
						busketList.get(i).get("bookType").equals(bsk.getBookType()))
						{
							busketList.remove(i);
							isRemove=true;
							break;
						}
					}
					if(!isRemove){
						System.out.println("System Error:购物车中存在着session中不存在的书....");
						return false;
					}
					this.ses.removeAttribute("busketList");
					this.ses.setAttribute("busketList", busketList);
					System.out.println("removeOne执行完毕");
					return true;
				}
			}
			else
			{
				System.out.println("用户没有创建购物车，无法删除指定书籍");
				return false;
			}
		}
		System.out.println("没有检测到用户登录!清空购物车中指定书籍失败");
		return false;
	}
	public boolean payAll(){
		return false;
	}
	public Double getAllMoney(){//全部结算
		ArrayList<Map<String,Object>> busketList;
		if(this.ses.getAttribute("idUser")!=null){
			if(this.ses.getAttribute("busketList")==null){
				System.out.println("用户没有购物车，结算失败");
				return (double) -1;
			}
			else {
				busketList=(ArrayList<Map<String, Object>>) this.ses.getAttribute("busketList");
				if(busketList.size()==0){
					System.out.println("用户购物车里没有东西，结算失败");
					return (double) -2;
				}
				else 
				{
					Double AllMoney=(double) 0;
					for(int i=0;i<busketList.size();i++){
						double fee=0;
						if(busketList.get(i).get("bookType").equals("ebook")){
							fee=Double.parseDouble((String) busketList.get(i).get("ebookPrice"))*
									Integer.parseInt((String)busketList.get(i).get("num"));
						}
						else if(busketList.get(i).get("bookType").equals("obook"))
						{
							fee=Double.parseDouble((String) busketList.get(i).get("obookPrice"))*
									Integer.parseInt((String)busketList.get(i).get("num"));
						}
						else if(busketList.get(i).get("bookType").equals("pbook"))
						{
							fee=Double.parseDouble((String) busketList.get(i).get("PbookPrice"))*
									Integer.parseInt((String)busketList.get(i).get("num"));
						}
						else {
							System.out.println("结算时发生系统错误:session中存在不属于三种类型书籍的bug");
							return (double) -3;
						}
						AllMoney+=fee;//获得总费用
					}//循环结束
					System.out.println("总费用："+AllMoney);
					return AllMoney;
				}
			}
		}
		System.out.println("没有检测到用户登录!结算失败");
		return (double) -4;
	}
	public ArrayList<Map<String,Object>> showBusketData(){//显示购物车信息
		ArrayList<Map<String,Object>> busketList;
		if(this.ses.getAttribute("idUser")!=null){
			if(this.ses.getAttribute("busketList")==null){
				System.out.println("showBusketData() 用户还没有购物车...");
				return null;
			}
			busketList=(ArrayList<Map<String, Object>>) this.ses.getAttribute("busketList");
			if(busketList.size()==0){
				System.out.println("showBusketData() 购物车里什么都没有...");
			}
			return busketList;
		} 
		System.out.println("没有检测到用户登录!不能查看购物车");
		return null;
	}
	public Map<String,Object> getMapInfo(BusketBean bsk){
		String sql="";
		String[] names = {"","",""};
		Map<String,Object> map = new HashMap<String, Object>();
		if(bsk.getBookType().equals("ebook")){
			sql="select ebookPrice,ebookName,ebookPictureUrl from ebook where idebook="+Integer.parseInt(bsk.getBookId());
			names[0]="ebookPrice";
			names[1]="ebookName";
			names[2]="ebookPictureUrl";
		}
		else if(bsk.getBookType().equals("pbook"))
		{
			sql="select PbookPrice,PbookName,PbookPictureUrl from pbook where idPbook="+Integer.parseInt(bsk.getBookId());
			names[0]="PbookPrice";
			names[1]="PbookName";
			names[2]="PbookPictureUrl";
		}
		else if(bsk.getBookType().equals("obook"))
		{
			sql="select obookPrice,obookName,obookPictureUrl from obook where idobook="+Integer.parseInt(bsk.getBookId());
			names[0]="obookPrice";
			names[1]="obookName";
			names[2]="obookPictureUrl";
		}
		//此处获取书籍有关信息
		System.out.println("addtobusket sql:"+sql);
		ArrayList<Map<String,Object>> bookInfo=dm.search(sql, 3, names);
		if(bookInfo.size()>0)
		{
			map=bookInfo.get(0);
			map.put("num", bsk.getNum());
			map.put("bookId",bsk.getBookId());
			map.put("bookType", bsk.getBookType());
		}
		else {
			System.out.println("数据库检索不到这本书id，系统错误");
			return null;
		}
		return map;
	}
}
