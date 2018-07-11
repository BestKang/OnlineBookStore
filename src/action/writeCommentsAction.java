package action;

import java.util.HashMap;
import java.util.Map;

import service.Comments;

import bean.Comment;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class writeCommentsAction extends ActionSupport implements ModelDriven<Comment>{
	private Comment comm;
	Map<String,Object> dataMap;
	public writeCommentsAction(){
		this.comm=new Comment();
		this.dataMap=new HashMap<String, Object>();
	}
	public Comment getComm() {
		return comm;
	}
	public void setComm(Comment comm) {
		this.comm = comm;
	}
	public Map<String, Object> getDataMap() {
		return dataMap;
	}
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
	@Override
	public Comment getModel() {
		// TODO Auto-generated method stub
		return this.comm;
	}
	public String writeComments(){
		System.out.println("已响应前端写评论请求...iduser为:"+comm.getIduser()+"  idbook为:"+comm.getIdbook()+" comment为:"+comm.getComment()+"  commentTime为:"+comm.getCommentTime()+" booktype为:"+comm.getBooktype());
		Comments comms=new Comments();
		if(!comms.writeComments(comm))
		{
			dataMap.put("result", "发表评论失败");
			System.out.println("writeCommentsResult:"+dataMap.get("result"));
			return SUCCESS;
		}
		dataMap.put("result", "发表评论成功");
		System.out.println("writeCommentsResult:"+dataMap.get("result"));
		return SUCCESS;
	}
}

