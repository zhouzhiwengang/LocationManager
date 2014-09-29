package com.vixuan.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.vixuan.dao.LocationInfoDao;
import com.vixuan.model.LocationInfo;

public class LocationServer extends HttpServlet {

	/**
	 * 地理位置信息分页查询：Servlet
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//请求参数：当前页面
		Integer pageNo=Integer.parseInt(request.getParameter("pageno"));
		//返回相关数据信息
		ArrayList<LocationInfo> list=LocationInfoDao.getLocationInfoList(pageNo);
		//总页面数
		Integer totalpage=LocationInfoDao.getPageCount();
		//数据总记录数
		Integer total=LocationInfoDao.geTotalPage();
		
		StringBuilder builder=new StringBuilder();
		builder.append("[");
		for(int i=0;i<list.size();i++){
			StringBuilder content=new StringBuilder();
			String address=list.get(i).getAddress();
			content.append("{ \"address\":\"").append(list.get(i).getAddress()).append("\"");
			String lat=list.get(i).getLat();
			content.append(",\"lat\":").append(list.get(i).getLat()).append("");
			content.append(",\"lng\":").append(list.get(i).getLng()).append("");
			content.append(",\"mobile\":\"").append(list.get(i).getUmobile()).append("\"");
			content.append(",\"no\":").append(list.get(i).gettId()).append("}");
			if(i<list.size()-1){
				content.append(",");
			}
			builder.append(content.toString());
			
		}
		builder.append("]");
		
		StringBuilder json=new StringBuilder();
		json.append("{\"total\":").append(totalpage).append("");
		json.append(",\"totalPage\":").append(totalpage).append("");
		json.append(",\"page\":").append(pageNo).append("");
		json.append(",\"pageSize\":").append("5").append("");
		json.append(",\"list\":").append(builder.toString()).append("}");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json");
		 PrintWriter out = response.getWriter();   
		 out.print(json.toString()); 
		 System.out.println(json.toString());
		 out.flush();
		 out.close();	
		
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	

}
