package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import customException.StudentException;
import pojos.Student;
import static utils.DBUtils.*;

public class StudentDao implements IStudentDao {

	private Connection cn;
	private PreparedStatement pst1,pst2,pst3;
	
	public StudentDao() throws ClassNotFoundException, SQLException {
		cn = connectDB();
		pst1 = cn.prepareStatement("select * from students_dac where course_name = ?");
		pst2 = cn.prepareStatement("update students_dac set marks=?, phone_no=? where id = ?");
		pst3 = cn.prepareStatement("delete from students_dac where email=?");
	}
	
	public void cleanUp() throws SQLException
	{
		if(pst1 != null)
			pst1.close();
		if(pst2 != null)
			pst2.close();
		if(pst3 != null)
			pst3.close();
		
		if(cn != null)
			cn.close();
	}
	
	@Override
	public List<Student> getStudentDetails(String courseName) throws Exception {
		List<Student> students = new ArrayList<>();
		pst1.setString(1, courseName);
		try(ResultSet rst = pst1.executeQuery())
		{
			while (rst.next()) {
				students.add(new Student(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), courseName, rst.getDouble(7)));
			}
		}
		if(students.isEmpty())
			throw new StudentException();
		return students;
	}

	@Override
	public String updateStudentDetails(int id, double newMarks, String newPhoneNo) throws Exception {
		pst2.setDouble(1, newMarks);
		pst2.setString(2, newPhoneNo);
		pst2.setInt(3, id);
		int rst = pst2.executeUpdate();
		if(rst == 0)
			throw new StudentException();
		return "Student (with id="+id+") Marks and Phone number updated successfully!!";
	}

	@Override
	public String removeStudent(String email) throws Exception {
		pst3.setString(1, email);
		int rst = pst3.executeUpdate();
		if(rst == 0)
			throw new StudentException();
		return "Student (with id="+email+") removed successfully!!";
	}
}
