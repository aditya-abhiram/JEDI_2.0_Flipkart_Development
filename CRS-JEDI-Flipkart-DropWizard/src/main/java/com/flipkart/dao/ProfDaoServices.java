package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.flipkart.bean.Course;
import com.flipkart.bean.Prof;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotOfferedException;
import com.flipkart.exception.CourseNotOptedException;
import com.flipkart.exception.GradeAlreadyAddedException;
import com.flipkart.utils.DBQueries;
import com.flipkart.utils.DBUtil;

public class ProfDaoServices implements ProfDaoInterface{
	public static Connection conn = DBUtil.getConnection();
	@Override
	public boolean offerCourse(String courseID, Prof prof) throws CourseNotAvailableException {
		// TODO Auto-generated method stub
		try {
        	PreparedStatement psCheck = conn.prepareStatement(DBQueries.VIEW_VACANT_COURSE);
        	psCheck.setString(1, courseID);
        	ResultSet rs = psCheck.executeQuery();
        	rs.next();
        	if(rs.getString("courseProf") != null&&rs.getString("courseProf").equals(prof.getID())) {
        		throw new CourseNotAvailableException(courseID);  			
        	}
        	
        	
            PreparedStatement ps = conn.prepareStatement(DBQueries.SELECT_PROF_COURSE);
            ps.setString(1, prof.getID());
            ps.setString(2, courseID);
            
            if(ps.executeUpdate() == 1)
            	return true;
            
 
        } catch (SQLException e) {
        	return false;
        }
		return false;
		
	}

	@Override
	public Set<Student> getStudents(String courseID, Prof prof) {
		// TODO Auto-generated method stub
		try {
			Set<Student> studentList = new HashSet<Student>();
            PreparedStatement ps = conn.prepareStatement(DBQueries.VIEW_STUDENT_LIST);
            ps.setString(1, courseID);
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
            	Student student=new Student(rs.getString("user.userID"),rs.getString("user.name"),rs.getString("user.contact"),rs.getString("user.email"),rs.getString("student.branch"),rs.getInt("student.rollNum"),rs.getBoolean("student.approved"),rs.getString("user.password"));
            	studentList.add(student);
            	System.out.println(student.getName());
            }
            
            return studentList;
            
        } catch (SQLException e) {
    		return null;
        }
	}

	@Override
	public boolean giveGrade(String courseID, String studentID, String grade, Prof prof) throws CourseNotOptedException,GradeAlreadyAddedException,CourseNotOfferedException{
		// TODO Auto-generated method stub
		try {
			PreparedStatement psCheck = conn.prepareStatement(DBQueries.GET_PROFESSOR_COURSEID);
            psCheck.setString(1, courseID);
            ResultSet rsCheck = psCheck.executeQuery();
            rsCheck.next();
            if(!rsCheck.getString("courseProf").equals(prof.getID())) {
            	throw new CourseNotOfferedException(prof.getID(), courseID);
            }PreparedStatement psCheck2 = conn.prepareStatement(DBQueries.CHECK_STUDENT_COURSE);
            psCheck2.setString(1, courseID);
            psCheck2.setString(2, studentID);
            ResultSet rsCheck2 = psCheck2.executeQuery();
            
            if(!rsCheck2.next()) {
            	throw new CourseNotOptedException(studentID, courseID);
            }
			
            PreparedStatement ps = conn.prepareStatement(DBQueries.SET_GRADE);
            ps.setString(1, studentID);
            ps.setString(2, courseID);
            ps.setString(3, grade);
            int rs = ps.executeUpdate();
            if (rs == 1)
            	return true;
            else throw new GradeAlreadyAddedException(studentID, courseID);
        } catch (SQLException e) {
        	return false;
        }
	}

	@Override
	public Set<Course> viewCourses() {
		// TODO Auto-generated method stub
		try {
			Set<Course> courseList = new HashSet<Course>();
            PreparedStatement ps = conn.prepareStatement(DBQueries.VIEW_COURSE_CATALOG);
            //ps.setString(1, courseID);
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
            	Course course=new Course(rs.getString("courseID"),rs.getString("courseName"),rs.getString("courseProf"),rs.getInt("seats"));
            	courseList.add(course);
            }
            
            return courseList;
            
        } catch (SQLException e) {
    		return null;
        }
	}

	@Override
	public Set<Course> viewCourseOffering(Prof prof) {
		// TODO Auto-generated method stub
		try {
			Set<Course> courseList = new HashSet<Course>();
            PreparedStatement ps = conn.prepareStatement(DBQueries.VIEW_COURSE_ENROLLED);
            ps.setString(1, prof.getID());
            ResultSet rs = ps.executeQuery(); 
            
            while(rs.next())
            {
            	Course course=new Course(rs.getString("courseID"),rs.getString("courseName"),rs.getString("courseProf"),rs.getInt("seats"));
            	courseList.add(course);
            }
            
            return courseList;
            
        } catch (SQLException e) {
    		return null;
        }
	}

}
