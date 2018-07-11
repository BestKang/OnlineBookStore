package action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import service.Comments;

import bean.Comment;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class showCommentsAction extends ActionSupport implements ModelDriven<Comment>{
	private Comment comm;
	ArrayList<Comment> dataMap;
	public showCommentsAction(){
		this.comm=new Comment();
		this.dataMap=new ArrayList<Comment>();
	}
	public ArrayList<Comment> getDataMap() {
		return dataMap;
	}
	public void setDataMap(ArrayList<Comment> dataMap) {
		this.dataMap = dataMap;
	}
	public Comment getComm() {
		return comm;
	}
	public void setComm(Comment comm) {
		this.comm = comm;
	}
	@Override
	public Comment getModel() {
		// TODO Auto-generated method stub
		return this.comm;
	}
	public String showComments(){
		System.out.println("已响应前端查询书籍所有评论请求。。。bookId为:"+comm.getIdbook()+" booktype为:"+comm.getBooktype());
		Comments comms=new Comments();
		dataMap=comms.getComments(this.comm);
		return SUCCESS;
	}
}
