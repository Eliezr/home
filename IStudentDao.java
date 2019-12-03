package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Student;

public interface IStudentDao {
	
	public void cleanUp() throws SQLException;
	
	List<Student> getStudentDetails(String courseName) throws Exception;
	
	String updateStudentDetails(int id, double newMarks, String newPhoneNo) throws Exception;
	
	String removeStudent(String email) throws Exception;

}
