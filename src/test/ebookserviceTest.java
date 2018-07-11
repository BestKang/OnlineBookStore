package test;

import static org.junit.Assert.*;

import org.junit.Test;

import bean.Ebook;
import javassist.compiler.ast.NewExpr;
import service.ebookservice;

public class ebookserviceTest {

	@Test
	public void test() {
		Ebook ebook = new Ebook();
		/*ebook.setIdebook("1");
		ebook.setEbookName("斗破苍穹");
		ebook.setEbookAbstract("666");
		ebook.setEbookPrice(10);
		ebook.setEbookWriter("大爷");
		ebook.setEbookSoldNumber(0);
		ebook.setEbookClickTimes(0);
		ebook.setEbookPictureUrl("wangba");
		ebook.setLastUpdateTime("jintian ");
		ebook.setEbookTxtUrl("这里边");*/
		ebookservice ebookservice=new ebookservice();
		ebook=ebookservice.searchEbook("1");
		System.out.println(ebook.getEbookName());
	}

}
