package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
