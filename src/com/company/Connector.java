package com.company;
import java.sql.*;
import java.util.ArrayList;
public class Connector {
	public static void main(String[] args) {
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
	}
    public Connection get_conn() {
    	
        Connection connection = null;
        String host="localhost";
        String port="5432";
        String db_name="busticker";
        String username="postgres";
        String password="password";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
            if (connection != null) {
                System.out.println("");
            } else {
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return connection;
    }
    public void addBus(String busno, String busname, int totalseats, int freeseats, int fare, String sourcee, String destt, String username, int ac, int sleeper) {
    	Connection conn=null;
    	PreparedStatement statement=null;
    	Connector obj = new Connector();
    	System.out.println(obj.get_conn());
    	conn=obj.get_conn();
    	
//    		String  query=String.format("insert into bus(bus_no,owner_username,source,dest,cost,total_seats,available_seats,bus_name) values('%s','%s','%s','%s',%d,%d,%d,'%s')",busno,username,sourcee,destt,fare,totalseats,freeseats,busname);
    		try {
    			statement=conn.prepareStatement("insert into bus(bus_no,owner_username,source,dest,cost,total_seats,available_seats,bus_name,ac,sleeper) values(?,?,?,?,?,?,?,?,?,?)");
    			statement.setString(1, busno);
    			statement.setString(2, username);
    			statement.setString(3, sourcee);
    			statement.setString(4, destt);
    			statement.setInt(5,fare);
    			statement.setInt(6,totalseats);
    			statement.setInt(7,freeseats);
    			statement.setString(8, busname);
    			statement.setInt(9,ac);
    			statement.setInt(10,sleeper);
    			statement.executeUpdate();
    			System.out.println("new bus added");
    			
    		} catch (SQLException e) {

    			e.printStackTrace();
    		}
    		finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
        
    	
    }
    public void addOwner(String username, String password, String email, String ph, String gen) {
    	Connection conn=null;
    	PreparedStatement statement=null;
    	Connector obj = new Connector();
    	System.out.println(obj.get_conn());
    	conn=obj.get_conn();
    	
//    		String  query=String.format("insert into owner(owner_username,owner_password,owner_email,owner_ph,owner_gen) values('%s','%s','%s','%s','%s')",username,password,email,ph,gen);
    		try {
    			statement=conn.prepareStatement("insert into owner(owner_username,owner_password,owner_email,owner_ph,owner_gen) values(?,?,?,?,?)");
    			
    			statement.setString(1,username);
       			statement.setString(2,password);
       			statement.setString(3,email);
       			statement.setString(4,ph);
       			statement.setString(5,gen);
       			statement.executeUpdate();
    			System.out.println("new owner added");
    			
    		} catch (SQLException e) {

    			e.printStackTrace();
    		}
    		finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    }
    public void addPassenger(String username, String password, String email, String ph, String gen) {
    	Connection conn=null;
    	PreparedStatement statement=null;
    	Connector obj = new Connector();
    	System.out.println(obj.get_conn());
    	conn=obj.get_conn();
    	
//    		String  query=String.format("insert into pssgn(pssgn_username,pssgn_password,pssgn_email,pssgn_ph,pssgn_gen) values('%s','%s','%s','%s','%s')",username,password,email,ph,gen);
    		try {
    			statement=conn.prepareStatement("insert into pssgn(pssgn_username,pssgn_password,pssgn_email,pssgn_ph,pssgn_gen) values(?,?,?,?,?)");
    			
    			statement.setString(1,username);
       			statement.setString(2,password);
       			statement.setString(3,email);
       			statement.setString(4,ph);
       			statement.setString(5,gen);
       			statement.executeUpdate();
    			System.out.println("new passenger added");
    
    		} catch (SQLException e) {

    			e.printStackTrace();
    		}
    		finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    }
	public void showListBus(String source,String dest) {
		
		Connection conn=null;
		PreparedStatement statement=null;
		PreparedStatement statement1=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
		
//			String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
			try {
				statement=conn.prepareStatement("select* from stops where stop_name=? and stop_end_name=?");
				statement.setString(1,source);
       			statement.setString(2,dest);
				rs=statement.executeQuery();
				System.out.println("fetched");
				System.out.println("------------------------------------------------------------------------------------------");
				System.out.println("bus number   source   cost   available seats    dest    AC/NONAC   Sleeper");
				while(rs.next()) {
				String x=rs.getString(1);
				System.out.print(x+"    ");
				System.out.print(rs.getString(3)+"    ");
				System.out.print(rs.getString(4)+"    ");
				
				System.out.print(rs.getString(5)+"    ");
				
				
				System.out.print(rs.getString(6)+"    ");
				statement1=conn.prepareStatement("select* from bus where bus_no=?");
				statement1.setString(1,x);

				rs1=statement1.executeQuery();
				while(rs1.next()){
					System.out.print(rs1.getString(9)+"    ");
					System.out.println(rs1.getString(10)+"    ");
				}
				
				
				
//				System.out.println(start+"start and end"+end);
			}
				
	
				System.out.println("------------------------------------------------------------------------------------------------------");
			} 
			catch (SQLException e) {

				e.printStackTrace();
			}	
			finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
	}
//	public void showListBus(String source,String dest) {
//		
//			Connection conn=null;
//			PreparedStatement statement=null;
//			PreparedStatement statement1=null;
//			PreparedStatement statement2=null;
//			ResultSet rs=null;
//			ResultSet rs1=null;
//			ResultSet rs2=null;
//			Connector obj = new Connector();
//			String start = null,end=null;
//			int freeSeats=0,cost1=0,cost2 = 0;
//			System.out.println(obj.get_conn());
//			conn=obj.get_conn();
//			
////				String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
//				try {
//					statement=conn.prepareStatement("select* from bus");
//					rs=statement.executeQuery();
//					System.out.println("fetched");
//					System.out.println("------------------------------------------------------------------------------------------");
//					System.out.println("bus number   source   destination   cost   available seats  AC/NONAC Sleeper");
//					while(rs.next()) {
//						String busName=rs.getString(1);
//					
//					
//					statement1=conn.prepareStatement("select* from stops where stop_name=? and bus_name=?");
//					statement1.setString(1, source);
//					statement1.setString(2, busName);
//					rs1=statement1.executeQuery();
//					while(rs1.next()) {
//						start=rs1.getString(2);
//						cost1=rs1.getInt(4);
//					}
//					
//					statement1=conn.prepareStatement("select* from stops where stop_name=? and bus_name=?");
//					statement1.setString(1, dest);
//					statement1.setString(2, busName);
//					rs1=statement1.executeQuery();
//					while(rs1.next()) {
//					end=rs1.getString(2);
//					cost2=rs1.getInt(4);
//					freeSeats=rs1.getInt(5);
//					}
//					
//					if(start!=null && end !=null) {
//						statement2=conn.prepareStatement("select* from bus where bus_no=?");
//						statement2.setString(1, busName);
//						rs2=statement2.executeQuery();
//						rs2.next();
//						System.out.print(rs2.getString(1)+"   ");
//						System.out.print(source+"   ");
//						System.out.print(dest+"   ");
//						System.out.print((cost2-cost1)+"   ");
//						System.out.print(freeSeats+"   ");
//						System.out.print(rs2.getString(9)+"   ");
//						System.out.println(rs2.getString(10)+"   ");
//						
//						
//						
//						
//
//					}
////					System.out.println(start+"start and end"+end);
//				}
//					
//		
//					System.out.println("------------------------------------------------------------------------------------------------------");
//				} 
//				catch (SQLException e) {
//
//					e.printStackTrace();
//				}	
//				finally {
//	    			try {
//						conn.close();
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//	    		}
//		}
	public String verifyOwner(String tempUser, String tempPassword) {
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
//			System.out.println(tempUser+tempPassword+"got it");
//			String  query=String.format("select* from owner where owner_username='%s' and owner_password='%s'",tempUser,tempPassword);
			try {
				
				statement=conn.prepareStatement("select* from owner where owner_username=? and owner_password=?");
				statement.setString(1, tempUser);
				statement.setString(2, tempPassword);
				rs=statement.executeQuery();
				if(rs.next()) {
//					System.out.println(rs.getString(1));
//					System.out.println(rs.getString(2));
			
					return (rs.getString(1));
					}
				
				else{
					
					return("error");
				}
				
				
			} 
			catch (SQLException e) {
				System.out.println("exception arised");
				e.printStackTrace();
			}		
			finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		
	return ("null");	
	}
	public void busList(String s) {
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
		
//			String  query=String.format("select* from bus where owner_username='%s'",s);
			try {
				
				statement=conn.prepareStatement("select* from bus where owner_username=?");
				statement.setString(1, s);

				
				rs=statement.executeQuery();
				System.out.println("------------------------------------------------------------------------------------------------------");
				System.out.println("bus number   source   destination   cost  total seats    vailable seats  AC/NONAC Sleeper");
				while(rs.next()) {
					
					System.out.print(rs.getString(1)+"            ");
		
					System.out.print(rs.getString(3)+" 		");
					System.out.print(rs.getString(4)+"  ");
					System.out.print(rs.getString(5)+"  	  ");
					System.out.print(rs.getString(6)+"  	  ");
					System.out.print(rs.getString(7)+"   	 ");
//					System.out.print(rs.getString(8)+"   			 ");
					System.out.print(rs.getString(9)+"       ");
					System.out.println(rs.getString(10)+" 	 ");
					
				}
				System.out.println("------------------------------------------------------------------------------------------------------");
			
			} 
			catch (SQLException e) {

				e.printStackTrace();
			}	
			finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		
	}
	public void delBus(String s) {
		Connection conn=null;
		PreparedStatement statement=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
//		
//			String  query=String.format("delete from bus where bus_no='%s'",s);
			
			try {
				
				statement=conn.prepareStatement("delete from bus where bus_no=?");
				statement.setString(1, s);
				statement.executeUpdate();


			} 
			catch (SQLException e) {
				System.out.println("exception arised");
				e.printStackTrace();
			}
			finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		
	}
	public String verifyPassenger(String tempUserPassenger, String tempPasswordPassenger) {
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
//			System.out.println(tempuserp+temppasswordp+"got it");
//			String  query=String.format("select* from pssgn where pssgn_username='%s' and pssgn_password='%s'",tempUserPassenger,tempPasswordPassenger);
			try {
				statement=conn.prepareStatement("select* from pssgn where pssgn_username=? and pssgn_password=?");
				statement.setString(1, tempUserPassenger);
				statement.setString(2, tempPasswordPassenger);
				rs=statement.executeQuery();
	
				if(rs.next()) {
//					System.out.println(rs.getString(1));
//					System.out.println(rs.getString(2));
					return (rs.getString(1));
					
					
					
					}
				
				else{
				
					return("error");
					
					
				}
				} 
			catch (SQLException e) {
				System.out.println("exception arised");
				e.printStackTrace();
			}		
			finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		
	return ("null");	
	}
	
	public void addBooking(String busno,String source,String dest,String passnsame,String bookingid) {
		
		Connection conn=null;
    	PreparedStatement statement=null;
    	Connector obj = new Connector();
    	System.out.println(obj.get_conn());
    	conn=obj.get_conn();
    	
//    		String  query=String.format("insert into bookings(bus_no,pssgn_username,booking_id,source,dest) values('%s','%s','%s','%s','%s')",busno,passnsame,bookingid,source,dest);
    		try {
    			statement=conn.prepareStatement("insert into bookings(bus_no,pssgn_username,booking_id,source,dest) values(?,?,?,?,?)");
				statement.setString(1, busno);
				statement.setString(2, passnsame);
				statement.setString(3, bookingid);
				statement.setString(4, source);
				statement.setString(5, dest);
    			statement.executeUpdate();
    			System.out.println("inserted into booking table");
    	
    		} catch (SQLException e) {

    			e.printStackTrace();
    		}
    		finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		
		
	}
	public void fetchPassengerBooking(String p) {
	Connection conn=null;
	PreparedStatement statement=null;
	ResultSet rs=null;
	Connector obj = new Connector();
	System.out.println(obj.get_conn());
	conn=obj.get_conn();
	
//		String  query=String.format("select* from bookings where pssgn_username='%s'",p);
		try {
			
			statement=conn.prepareStatement("select* from bookings where pssgn_username=?");
			statement.setString(1, p);
			rs=statement.executeQuery();
			System.out.println("fetched");
		
			while(rs.next()) {
				System.out.print(rs.getString(1)+"    ");
				System.out.print(rs.getString(2)+"     ");
				System.out.print(rs.getString(3)+"    ");
				System.out.print(rs.getString(4)+"    ");
				System.out.println(rs.getString(5)+"    ");
				
			}
			
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}		
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
		
	}
	public void cancelPassengerBooking(String cancel) {
		Connection conn=null;
		PreparedStatement statement=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
		
//			String  query=String.format("delete from bookings where bus_no='%s'",cancel);
			try {
				
				statement=conn.prepareStatement("delete from bookings where bus_no=?");
				statement.setString(1, cancel);
				statement.executeUpdate();
				

			} 
			catch (SQLException e) {
				System.out.println("exception arised");
				e.printStackTrace();
			}
			finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		
		
	}
	public void showPassengerList(String passcheck) {
		Connection conn=null;
		PreparedStatement statement=null;
	ResultSet rs=null;
	Connector obj = new Connector();
	System.out.println(obj.get_conn());
	conn=obj.get_conn();
	
//		String  query=String.format("select* from bookings where bus_no='%s'",passcheck);
		try {
			
			statement=conn.prepareStatement("select* from bookings where bus_no=?");
			statement.setString(1, passcheck);
			rs=statement.executeQuery();
			System.out.println("fetched");
			System.out.println("==================================================================");
			System.out.println("bus number     passenger name     passenger id    source      dest");
			while(rs.next()) {
				System.out.print(rs.getString(1)+"      ");
				System.out.print(rs.getString(2)+"      ");
				System.out.print(rs.getString(3)+" ");
				System.out.print(rs.getString(4)+"     ");
				System.out.println(rs.getString(5)+"   ");
				
			}
			System.out.println("==================================================================");
			
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}		
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	public void sortedListPrice(int sortPrice,String source,String dest) {
		
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		PreparedStatement statement1=null;
		ResultSet rs1=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
		
//			String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
			try {
				if(sortPrice==1) {
				statement=conn.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach");
				}
				else {
				statement=conn.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach desc");
				}
				statement.setString(1, source);
				statement.setString(2,dest);
				rs=statement.executeQuery();
				System.out.println("fetched");
				
				while(rs.next()) {
					String x=rs.getString(1);
					System.out.print(x+" ");
					System.out.print(rs.getString(2)+" ");
					System.out.print(rs.getString(3)+" ");
					System.out.print(rs.getString(4)+" ");
					System.out.print(rs.getString(5)+" ");
					System.out.print(rs.getString(6)+" ");
					statement1=conn.prepareStatement("select* from bus where bus_no=?");
					statement1.setString(1,x);

					rs1=statement1.executeQuery();
					while(rs1.next()){
						System.out.print(rs1.getString(9)+"    ");
						System.out.println(rs1.getString(10)+"    ");
					}
				}
			} 
			catch (SQLException e) {

				e.printStackTrace();
			}		
			finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
	}
	public void filterBy(int filterOption, String source, String dest)  {
		
		Connection conn=null;
		PreparedStatement statement=null;
		ResultSet rs=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
		
//			String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
			
				switch(filterOption) {
				
				
				
				case 1: {
					
					Connection conn2=null;
					PreparedStatement statement2=null;
					ResultSet rs2=null;
					PreparedStatement statement1=null;
					ResultSet rs1=null;
					String ac = null,sleeper=null;
					Connector obj1 = new Connector();
					System.out.println(obj1.get_conn());
					conn2=obj.get_conn();
					
//						String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
						try {
						
							statement2=conn2.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach");
							statement2.setString(1, source);
							statement2.setString(2,dest);
							rs=statement2.executeQuery();
							System.out.println("fetched");
							
							while(rs.next()) {
								String x=rs.getString(1);
								statement1=conn.prepareStatement("select* from bus where bus_no=?");
								statement1.setString(1,x);

								rs1=statement1.executeQuery();
								while(rs1.next()){
									ac=rs1.getString(9);
									sleeper=rs1.getString(10);
								}
								if(ac.equals("1")) {
								System.out.print(x+" ");
								System.out.print(rs.getString(2)+" ");
								System.out.print(rs.getString(3)+" ");
								System.out.print(rs.getString(4)+" ");
								System.out.print(rs.getString(5)+" ");
								System.out.print(rs.getString(6)+" ");

								}
							}
						} 
						catch (SQLException e) {

							e.printStackTrace();
						}		
						finally {
			    			try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    		}
						break;
				}
				case 2:  {
					
					Connection conn2=null;
					PreparedStatement statement2=null;
					ResultSet rs2=null;
					PreparedStatement statement1=null;
					ResultSet rs1=null;
					String ac = null,sleeper=null;
					Connector obj1 = new Connector();
					System.out.println(obj1.get_conn());
					conn2=obj.get_conn();
					
//						String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
						try {
						
							statement2=conn2.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach");
							statement2.setString(1, source);
							statement2.setString(2,dest);
							rs=statement2.executeQuery();
							System.out.println("fetched");
							
							while(rs.next()) {
								String x=rs.getString(1);
								statement1=conn.prepareStatement("select* from bus where bus_no=?");
								statement1.setString(1,x);

								rs1=statement1.executeQuery();
								while(rs1.next()){
									ac=rs1.getString(9);
									sleeper=rs1.getString(10);
								}
								if(ac.equals("0")) {
								System.out.print(x+" ");
								System.out.print(rs.getString(2)+" ");
								System.out.print(rs.getString(3)+" ");
								System.out.print(rs.getString(4)+" ");
								System.out.print(rs.getString(5)+" ");
								System.out.print(rs.getString(6)+" ");

								}
							}
						} 
						catch (SQLException e) {

							e.printStackTrace();
						}		
						finally {
			    			try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    		}
						break;
				}
				case 3:  {
					
					Connection conn2=null;
					PreparedStatement statement2=null;
					ResultSet rs2=null;
					PreparedStatement statement1=null;
					ResultSet rs1=null;
					String ac = null,sleeper=null;
					Connector obj1 = new Connector();
					System.out.println(obj1.get_conn());
					conn2=obj.get_conn();
					
//						String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
						try {
						
							statement2=conn2.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach");
							statement2.setString(1, source);
							statement2.setString(2,dest);
							rs=statement2.executeQuery();
							System.out.println("fetched");
							
							while(rs.next()) {
								String x=rs.getString(1);
								statement1=conn.prepareStatement("select* from bus where bus_no=?");
								statement1.setString(1,x);

								rs1=statement1.executeQuery();
								while(rs1.next()){
									ac=rs1.getString(9);
									sleeper=rs1.getString(10);
								}
								if(sleeper.equals("1")) {
								System.out.print(x+" ");
								System.out.print(rs.getString(2)+" ");
								System.out.print(rs.getString(3)+" ");
								System.out.print(rs.getString(4)+" ");
								System.out.print(rs.getString(5)+" ");
								System.out.print(rs.getString(6)+" ");

								}
							}
						} 
						catch (SQLException e) {

							e.printStackTrace();
						}		
						finally {
			    			try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    		}
						break;
				}
				case 4: {
					
					Connection conn2=null;
					PreparedStatement statement2=null;
					ResultSet rs2=null;
					PreparedStatement statement1=null;
					ResultSet rs1=null;
					String ac = null,sleeper=null;
					Connector obj1 = new Connector();
					System.out.println(obj1.get_conn());
					conn2=obj.get_conn();
					
//						String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
						try {
						
							statement2=conn2.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach");
							statement2.setString(1, source);
							statement2.setString(2,dest);
							rs=statement2.executeQuery();
							System.out.println("fetched");
							
							while(rs.next()) {
								String x=rs.getString(1);
								statement1=conn.prepareStatement("select* from bus where bus_no=?");
								statement1.setString(1,x);

								rs1=statement1.executeQuery();
								while(rs1.next()){
									ac=rs1.getString(9);
									sleeper=rs1.getString(10);
								}
								if(sleeper.equals("0")) {
								System.out.print(x+" ");
								System.out.print(rs.getString(2)+" ");
								System.out.print(rs.getString(3)+" ");
								System.out.print(rs.getString(4)+" ");
								System.out.print(rs.getString(5)+" ");
								System.out.print(rs.getString(6)+" ");

								}
							}
						} 
						catch (SQLException e) {

							e.printStackTrace();
						}		
						finally {
			    			try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    		}
						break;
				}
				case 5:   {
					
					Connection conn2=null;
					PreparedStatement statement2=null;
					ResultSet rs2=null;
					PreparedStatement statement1=null;
					ResultSet rs1=null;
					String ac = null,sleeper=null;
					Connector obj1 = new Connector();
					System.out.println(obj1.get_conn());
					conn2=obj.get_conn();
					
//						String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
						try {
						
							statement2=conn2.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach");
							statement2.setString(1, source);
							statement2.setString(2,dest);
							rs=statement2.executeQuery();
							System.out.println("fetched");
							
							while(rs.next()) {
								String x=rs.getString(1);
								statement1=conn.prepareStatement("select* from bus where bus_no=?");
								statement1.setString(1,x);

								rs1=statement1.executeQuery();
								while(rs1.next()){
									ac=rs1.getString(9);
									sleeper=rs1.getString(10);
								}
								if(ac.equals("1") && sleeper.equals("0")) {
								System.out.print(x+" ");
								System.out.print(rs.getString(2)+" ");
								System.out.print(rs.getString(3)+" ");
								System.out.print(rs.getString(4)+" ");
								System.out.print(rs.getString(5)+" ");
								System.out.print(rs.getString(6)+" ");

								}
							}
						} 
						catch (SQLException e) {

							e.printStackTrace();
						}		
						finally {
			    			try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    		}
						break;
				}
				case 6:  {
					
					Connection conn2=null;
					PreparedStatement statement2=null;
					ResultSet rs2=null;
					PreparedStatement statement1=null;
					ResultSet rs1=null;
					String ac = null,sleeper=null;
					Connector obj1 = new Connector();
					System.out.println(obj1.get_conn());
					conn2=obj.get_conn();
					
//						String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
						try {
						
							statement2=conn2.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach");
							statement2.setString(1, source);
							statement2.setString(2,dest);
							rs=statement2.executeQuery();
							System.out.println("fetched");
							
							while(rs.next()) {
								String x=rs.getString(1);
								statement1=conn.prepareStatement("select* from bus where bus_no=?");
								statement1.setString(1,x);

								rs1=statement1.executeQuery();
								while(rs1.next()){
									ac=rs1.getString(9);
									sleeper=rs1.getString(10);
								}
								if(ac.equals("0") && sleeper.equals("0"))  {
								System.out.print(x+" ");
								System.out.print(rs.getString(2)+" ");
								System.out.print(rs.getString(3)+" ");
								System.out.print(rs.getString(4)+" ");
								System.out.print(rs.getString(5)+" ");
								System.out.print(rs.getString(6)+" ");

								}
							}
						} 
						catch (SQLException e) {

							e.printStackTrace();
						}		
						finally {
			    			try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    		}
						break;
				}
				case 7:  {
					
					Connection conn2=null;
					PreparedStatement statement2=null;
					ResultSet rs2=null;
					PreparedStatement statement1=null;
					ResultSet rs1=null;
					String ac = null,sleeper=null;
					Connector obj1 = new Connector();
					System.out.println(obj1.get_conn());
					conn2=obj.get_conn();
					
//						String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
						try {
						
							statement2=conn2.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach");
							statement2.setString(1, source);
							statement2.setString(2,dest);
							rs=statement2.executeQuery();
							System.out.println("fetched");
							
							while(rs.next()) {
								String x=rs.getString(1);
								statement1=conn.prepareStatement("select* from bus where bus_no=?");
								statement1.setString(1,x);

								rs1=statement1.executeQuery();
								while(rs1.next()){
									ac=rs1.getString(9);
									sleeper=rs1.getString(10);
								}
								if(ac.equals("1") && sleeper.equals("1"))  {
								System.out.print(x+" ");
								System.out.print(rs.getString(2)+" ");
								System.out.print(rs.getString(3)+" ");
								System.out.print(rs.getString(4)+" ");
								System.out.print(rs.getString(5)+" ");
								System.out.print(rs.getString(6)+" ");

								}
							}
						} 
						catch (SQLException e) {

							e.printStackTrace();
						}		
						finally {
			    			try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    		}
						break;
				}
				case 8:  {
					
					Connection conn2=null;
					PreparedStatement statement2=null;
					ResultSet rs2=null;
					PreparedStatement statement1=null;
					ResultSet rs1=null;
					String ac = null,sleeper=null;
					Connector obj1 = new Connector();
					System.out.println(obj1.get_conn());
					conn2=obj.get_conn();
					
//						String  query=String.format("select* from bus where source='%s' and dest='%s'",source,dest);
						try {
						
							statement2=conn2.prepareStatement("select* from stops where stop_name=? and stop_end_name=? order by cost_to_reach");
							statement2.setString(1, source);
							statement2.setString(2,dest);
							rs=statement2.executeQuery();
							System.out.println("fetched");
							
							while(rs.next()) {
								String x=rs.getString(1);
								statement1=conn.prepareStatement("select* from bus where bus_no=?");
								statement1.setString(1,x);

								rs1=statement1.executeQuery();
								while(rs1.next()){
									ac=rs1.getString(9);
									sleeper=rs1.getString(10);
								}
								if(ac.equals("0") && sleeper.equals("1"))  {
								System.out.print(x+" ");
								System.out.print(rs.getString(2)+" ");
								System.out.print(rs.getString(3)+" ");
								System.out.print(rs.getString(4)+" ");
								System.out.print(rs.getString(5)+" ");
								System.out.print(rs.getString(6)+" ");

								}
							}
						} 
						catch (SQLException e) {

							e.printStackTrace();
						}		
						finally {
			    			try {
								conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			    		}
						break;
				}
				
				}
				}
			
	
	
			
	public int checkSeatAvailability(String busno) {
		Connection conn=null;
		PreparedStatement statement=null;
	ResultSet rs=null;
	Connector obj = new Connector();
	System.out.println(obj.get_conn());
	conn=obj.get_conn();
	
//		String  query=String.format("select* from bookings where bus_no='%s'",passcheck);
		try {
			
			statement=conn.prepareStatement("select available_seats from bus where bus_no=?");
			statement.setString(1, busno);
			rs=statement.executeQuery();
			System.out.println("fetched");
			while(rs.next()) {
				if(rs.getString(1).equals("")){
					return 0;
				}
				else {
				int i=Integer.parseInt(rs.getString(1));
				return(i);
				}
			}
			
		} 
		catch (SQLException e) {

			e.printStackTrace();
		}		
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return (0);
		
		
		
	}
	public void reduceSeatCount(String busno, int i) {
		Connection conn=null;
		PreparedStatement statement=null;
		Connector obj = new Connector();
		System.out.println(obj.get_conn());
		conn=obj.get_conn();
		
//			String  query=String.format("delete from bookings where bus_no='%s'",cancel);
			try {
				
				statement=conn.prepareStatement("update bus set available_seats=? where bus_no=?");
				statement.setString(2, busno);
				statement.setInt(1, i);
				statement.executeUpdate();
				

			} 
			catch (SQLException e) {
				System.out.println("exception arised");
				e.printStackTrace();
			}
			finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
		
		
	}
	public void addStops(String busno, int numberStops, ArrayList<String> stops, ArrayList<Integer> stopsCost, ArrayList<String> stopsEnd, ArrayList<Integer> freeSeats)  {
		
		Connection conn=null;
    	PreparedStatement statement=null;
    	Connector obj = new Connector();
    	System.out.println(obj.get_conn());
    	conn=obj.get_conn();
    	
//    		String  query=String.format("insert into bookings(bus_no,pssgn_username,booking_id,source,dest) values('%s','%s','%s','%s','%s')",busno,passnsame,bookingid,source,dest);
    		try {
    			for(int i=0;i<numberStops;i++) {
    			statement=conn.prepareStatement("insert into stops(bus_name,stop_number,stop_name,cost_to_reach,stop_end_name,freeseats) values(?,?,?,?,?,?)");
				statement.setString(1, busno);
				statement.setInt(2, i);
				statement.setString(3, stops.get(i));
				statement.setInt(4,stopsCost.get(i));
				statement.setString(5,stopsEnd.get(i));
				statement.setInt(6,freeSeats.get(i));
    			statement.executeUpdate();
    			System.out.println("inserted into stops "+stops.get(i));
    			}
    		} catch (SQLException e) {

    			e.printStackTrace();
    		}
    		finally {
    			try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		
		
	}
}