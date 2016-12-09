
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
import java.util.ArrayList;
import java.util.List;

import qq.qiracle.MainView;
import qq.qiracle.pojo.Employee;
import qq.qiracle.utils.DbUtil;
import qq.qiracle.utils.JdbcUtil;

public class EmployeeContectDb {
	public DbUtil dbutil = new DbUtil();
	public Connection conn = dbutil.getConn();
	public PreparedStatement ps = null;

	public int insert(String id, String name, String age, String sex, String postion, String jobdate, String salary) {
		String sql = "insert into employee values(?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, age);
			ps.setString(4, sex);
			ps.setString(5, postion);
			ps.setString(6, jobdate);
			ps.setString(7, salary);
			return ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	public Employee beforeDelete(String id) {

		String sql = "select *from employee where id =?";
		try {
			Employee emp = null;
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			System.out.println("****");
			while (rs.next()) {
				String eid = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String sex = rs.getString("sex");
				String position = rs.getString("position");
				String jobdate = rs.getString("jobdate");
				String salary = rs.getString("salary");

				System.out.println(eid + "===" + name);
				emp = new Employee(eid, name, age, sex, position, jobdate, salary);

			}

			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public int delete(String id) {
		String sql = "delete from employee where id=?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public Employee setUpdate(String id) {
		String sql = "select *from employee where id =?";
		try {
			Employee emp = null;
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String eid = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String sex = rs.getString("sex");
				String position = rs.getString("position");
				String jobdate = rs.getString("jobdate");
				String salary = rs.getString("salary");

				emp = new Employee(eid, name, age, sex, position, jobdate, salary);

			}

			return emp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public int update(String oldid, String id, String name, String age, String sex, String postion, String jobdate,
			String salary) {
		String sql = "update employee set id=?,name=?,age=?,sex=?,position=?,jobdate=?" + ",salary=?  where id =?";

		// update employee set id=?,name=?,sex=?,age=?,position=?,jobdate =?
		// where id =?
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, age);
			ps.setString(4, sex);
			ps.setString(5, postion);
			ps.setString(6, jobdate);
			ps.setString(7, salary);
			ps.setString(8, oldid);

			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public List<Employee> queryAll() {
		List<Employee> list = new ArrayList<Employee>();
		String sql = "select * from employee";

		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String sex = rs.getString("sex");
				String position = rs.getString("position");
				String jobdate = rs.getString("jobdate");
				String salary = rs.getString("salary");
				Employee emp = new Employee(id, name, age, sex, position, jobdate, salary);
				list.add(emp);
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List<Employee> querybyId(String id) {

		List<Employee> list = new ArrayList<Employee>();
		String sql = "select * from employee ";

		try {
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String findid = rs.getString("id");

				if (findid.indexOf(id) != -1) {
					String name = rs.getString("name");
					String age = rs.getString("age");
					String sex = rs.getString("sex");
					String position = rs.getString("position");
					String jobdate = rs.getString("jobdate");
					String salary = rs.getString("salary");
					Employee emp = new Employee(findid, name, age, sex, position, jobdate, salary);
					list.add(emp);
				}
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public List<Employee> querybysex(String sex) {

		List<Employee> list = new ArrayList<Employee>();
		String sql = "select * from employee ";

		try {
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String ssex = rs.getString("sex");
				if (ssex.equals(sex)) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					String age = rs.getString("age");

					String position = rs.getString("position");
					String jobdate = rs.getString("jobdate");
					String salary = rs.getString("salary");
					Employee emp = new Employee(id, name, age, sex, position, jobdate, salary);
					list.add(emp);
				}
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
