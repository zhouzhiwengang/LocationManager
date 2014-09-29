package com.vixuan.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;


import com.vixuan.database.MySQLUtil;
import com.vixuan.model.UserInfo;

public class LoginService extends HttpServlet {

	/**
	 * �û�����:Servlet
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//����������û���������
		String mobile=request.getParameter("mobile");
		
		
		//���ݿ����Ӳ���
		String sql="select * from t_userinfo as userinfo where userinfo.u_mobile1='"+mobile+"'";
		Connection conn=MySQLUtil.getConn();
		try {
			Statement statement=conn.createStatement();
			ResultSet resultset=statement.executeQuery(sql);
			List<UserInfo> list=new ArrayList<UserInfo>();
			while(resultset.next()){
				UserInfo userinfo=new UserInfo();
				userinfo.setEntCode(resultset.getString("ent_code"));
				userinfo.setuMobile(resultset.getString("u_mobile"));
				userinfo.setuName(resultset.getString("u_name"));
				userinfo.setuPwd(resultset.getString("u_pwd"));
				userinfo.setuSort(resultset.getInt("u_sort"));
				userinfo.setuType(resultset.getInt("u_type"));
				list.add(userinfo);
			}
			//ʵ�������jsonת����json��ʽ
			 JSONArray jsonArray = JSONArray.fromObject(list);  
			 //�������
			 PrintWriter out = response.getWriter();   
			 out.print(jsonArray); 
			 out.flush();
			 out.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method super.doPost(req, resp);
		    this.doGet(request, response);
	}
	

}
