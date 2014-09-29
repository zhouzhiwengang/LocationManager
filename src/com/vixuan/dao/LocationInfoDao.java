package com.vixuan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vixuan.database.MySQLUtil;
import com.vixuan.model.LocationInfo;

public class LocationInfoDao {
	private static Connection conn;
	private static ResultSet resultset;
	private static Statement statement;
	private static int pagesize = 5; // ��ҳ��С

	// ��̬ģ��
	static {
		conn = MySQLUtil.getConn();
	}

	// ������̬����
	public static ResultSet ExecuteQuery(String sql) {
		try {
			statement = conn.createStatement();
			resultset = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultset;
	}

	// ��ҳ�߼�-----��������ǰҳ��
	public static ArrayList<LocationInfo> getLocationInfoList(int currentpageno) {
		ArrayList<LocationInfo> LocationInfoList = new ArrayList<LocationInfo>();
		int BeginRecord;
		
			BeginRecord= (currentpageno - 1) * pagesize; // ��ʼλ��
		
		
	
		resultset = ExecuteQuery("select * from t_locationinfo limit "
				+ BeginRecord + "," + pagesize);
		try {
			while (resultset.next()) {
				LocationInfo locationinfo = new LocationInfo();
				locationinfo.setAddress(resultset.getString("address"));
				locationinfo.setLat(resultset.getString("lat"));
				locationinfo.setLng(resultset.getString("lng"));
				locationinfo.settId(resultset.getInt("t_id"));
				locationinfo.setUmobile(resultset.getString("umobile"));
				locationinfo.setUpdateTime(resultset.getString("update_time"));
				LocationInfoList.add(locationinfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return LocationInfoList;
	}

	// ��ҳͳ��
	public static int getPageCount() {
		int total = 0; // �ܼ�¼��
		int PageCount = 0; // ҳ������
		resultset = ExecuteQuery("select count(*) from t_locationinfo");
		try {
			if (resultset.next()) {
				total = resultset.getInt(1);
				PageCount = (total - 1) / pagesize + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PageCount;
	}
	
	public static int geTotalPage() {
		int total = 0; // �ܼ�¼��		
		resultset = ExecuteQuery("select count(*) from t_locationinfo");
		try {
			if (resultset.next()) {
				total = resultset.getInt(1);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

}
