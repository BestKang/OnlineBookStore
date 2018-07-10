package test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import bean.Pbook;
import bean.bookorders;
import bean.user;
import dao.DbMethod;
import service.BookOrdersService;

public class BookOrdersServiceTest {

	@Test
	public void test() {
		user newUserBean=new user();
		
		DbMethod dbMethod= new DbMethod();
		Pbook pb=new Pbook();
		user user=new user();
		user.setIdUser("2");
		int number;
		String rcname;
		
		pb.setIdPbook("1");
		pb.setPbookAbstract("888");
		pb.setPbookClickTimes(5);
		pb.setPbookName("昆虫记");
		pb.setPbookPictureUrl("hdiahsdiuash");
		pb.setPbookPrice(21);
		pb.setPbookWriter("大帅比");
		pb.setPbookPublisher("小帅比");
		Date ss = new Date();
		//1	昆虫记	大帅比	小帅比	2018-07-04	666	666	777	888	昆虫记的路径	0
        //System.out.println("一般日期输出：" + ss);
        //System.out.println("时间戳：" + ss.getTime());
        //Date aw = Calendar.getInstance().getTime();//获得时间的另一种方式，测试效果一样
		
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String finishTime = format0.format(ss.getTime());//这个就是把时间戳经过处理得到期望格式的时间
		pb.setPbookPublishTime(finishTime);
		pb.setPbookSoldNumber(500);
		pb.setPbookStockNumber(400);
		//pb.setPbookWriter("xiaoming");		
		
		//bookorders bookorders=new bookorders();
		//newUserBean.setIdUser("1");
		
		BookOrdersService bookOrdersService= new BookOrdersService();
		//System.out.println(111);
		//bookOrdersService.getorderlist(newUserBean);
		
		long startTime=System.nanoTime();   //获取开始时间  
		
		//bookOrdersService.getOrderList(newUserBean);
		//doSomeThing(); //测试的代码段  
		
		bookOrdersService.insertpbookorder(pb, user, 300, "许启强");
		
		long endTime=System.nanoTime(); //获取结束时间  

		System.out.println("程序运行时间： "+(endTime-startTime)+"ns"); 
		
		System.out.println(newUserBean.getClass());
	}

}
