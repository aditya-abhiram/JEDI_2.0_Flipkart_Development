package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotAddedException;
import com.flipkart.exception.ProfessorNotAddedException;
import com.flipkart.exception.StudentNotApprovedException;
import com.flipkart.exception.StudentNotFoundException;
import com.flipkart.utils.DButils;

public class AdminDaoOperations implements AdminDaoInterface {

    @Override
    public void approveStudent(int studentId) throws StudentNotApprovedException, StudentNotFoundException {
        try (
            Connection con = DButils.getConnection(); // Get database connection
            PreparedStatement searchStmt = con.prepareStatement("SELECT studentId, batch, branch, isApproved FROM student WHERE studentId = ?");
            PreparedStatement updateStmt = con.prepareStatement("UPDATE student SET isApproved = 1 WHERE studentId = ?")
        ) {
            searchStmt.setInt(1, studentId); // Set student ID in the search query
            ResultSet rs = searchStmt.executeQuery();

            if (rs.next()) { // Check if student exists
                updateStmt.setInt(1, studentId); // Set student ID in the update query
                updateStmt.executeUpdate(); // Update student approval status

                System.out.println("Student approved successfully.");
                System.out.println("studentId: " + rs.getInt("studentId"));
                System.out.println("batch: " + rs.getString("batch"));
                System.out.println("branch: " + rs.getString("branch")); 
                
            }
                
             else {
                System.out.println("Student with ID " + studentId + " not found.");
                System.out.println("------------------------------------------------------------------");
                throw new StudentNotFoundException("Student not found");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw new StudentNotApprovedException("Student couldn't be approved for registration");
        }
        
    }

    @Override
    public void addCourse(Course course) throws CourseNotAddedException {
        try (
            Connection con = DButils.getConnection(); // Get database connection
            PreparedStatement stmt = con.prepareStatement("INSERT INTO course (courseId, courseName, instructorId, instructorName, filledSeats, credit) VALUES (?, ?, ?, ?, ?, ?)")
        ) {
        	int courseId = course.getCourseId();
        	String courseName = course.getCourseName();
            stmt.setInt(1, courseId); // Set course ID
            stmt.setString(2, courseName); // Set course name
            stmt.setInt(3, course.getInstructorId()); // Set instructor ID
            stmt.setString(4, course.getInstructorName()); // Set instructor name
            stmt.setInt(5, course.getFilledSeats()); // Set filled seats
            stmt.setInt(6, course.getCredit()); // Set course credit

            stmt.executeUpdate(); // Execute the insert query
            
            System.out.println("Course added successfully. course id :"+courseId+" course name : "+courseName);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            throw new CourseNotAddedException("Course cannot be added");
        }
    }

    @Override
    public void addProfessor(Professor professor) throws ProfessorNotAddedException {
        try (
            Connection con = DButils.getConnection(); // Get database connection
            PreparedStatement userStmt = con.prepareStatement("INSERT INTO user (userId, password, role) VALUES (?, ?, ?)");
            PreparedStatement professorStmt = con.prepareStatement("INSERT INTO professor (professorId, department) VALUES (?, ?)")
        ) {
            int userId = professor.getProfessorId(); // Get professor ID
            String password = String.valueOf(userId); // Set password as professor ID (simple approach)

            // Insert into user table
            userStmt.setInt(1, userId); // Set user ID
            userStmt.setString(2, password); // Set password
            userStmt.setString(3, "professor"); // Set role
            int userRowsAffected = userStmt.executeUpdate();
            System.out.println("Rows affected in user table: " + userRowsAffected);

            // Insert into professor table
            professorStmt.setInt(1, userId); // Set professor ID
            String department = professor.getDepartment();
            professorStmt.setString(2, department); // Set department
            int professorRowsAffected = professorStmt.executeUpdate();
            System.out.println("Rows affected in professor table: " + professorRowsAffected);

            System.out.println("Professor added successfully with professor id : "+userId + " and department : "+department);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Couldn't add professor.");
            throw new ProfessorNotAddedException("Professor couldn't be added");
        }
    }

    @Override
    public List<Professor> viewAllProfessors() {
        List<Professor> professors = new ArrayList<>(); // Create list to hold professors
        try (
            Connection con = DButils.getConnection(); // Get database connection
            PreparedStatement stmt = con.prepareStatement("SELECT professorId, department FROM professor");
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) { // Iterate through result set
                Professor professor = new Professor();
                professor.setProfessorId(rs.getInt("professorId")); // Set professor ID
                professor.setDepartment(rs.getString("department")); // Set department
                professors.add(professor); // Add professor to list
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Couldn't retrieve professors.");
        }
        return professors; // Return list of professors
    }

    @Override
    public List<Student> viewAllStudents() {
        List<Student> students = new ArrayList<>(); // Create list to hold students
        try (
            Connection con = DButils.getConnection(); // Get database connection
            PreparedStatement stmt = con.prepareStatement("SELECT studentId, batch, branch, isApproved FROM student");
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) { // Iterate through result set
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId")); // Set student ID
                student.setBatch(rs.getInt("batch")); // Set batch
                student.setBranch(rs.getString("branch")); // Set branch
                student.setApproved(rs.getBoolean("isApproved")); // Set approval status
                students.add(student); // Add student to list
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Couldn't retrieve students.");
        }
        return students; // Return list of students
    }

    @Override
    public List<Course> viewAllCourses() {
        List<Course> courses = new ArrayList<>(); // Create list to hold courses
        try (
            Connection con = DButils.getConnection(); // Get database connection
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM course");
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) { // Iterate through result set
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));                // Set course ID
                course.setCourseName(rs.getString("courseName"));         // Set course name
                course.setInstructorId(rs.getInt("instructorId"));        // Set instructor ID
                course.setInstructorName(rs.getString("instructorName")); // Set instructor name
                course.setFilledSeats(rs.getInt("filledSeats"));          // Set filled seats
                course.setCredit(rs.getInt("credit")); // Set credit
                courses.add(course); // Add course to list
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Couldn't retrieve course data.");
        }
        return courses; // Return list of courses
    }
}
