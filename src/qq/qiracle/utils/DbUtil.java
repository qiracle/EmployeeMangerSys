package qq.qiracle.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	private static final String JDBC_DRIVER =  "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/emp?useUnicode=true&characterEncoding=UTF-8";
	private static String USER = "root";
	private static String PASS = "qiracle";
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("请添加驱动包");
		}
	}

	public DbUtil() {
	}

	public Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public int executeUpdate(String sql, Object... params) {
		int rlt = -1;
		try {
			getConn();
			stmt = conn.prepareStatement(sql);
			putParams(params, stmt);
			rlt = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rlt;
	}

	public ResultSet executeQuery(String sql, Object... params) {
		try {
			// 2.获取连接
			getConn();
			stmt = conn.prepareStatement(sql);
			putParams(params, stmt);
			// 3.执行事务
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void putParams(Object[] params, PreparedStatement stmt)
			throws SQLException {
		if (params != null) {
			for (int i = 1; i <= params.length; i++) {
				stmt.setObject(i, params[i - 1]);
			}
		}
	}

	
	
}