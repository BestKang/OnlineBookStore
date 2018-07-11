package action;

import java.util.HashMap;
import java.util.Map;

import bean.ClientTime;
import bean.TestTxt;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class upLoadEbookAction extends ActionSupport implements ModelDriven<TestTxt>{
	private TestTxt txt=new TestTxt();
	Map<String,Object> dataMap=new HashMap<String, Object>();
	public TestTxt getTxt() {
		return txt;
	}
	public void setTxt(TestTxt txt) {
		this.txt = txt;
	}
	@Override
	public TestTxt getModel() {
		// TODO Auto-generated method stub
		return this.txt;
	}
	public String upLoadBook(){
		return SUCCESS;
	}

}
