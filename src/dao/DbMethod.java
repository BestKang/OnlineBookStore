package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.connDB;
import bean.Ebook;
import bean.Obook;
import bean.Pbook;
import bean.user;
import bean.UserBean;

public class DbMethod {
	private Connection conn;
	public DbMethod(){
		conn=connDB.getConnection();
	}
	public ArrayList<Map<String,Object>> search(String sql,int attrNum,String... names ) {//String... argsΪ为不定长参数，即有多少个参数不确定,attrNum为查询语句中属性个数
		// TODO Auto-generated method stub
		ResultSet rs = null;
		ArrayList<Map<String,Object>> objArrayL=new ArrayList<Map<String,Object>>();
		Statement ps=null;
		System.out.println("查询语句:"+sql);
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
		while(rs.next()){
			Map<String,Object> MapObj=new HashMap<String,Object>();
			int count=0;
			int count1=0;
			while(count<attrNum)
			MapObj.put(names[count1++], rs.getObject(names[count++]).toString());
			objArrayL.add(MapObj);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearch Fail--[sqlException]:"+" "+e.getMessage()+"\n");
		}finally{
			connDB.frees( ps, rs);
		}
		for(int i=0;i<objArrayL.size();i++){
			for(int j=0;j<objArrayL.get(i).size();j++){
				System.out.println(names[j]+":"+objArrayL.get(i).get(names[j]).toString()+"   ");
			}
			System.out.print("\n");
		}
			return objArrayL;
		}
	public ArrayList<Pbook> searchPbook(){
			ArrayList<Pbook> objArrayL=new ArrayList<Pbook>();
			ResultSet rs = null;
			Statement ps=null;
			String sql="select * from pbook ";
			System.out.println("searchPook查询语句:"+sql);
			try{
				ps = conn.createStatement();
			 rs=ps.executeQuery(sql);
			while(rs.next()){
				Pbook pb=new Pbook();
				pb.setIdPbook(rs.getString("idPbook"));
				pb.setPbookAbstract(rs.getString("PbookAbstract"));
				pb.setPbookClickTimes(rs.getInt("PbookClickTimes"));
				pb.setPbookName(rs.getString("PbookName"));
				pb.setPbookPictureUrl(rs.getString("PbookPictureUrl"));
				pb.setPbookPrice(rs.getDouble("PbookPrice"));
				pb.setPbookPublisher(rs.getString("PbookPublisher"));
				pb.setPbookPublishTime(rs.getString("PbookPublishTime"));
				pb.setPbookSoldNumber(rs.getInt("PbookSoldNumber"));
				pb.setPbookStockNumber(rs.getInt("PbookStockNumber"));
				pb.setPbookWriter(rs.getString("PbookWriter"));
				objArrayL.add(pb);
			}
			}catch(SQLException e){
				e.printStackTrace();
				System.out.println("\nsearch pbook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
				
			}finally{
				connDB.frees( ps, rs);
			}	
			
			return objArrayL;
	}
	public ArrayList<Ebook> searchebook(){
		ArrayList<Ebook> objArrayL=new ArrayList<Ebook>();
		ResultSet rs = null;
		Statement ps=null;
		String sql="select * from ebook ";
		System.out.println("searcheook查询语句:"+sql);
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
		while(rs.next()){
			Ebook pb=new Ebook();
			pb.setIdebook(rs.getString("idebook"));
			pb.setEbookAbstract(rs.getString("ebookAbstract"));
			pb.setEbookClickTimes(rs.getInt("ebookClickTimes"));
			pb.setEbookPictureUrl(rs.getString("ebookPictureUrl"));
			pb.setEbookPrice(rs.getDouble("ebookPrice"));
			pb.setEbookSoldNumber(rs.getInt("ebookSoldNumber"));
			pb.setEbookWriter(rs.getString("ebookWriter"));
			pb.setEbookNameS(rs.getString("ebookName"));
			objArrayL.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearchebook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		return objArrayL;
}
	public ArrayList<Obook> searchobook(){
		ArrayList<Obook> objArrayL=new ArrayList<Obook>();
		ResultSet rs = null;
		Statement ps=null;
		String sql="select * from obook ";
		System.out.println("searchObook查询语句:"+sql);
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
		while(rs.next()){
			Obook pb=new Obook();
			pb.setIdobook(rs.getString("idobook"));
			pb.setObookAbstract(rs.getString("obookAbstract"));
			pb.setObookClickTimes(rs.getInt("obookClickTimes"));
			pb.setObookName(rs.getString("obookName"));
			pb.setObookPictureUrl(rs.getString("obookPictureUrl"));
			pb.setObookPrice(rs.getDouble("obookPrice"));
			pb.setObookPublisher(rs.getString("obookPublisher"));
			pb.setObookPublishTime(rs.getString("obookPublishTime"));
			pb.setObookSoldNumber(rs.getInt("obookSoldNumber"));
			pb.setObookStockNumber(rs.getInt("obookStockNumber"));
			pb.setObookWriter(rs.getString("obookWriter"));
			objArrayL.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearchobook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		return objArrayL;
}
	public ArrayList<Pbook> searchTopList() {
		ArrayList<Pbook> topList=new ArrayList<Pbook>();
		ResultSet rs = null;
		Statement ps=null;
		String sql="select * from pbook order by PbookSoldNumber desc limit 0,2";
		System.out.println("searchPook查询语句:"+sql);
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
		while(rs.next()){
			Pbook pb=new Pbook();
			pb.setIdPbook(rs.getString("idPbook"));
			pb.setPbookAbstract(rs.getString("PbookAbstract"));
			pb.setPbookClickTimes(rs.getInt("PbookClickTimes"));
			pb.setPbookName(rs.getString("PbookName"));
			pb.setPbookPictureUrl(rs.getString("PbookPictureUrl"));
			pb.setPbookPrice(rs.getDouble("PbookPrice"));
			pb.setPbookPublisher(rs.getString("PbookPublisher"));
			pb.setPbookPublishTime(rs.getString("PbookPublishTime"));
			pb.setPbookSoldNumber(rs.getInt("PbookSoldNumber"));
			pb.setPbookStockNumber(rs.getInt("PbookStockNumber"));
			pb.setPbookWriter(rs.getString("PbookWriter"));
			topList.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearch pbook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		return topList;

		// TODO Auto-generated method stub
	}
	public Pbook searchPbookUrl(String idPbook){
		//ArrayList<Pbook> objArrayL=new ArrayList<Pbook>();
		ResultSet rs = null;
		Statement ps=null;
		Pbook pb=new Pbook();
		String sql="select * from pbook where idPbook="+idPbook+"";
		System.out.println("searchPook查询语句:"+sql);
		try{
			ps = conn.createStatement();			
		 rs=ps.executeQuery(sql);
		while(rs.next()){
			
			pb.setIdPbook(rs.getString("idPbook"));
			pb.setPbookAbstract(rs.getString("PbookAbstract"));
			pb.setPbookClickTimes(rs.getInt("PbookClickTimes"));
			pb.setPbookName(rs.getString("PbookName"));
			pb.setPbookPictureUrl(rs.getString("PbookPictureUrl"));
			pb.setPbookPrice(rs.getDouble("PbookPrice"));
			pb.setPbookPublisher(rs.getString("PbookPublisher"));
			pb.setPbookPublishTime(rs.getString("PbookPublishTime"));
			pb.setPbookSoldNumber(rs.getInt("PbookSoldNumber"));
			pb.setPbookStockNumber(rs.getInt("PbookStockNumber"));
			pb.setPbookWriter(rs.getString("PbookWriter"));
			//objArrayL.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearch pbook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		
		return pb;
}	
	public Obook searchObookUrl(String idobook){
		//ArrayList<Pbook> objArrayL=new ArrayList<Pbook>();
		ResultSet rs = null;
		Statement ps=null;
		Obook pb=new Obook();
		String sql="select * from obook where idobook="+idobook+"";
		System.out.println("searchPook查询语句:"+sql);
		try{
			ps = conn.createStatement();			
		 rs=ps.executeQuery(sql);
		 if (!rs.next()) {
			return null;
		}
		 rs.previous();
		while(rs.next()){
			pb.setIdobook(rs.getString("idobook"));
			pb.setObookAbstract(rs.getString("obookAbstract"));
			pb.setObookClickTimes(rs.getInt("obookClickTimes"));
			pb.setObookName(rs.getString("obookName"));
			pb.setObookPictureUrl(rs.getString("obookPictureUrl"));
			pb.setObookPrice(rs.getDouble("obookPrice"));
			pb.setObookPublisher(rs.getString("obookPublisher"));
			pb.setObookPublishTime(rs.getString("obookPublishTime"));
			pb.setObookSoldNumber(rs.getInt("obookSoldNumber"));
			pb.setObookStockNumber(rs.getInt("obookStockNumber"));
			pb.setObookWriter(rs.getString("obookWriter"));
			//objArrayL.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearch pbook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		if (pb==null) {
			System.out.println("zheshikongde");
		}
		return pb;
}
	public Pbook searchPbook(String idPbook){
		//ArrayList<Pbook> objArrayL=new ArrayList<Pbook>();
		ResultSet rs = null;
		Statement ps=null;
		String sql="select * from pbook where idPbook="+idPbook;
		System.out.println("searchPook查询语句:"+sql);
		Pbook pb=new Pbook();
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
		while(rs.next()){			
			pb.setIdPbook(rs.getString("idPbook"));
			pb.setPbookAbstract(rs.getString("PbookAbstract"));
			pb.setPbookClickTimes(rs.getInt("PbookClickTimes"));
			pb.setPbookName(rs.getString("PbookName"));
			pb.setPbookPictureUrl(rs.getString("PbookPictureUrl"));
			pb.setPbookPrice(rs.getDouble("PbookPrice"));
			pb.setPbookPublisher(rs.getString("PbookPublisher"));
			pb.setPbookPublishTime(rs.getString("PbookPublishTime"));
			pb.setPbookSoldNumber(rs.getInt("PbookSoldNumber"));
			pb.setPbookStockNumber(rs.getInt("PbookStockNumber"));
			pb.setPbookWriter(rs.getString("PbookWriter"));
			//objArrayL.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearch pbook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		
		return pb;
}
	public Obook searchObook(String idPbook){
		//ArrayList<Pbook> objArrayL=new ArrayList<Pbook>();
		ResultSet rs = null;
		Statement ps=null;
		String sql="select * from obook where idobook="+idPbook;
		System.out.println("searchPook查询语句:"+sql);
		Obook pb=new Obook();
		try{
			ps = conn.createStatement();
		 rs=ps.executeQuery(sql);
		while(rs.next()){			
			pb.setIdobook(rs.getString("idobook"));
			pb.setObookAbstract(rs.getString("obookAbstract"));
			pb.setObookClickTimes(rs.getInt("obookClickTimes"));
			pb.setObookName(rs.getString("obookName"));
			pb.setObookPictureUrl(rs.getString("obookPictureUrl"));
			pb.setObookPrice(rs.getDouble("obookPrice"));
			pb.setObookPublisher(rs.getString("obookPublisher"));
			pb.setObookPublishTime(rs.getString("obookPublishTime"));
			pb.setObookSoldNumber(rs.getInt("obookSoldNumber"));
			pb.setObookStockNumber(rs.getInt("obookStockNumber"));
			pb.setObookWriter(rs.getString("obookWriter"));
			pb.setObookUpTime(rs.getString("obookUpTime"));
			//objArrayL.add(pb);
		}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("\nsearch pbook Fail--[sqlException]:"+" "+e.getMessage()+"\n");
			
		}finally{
			connDB.frees( ps, rs);
		}	
		
		return pb;
}

	public  boolean insert(String sql, Object... args) {
		PreparedStatement ps = null;
		try {
			conn = connDB.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			if(ps.executeUpdate()==1)
				return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[insertsqlException]:"+" "+e.getMessage()+"\n");
			return false;
		}finally {
			connDB.frees( ps, null);
		}
		return false;

	}
	public  boolean update(String sql) {
		PreparedStatement ps = null;
		System.out.println(sql);
		try {
			ps = conn.prepareStatement(sql);
//			for (int i = 0; i < args.length; i++) {
//				ps.setObject(i + 1, args[i]);
//			}
			if(ps.executeUpdate()==1)
				return true;	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[updatesqlException]:"+" "+e.getMessage()+"\n");
			return false;
		}finally {
			connDB.frees( ps, null);
		}
		return false;

	}
	public boolean update(String TableName,List attr,List value,String ConditionClause){
		boolean flag=false;
		String sql="update "+TableName+" set ";
		if(attr.size()!=value.size())
		{
			System.out.println("Exception:属性个数和值的个数不一致");
			return false;
		}
		for(int i=0;i<attr.size();i++)
			sql+=attr.get(i).toString()+" ='"+value.get(i).toString()+"', ";
		
		String sql1=sql.substring(0, sql.length()-2);
		String sql2=sql1+" "+ConditionClause;
		System.out.println("四参数update语句:"+sql2);
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql2);
//			for (int i = 0; i < args.length; i++) {
//				ps.setObject(i + 1, args[i]);
//			}
			if(ps.executeUpdate()==1)
				flag=true;	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[updatesqlException]:"+" "+e.getMessage()+"\n");
		}finally {
			connDB.frees( ps, null);
		}
		if(flag)
			return true;
		return false;
	}

	public boolean update(String TableName,List attr,List value){
		boolean flag=false;
		String sql="update "+TableName+" set ";
		if(attr.size()!=value.size())
		{
			System.out.println("Exception:属性个数和值的个数不一致");
			return false;
		}
		for(int i=0;i<attr.size();i++){
			sql+=attr.get(i).toString()+" ='"+value.get(i).toString()+"', ";
		}
		String sql1=sql.substring(0, sql.length()-2);
		System.out.println("三参数update语句:"+sql1);
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql1);
//			for (int i = 0; i < args.length; i++) {
//				ps.setObject(i + 1, args[i]);
//			}
			if(ps.executeUpdate()==1)
				flag=true;	
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("\n[updatesqlException]:"+" "+e.getMessage()+"\n");
		}finally {
			connDB.frees( ps, null);
		}
		if(flag)
			return true;
		return false;
	}
	public void closeConn() {
		try {
			if(!this.conn.isClosed()){
				this.conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
