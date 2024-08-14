package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.utils.DButils;

public class ProfessorDaoOperations implements ProfessorDaoInterface {

    @Override
    public void viewCourses(int professorId) {
        // Retrieve and display courses taught by the professor
        try (
            Connection con = DButils.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM course WHERE instructorId = ?");
        ) {
            stmt.setInt(1, professorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseId"));
                course.setCourseName(rs.getString("courseName"));
                course.setInstructorId(rs.getInt("instructorId"));
                course.setInstructorName(rs.getString("instructorName"));
                course.setFilledSeats(rs.getInt("filledSeats"));
                course.setCredit(rs.getInt("credit"));

                // Display course details
                System.out.printf("%-10d %-20s %-20s %-15d %-12d %-6d\n",
                        course.getCourseId(),
                        course.getCourseName(),
                        course.getInstructorName(),
                        course.getInstructorId(),
                        course.getFilledSeats(),
                        course.getCredit());
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void viewStudents(int professorId) {
        // Retrieve and display students enrolled in the professor's courses
        try (
            Connection con = DButils.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT s.studentId, s.batch, s.branch FROM student s JOIN course c ON s.studentId = c.courseId WHERE c.instructorId = ?");
        ) {
            stmt.setInt(1, professorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("studentId"));
                student.setBatch(rs.getInt("batch"));
                student.setBranch(rs.getString("branch"));

                // Display student details
                System.out.printf("%-10d %-10d %-25s\n",
                        student.getStudentId(),
                        student.getBatch(),
                        student.getBranch());
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void gradeStudent(int professorId, int studentId, int courseId) {
        // Grade a student for a specific course
        try (
            Connection con = DButils.getConnection();
            PreparedStatement stmt = con.prepareStatement("UPDATE registeredcourse SET grade = ? WHERE studentId = ? AND courseId = ?");
        ) {
            // Input grading information
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter grade for studentId " + studentId + " in courseId " + courseId + ":");
            String grade = sc.next();

            stmt.setString(1, grade);
            stmt.setInt(2, studentId);
            stmt.setInt(3, courseId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Grade updated successfully for student id : "+studentId+" Courseid : "+courseId);
                System.out.println("Grade : "+grade);
            } else {
                System.out.println("No records updated. Please check the student ID and course ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
