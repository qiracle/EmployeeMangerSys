package qq.qiracle.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtil {
	// 定义数据库驱动
		private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

		// 获取URL
		private static final String URL = "jdbc:mysql://127.0.0.1:3306/emp";

		// 获取用户名
		private static final String USER = "root";

		// 获取密码
		private static final String PASSWORD = "qiracle";

	static {
		try {
			// 初始化JDBC驱动，并让驱动加载到JVM中
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	/*
	 * 获取数据库连接对象
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return conn;
	}

	/*
	 * 更新数据库
	 */
	
	public int update(String sql) {
		Connection conn = getConnection();
		Statement stmt = null;
		int result=0;
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				 result = stmt.executeUpdate(sql);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}else{
			System.out.println("数据库连接失败！");
		}
		close(stmt);
		close(conn);
		return result;
	}

	public List<Map<String, Object>> query(String sql) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		if (conn != null) {
			try {
				//PreparedStatement pstmt = conn.prepareStatement(sql);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				// 获取结果集的列数， 为下面的for循环做准备
				int count = rs.getMetaData().getColumnCount();

				while (rs.next()) {
					// 创建map，将我们每一行的值以键值对的形式（列-值）存储
					Map<String, Object> map = new HashMap<String, Object>();

					for (int i = 1; i <= count; i++) {
						// 循环获取列名
						String columnName = rs.getMetaData().getColumnName(i);
						// 获取值，由于值的多样性，我们无法确定它是什么类型。
						Object value = rs.getObject(i);
						map.put(columnName, value);
					}
					list.add(map);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else{
			System.out.println("数据库连接失败！");
		}
		close(rs);
		close(stmt);
		close(conn);
		return list;
	}

	/*
	 * 关闭对象
	 */
	public static void close(Object o) {
		if (o == null) {
			return;
		}
		try {
			if (o instanceof ResultSet) {

				((ResultSet) o).close();

			} else if (o instanceof Statement) {

				((Statement) o).close();

			} else if (o instanceof Connection) {

				((Connection) o).close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
