package test;

import java.util.List;

import controller.StudentController;
import model.Student;

public class TestStudent {

	public static void main(String[] args) {
		StudentController sc = new StudentController();
		List<Student> students = sc.selectAllStudent();
		for (Student student : students) {
			System.out.println(student.getId() + " " + student.getName() + " " 
						+ student.getBranch() + " " + student.getAge());
		}
	}

}
