package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Obook;
import bean.Pbook;
import service.operatebookservice;

public class operatebookserviceTest {

	@Test
	public void test() {
		//Pbook pbook=new Pbook();
		//pbook.setIdPbook("1");
		Pbook pbook=new Pbook();
		//pb.setIdPbook("");
		/*pb.setIdPbook("102");
		pb.setPbookAbstract("这很好看");
		pb.setPbookClickTimes(0);
		pb.setPbookName("测试修改的名字6666");
		pb.setPbookPictureUrl("呵呵呵呵");
		pb.setPbookPrice(20);
		pb.setPbookPublisher("你大爷");
		pb.setPbookPublishTime("没有穿");
		pb.setPbookSoldNumber(0);
		pb.setPbookStockNumber(100);
		pb.setPbookWriter("大仙"); */
		
		
		Obook pb=new Obook();
		//pb.setIdPbook("");
		pb.setIdobook("7");
		pb.setObookAbstract("这很好看");
		pb.setObookClickTimes(0);
		pb.setObookName("gaygay的");
		pb.setObookPictureUrl("呵呵呵呵");
		pb.setObookPrice(20);
		pb.setObookPublisher("你大爷");
		pb.setObookPublishTime("没有穿");
		pb.setObookSoldNumber(0);
		pb.setObookStockNumber(100);
		pb.setObookWriter("大仙");
		pb.setObookUpTime("JINTIAN");;
		operatebookservice operatebookservice=new operatebookservice();
		pb=operatebookservice.searchObook("7");
		System.out.println(pb.getObookName());
	}

}
