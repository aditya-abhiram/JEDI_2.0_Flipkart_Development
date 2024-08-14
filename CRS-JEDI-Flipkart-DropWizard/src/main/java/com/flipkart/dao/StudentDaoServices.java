package com.flipkart.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.flipkart.bean.Billing;
import com.flipkart.bean.Course;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.exception.BillingNotFoundException;
import com.flipkart.exception.CourseAlreadyOptedException;
import com.flipkart.exception.CourseNotAvailableException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.utils.DBQueries;
import com.flipkart.utils.DBUtil;

public class StudentDaoServices implements StudentDaoInterface{
	public static Connection conn = DBUtil.getConnection();

	@Override
	public float register(Student student, String courseID) throws CourseAlreadyOptedException, CourseNotAvailableException, CourseNotFoundException{
		// TODO Auto-generated method stub
		try {
			PreparedStatement psCheck = conn.prepareStatement(DBQueries.CHECK_STUDENT_COURSE);
			psCheck.setString(1, courseID);
			psCheck.setString(2, student.getID());
			ResultSet rs = psCheck.executeQuery();
			if(rs.next())throw new CourseAlreadyOptedException(student.getID(),courseID);
			
			
			PreparedStatement ps = conn.prepareStatement(DBQueries.GET_COURSE);
			ps.setString(1, courseID);
			rs = ps.executeQuery();
			int seats=0;
			if(rs.next()) {
				seats=rs.getInt("seats");
			}else throw new CourseNotFoundException(courseID);
			
			if(seats==0) throw new CourseNotAvailableException(courseID);
			
			PreparedStatement ps1 = conn.prepareStatement(DBQueries.DECR_SEATS);
			ps1.setInt(1, seats-1);
			ps1.setString(2, courseID);
			
			int rs1=ps1.executeUpdate();
			if(rs1==0)return 0;
			
			PreparedStatement ps2 = conn.prepareStatement(DBQueries.REGISTER_COURSE);
			ps2.setString(1, student.getID());
			ps2.setString(2, courseID);
			ps2.setDate(3,new Date(System.currentTimeMillis()));
			
			int rs2=ps2.executeUpdate();
			if(rs2==0)return 0;
			
			return rs.getFloat("price");
		} catch (SQLException e) {
			return 0;
		}
	}

	@Override
	public List<Course> viewCoursesEnrolled(Student student) {
		// TODO Auto-generated method stub
		try {
			List<Course> courseList = new ArrayList<Course>();

			PreparedStatement ps = conn.prepareStatement(DBQueries.GET_COURSE_ENROLLED);
			
			ps.setString(1, student.getID());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Course course=new Course(rs.getString("catalog.courseID"),rs.getString("catalog.courseName"),rs.getString("catalog.courseProf"),rs.getInt("catalog.seats"));
				courseList.add(course);

			}
			return courseList;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public ReportCard getReport(Student student) {
		// TODO Auto-generated method stub
		try {
			ReportCard reportCard = new ReportCard(student.getID());

			PreparedStatement ps = conn.prepareStatement(DBQueries.GET_GRADES);
			
			ps.setString(1, student.getID());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String courseID = rs.getString("courseID");
				String grade = rs.getString("grade");

				reportCard.addOrUpdateGrade(courseID, grade);

			}
			return reportCard;
		} catch (SQLException e) {
			return null;
		}
	}

	@Override
	public Billing getBillingInfo(Student student) throws BillingNotFoundException{
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = conn.prepareStatement(DBQueries.GET_BILLING_INFO);
            ps.setString(1, student.getID());
            ResultSet rs = ps.executeQuery(); 
            if(rs.next()) {
            	Billing billingInfo=new Billing(rs.getString("billingID"),student.getID(),rs.getFloat("billAmount"),rs.getBoolean("status"));
            
            	return billingInfo;
            }else throw new BillingNotFoundException(student.getID());
        } catch (SQLException e) {
    		return null;
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
            	//System.out.println(course.getCourseID()+" "+course.getCourseName());
            	courseList.add(course);
            }
            
            return courseList;
            
        } catch (SQLException e) {
    		return null;
        }
	}
	
	@Override
    public boolean updateBillingInfo(Billing billing) {
        try {
            PreparedStatement ps = conn.prepareStatement(DBQueries.UPDATE_BILLING_INFO);
            ps.setFloat(1, billing.getBillamt());
            ps.setBoolean(2, billing.isStatus());
            ps.setString(3, billing.getTransactionID());
            ps.setString(4, billing.getBillingID());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }
}
