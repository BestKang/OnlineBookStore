package action;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import bean.Pbook;
import bean.user;
import javassist.compiler.ast.NewExpr;
import service.BookOrdersService;

public class shoppingAction extends ActionSupport{
	List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
	Map<String,Object> map=new HashMap<String, Object>();
	Pbook pbook=new Pbook();
	String idPbook;
	String pbookName;
	String pbookWriter;
	String pbookPublisher;
	String pbookPublishTime;
	double pbookPrice;
	int pbookStockNumber;
	int pbookSoldNumber;
	String pbookAbstract;
	String pbookPictureUrl;
	int pbookClickTimes;
	String idUser;
    user user=new user();
	int number;
	String rcname;
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
	public String getPbookWriter() {
		return pbookWriter;
	}
	public void setPbookWriter(String pbookWriter) {
		this.pbookWriter = pbookWriter;
	}
	public String getPbookPublisher() {
		return pbookPublisher;
	}
	public void setPbookPublisher(String pbookPublisher) {
		this.pbookPublisher = pbookPublisher;
	}
	public String getPbookPublishTime() {
		return pbookPublishTime;
	}
	public void setPbookPublishTime(String pbookPublishTime) {
		this.pbookPublishTime = pbookPublishTime;
	}
	public double getPbookPrice() {
		return pbookPrice;
	}
	public void setPbookPrice(double pbookPrice) {
		this.pbookPrice = pbookPrice;
	}
	public int getPbookStockNumber() {
		return pbookStockNumber;
	}
	public void setPbookStockNumber(int pbookStockNumber) {
		this.pbookStockNumber = pbookStockNumber;
	}
	public int getPbookSoldNumber() {
		return pbookSoldNumber;
	}
	public void setPbookSoldNumber(int pbookSoldNumber) {
		this.pbookSoldNumber = pbookSoldNumber;
	}
	public String getPbookAbstract() {
		return pbookAbstract;
	}
	public void setPbookAbstract(String pbookAbstract) {
		this.pbookAbstract = pbookAbstract;
	}
	public String getPbookPictureUrl() {
		return pbookPictureUrl;
	}
	public void setPbookPictureUrl(String pbookPictureUrl) {
		this.pbookPictureUrl = pbookPictureUrl;
	}
	public int getPbookClickTimes() {
		return pbookClickTimes;
	}
	public void setPbookClickTimes(int pbookClickTimes) {
		this.pbookClickTimes = pbookClickTimes;
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
	public List<Map<String, Object>> getData() {
		return data;
	}
	public void setData(List<Map<String, Object>> data) {
		this.data = data;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Pbook getPbook() {
		return pbook;
	}
	public void setPbook(Pbook pbook) {
		this.pbook = pbook;
	}
	public user getUser() {
		return user;
	}
	public void setUser(user user) {
		this.user = user;
	}
	public String shopping(){
		BookOrdersService bookOrdersService=new BookOrdersService();
		//List<Map<String,Object>> orderlist=new ArrayList<Map<String,Object>>();
		System.out.println("recname:"+rcname);
		System.out.println("idPbook:"+idPbook);
		System.out.println("pbookAbstract:"+pbookAbstract);
		System.out.println("pbookClickTimes:"+pbookClickTimes);
		System.out.println("pbookName:"+pbookName);
		System.out.println("pbookPrice:"+pbookPrice);
		System.out.println("pbookPublisher:"+pbookPublisher);
		System.out.println("pbookPublishTime:"+pbookPublishTime);
		System.out.println("pbookPictureUrl:"+pbookPictureUrl);
		System.out.println("pbookSoldNumber:"+pbookSoldNumber);
		System.out.println("pbookStockNumber:"+pbookStockNumber);
		System.out.println("pbookWriter:"+pbookWriter);
		System.out.println("idUser:"+idUser);
		System.out.println("number:"+number);
		pbook.setIdPbook(idPbook);
		pbook.setPbookAbstract(pbookAbstract);
		pbook.setPbookClickTimes(pbookClickTimes);
		pbook.setPbookName(pbookName);
		pbook.setPbookPictureUrl(pbookPictureUrl);
		pbook.setPbookPrice(pbookPrice);
		pbook.setPbookPublisher(pbookPublisher);
		pbook.setPbookPublishTime(pbookPublishTime);
		pbook.setPbookSoldNumber(pbookSoldNumber);
		pbook.setPbookStockNumber(pbookStockNumber);
		pbook.setPbookWriter(pbookWriter);
		user.setIdUser(idUser);				
		if (bookOrdersService.insertpbookorder(pbook, user, number, rcname)) {
			map.put("shoppingResult", "成功");
			return "success";
		}
		map.put("shoppingResult", "shibai");
		return "success";
	}
	
}
