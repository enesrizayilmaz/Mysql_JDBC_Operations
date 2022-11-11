package MysqlJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	/*
	 
	 student_id     student_name      student_class 
	  	 101			enes				1		
	     201			rýza				2	
	     301			yýlmaz				3
	     
	 */
	public static final String DB_URL = "jdbc:mysql://localhost/university";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "root";
	public static void main(String[] args) {
		Connection connect = null;
		Statement st = null;
		
		//Get
		//String sql = "SELECT * FROM student";//Get all data
		
		//Set
		//String setsql = "INSERT INTO student (student_name,student_class) VALUES ('John',4)";
		//String psetSql = "INSERT INTO student (student_name,student_class) VALUES (?,?)";
		
		//Update
		//Change student name of row with student id 1
		//String upSql = "UPDATE student SET student_name='Enes Rýza' WHERE student_id=1";
		//String pupsql= "UPDATE student SET student_name= ? WHERE student_id = ?"; Prepare Statement
		
		
		//Delete
		String delSql = "DELETE FROM student WHERE student_id=5";
		String pdelSql = "DELETE FROM student WHERE student_id=?";
		try {
			connect = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);//Connect db
			st = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			//ResultSet data = st.executeQuery(sql);// Get Query
			
			//################################################
			//ResultSet operations
			//data.first() -- get first data
			//data.last() -- get last data
			//data.absolute(x) -- enter the x and you reach x row datas
			//and you have to write data.getString("student_name");
			//################################################
			
			/* Get 
			while(data.next()) {
				System.out.println("ID: " + data.getInt("student_id"));//Get student id
				System.out.println("Name: " + data.getString("student_name"));//Get student name
				System.out.println("Class: " + data.getInt("student_class"));//Get student class
			}
			*/
			//st.executeUpdate(setsql); Set 
			
			/* Prepared Statement - Set
			PreparedStatement prSt = connect.prepareStatement(psetSql);
			prSt.setString(1,"Wick");
			prSt.setInt(2, 4);
			prSt.executeUpdate();
			
			prSt.close();
			*/
			
			//st.executeUpdate(upSql); Update 
			//Prepared Statament same set
			
			//st.executeUpdate(delSql); Delete 
			//Prepared Statament same set
			
			st.close();
		
			
		}catch(SQLException e){
			System.out.print(e.getMessage());
		}
		
	
		
	}
	

}
