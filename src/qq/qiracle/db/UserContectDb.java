//======================================================================
 //
 //        Copyright (C) 2016   
 //        All rights reserved
 //
 //        filename :MainView
 //        
 //
 //        created by Qiangqiang Jinag in  2016.08.23
 //        https://github.com/qiracle
 //		   qiracle@foxmail.com
 //
//======================================================================
package qq.qiracle.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import qq.qiracle.utils.DbUtil;
import qq.qiracle.utils.JdbcUtil;

public class UserContectDb {
	public  DbUtil dbutil = new DbUtil();
	public Connection conn = dbutil.getConn();
	public PreparedStatement ps = null;
	
	public boolean login(String name,String pwd){
		
		
		String sql ="select * from user where name=? and pwd=?";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, pwd);
			
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				System.out.println("登录成功");
				return true;
				
			}else{
				System.out.println("用户名或密码错误");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
		
		
		
	}
	
	public int addUser(String name,String pwd){
		String sql="insert into user values(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
		return ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
		
	}
	

}
