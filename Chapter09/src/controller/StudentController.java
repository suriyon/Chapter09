package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import model.Student;
import util.MySQLHelper;

public class StudentController {
	public List<Student> selectAllStudent(){
		List<Student> students = new ArrayList<>();
		String sql = "select * from student";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String branch = rs.getString("branch");
				int age = rs.getInt("age");
				
				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setBranch(branch);
				student.setAge(age);
				
				students.add(student);
			}
			rs.close();
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	
	public boolean insert(Student student) {
		boolean result = false;
		String sql = "insert into student(id, name, branch, age) values(?, ?, ?, ?)";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			
			ps.setString(1, student.getId());
			ps.setString(2, student.getName());
			ps.setString(3, student.getBranch());
			ps.setInt(4, student.getAge());
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				result = true;
			}
			
			ps.close();
			MySQLHelper.closeDB();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;		
	}
	
	public Vector showStudent(){
		Vector students = new Vector();
		String sql = "select * from student";
		try {
			PreparedStatement ps = MySQLHelper.openDB().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String branch = rs.getString("branch");
				int age = rs.getInt("age");
				
				Student student = new Student();
				student.setId(id);
				student.setName(name);
				student.setBranch(branch);
				student.setAge(age);
				
				students.add(student);
			}
			rs.close();
			ps.close();
			MySQLHelper.closeDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	
	
	
	
	
	
	
	
}
