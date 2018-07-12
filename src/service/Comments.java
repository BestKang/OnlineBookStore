package service;

import java.util.ArrayList;
import java.util.Map;

import bean.Comment;
import dao.DbMethod;

public class Comments {
	private DbMethod dm;
	public DbMethod getDm() {
		return dm;
	}
	public void setDm(DbMethod dm) {
		this.dm = dm;
	}
	public Comments(){
		dm=new DbMethod();
	}
	public boolean writeComments(Comment comm){
		if(dm.writeComments(comm))
			return true;
		return false;
	}
	public ArrayList<Comment> getComments(Comment comm){
		ArrayList<Comment> comms=dm.searchComments(comm);
		return comms;
	}

}
