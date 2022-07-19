package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class read_table { 
	public String fetch() {
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
		
		
			try {
				
				statement=conn.prepareStatement("select* from bus where source=?");
				statement.setString(1,"krishnagiri");
				rs=statement.executeQuery();
				System.out.println("fetched");
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return null;
		
	}
	public static void main(String[] args) {
		read_table rt=new read_table();
		System.out.println(rt.fetch());
		return;
	}
		

}
