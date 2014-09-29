package com.vixuan.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class MySQLUtil {
	public Map getURL() {
		// ��ȡ�����ļ���
		Properties p = new Properties();
		try {
			// Java�������--����Oracle���ݿ������ļ�
			p.load(getClass().getClassLoader().getResourceAsStream(
					"jdbc.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String pwd = p.getProperty("password");
		Map map = new HashMap();
		map.put("url", url);
		map.put("uname", username);
		map.put("pwd", pwd);
		return map;
	}

	public static Connection getConn() {
		MySQLUtil jdbc = new MySQLUtil();
		Map cmap = jdbc.getURL();
		String url = (String) cmap.get("url");
		String user = (String) cmap.get("uname");
		String password = (String) cmap.get("pwd");
		// Oracle ���ݿ�������
		Connection conn = null;
		try {
			// ����oracle ���ݿ�����
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Mysql���ݿ����ӳɹ���");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	// �ر�Oracle ���ݿ����ӷ���һ
	public static void closeCSR(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// �ر�oracle ���ݿ����ӷ�����
	public static void closeCS(Connection conn, Statement st) {
		try {
			if (st != null) {
				st.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// OracleUtil���ݿ⹤������Է���
	public static void main(String[] args) {
		MySQLUtil util = new MySQLUtil();
		util.getConn();
	}

}