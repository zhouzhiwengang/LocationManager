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
import com.vixuan.model.UserRelation;

public class EmployeeService extends HttpServlet {

	/**
	 * 员工信息查询:Servlet
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//请求参数：手机号码
		String mobile=request.getParameter("mobile");
		//数据查询操作
		String sql="SELECT * from t_userrelation as relation where relation.u_mobile='"+mobile+"'";
		Connection conn=MySQLUtil.getConn();		
		
		try {
			Statement statement = conn.createStatement();
			ResultSet resultset=statement.executeQuery(sql);
			List<UserRelation> list=new ArrayList<UserRelation>();
			while(resultset.next()){
				UserRelation relation=new UserRelation();
				relation.setcUMobile(resultset.getString("c_u_mobile"));
				relation.setcUName(resultset.getString("c_u_name"));
				relation.setcUSort(resultset.getInt("c_u_sort"));
				relation.settId(resultset.getInt("t_id"));
				relation.setuMobile(resultset.getString("u_mobile"));
				list.add(relation);
			}
			//实体对象与json转换：json格式
			 JSONArray jsonArray = JSONArray.fromObject(list);  
			 //数据输出
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
		// TODO Auto-generated method stub
		this.doGet(request, response);
		
	}
	

}
