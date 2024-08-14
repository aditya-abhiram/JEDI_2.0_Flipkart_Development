package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.RegisteredCourse;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.utils.DButils;

public class StudentDaoOperations implements StudentDaoInterface {

    @Override
    public List<Course> viewCourses() {
        // Retrieve and return all available courses
        List<Course> courses = new ArrayList<>();
        try (
            Connection con = DButils.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM course");
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Course course = new Course();
                course.setCourseId(rs.getInt("courseid"));
                course.setCourseName(rs.getString("courseName"));
                course.setInstructorName(rs.getString("instructorName"));
                course.setInstructorId(rs.getInt("instructorId"));
                course.setFilledSeats(rs.getInt("filledSeats"));
                course.setCredit(rs.getInt("credit"));
                courses.add(course);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Couldn't retrieve course data");
        }
        return courses;
    }

    @Override
    public List<RegisteredCourse> viewRegisteredCourses(int studentId) {
        // Retrieve and return courses registered by the student
        List<RegisteredCourse> registeredCourses = new ArrayList<>();
        try (
            Connection con = DButils.getConnection();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM registeredcourse WHERE studentId = ?")
        ) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RegisteredCourse registeredCourse = new RegisteredCourse();
                registeredCourse.setCourseId(rs.getInt("courseid")); // Adjusted to match column names
                registeredCourse.setRegisteredCoursename(rs.getString("registeredCourseName"));
                registeredCourse.setGrade(rs.getString("grade"));
                registeredCourse.setCredit(rs.getInt("credit"));
                registeredCourses.add(registeredCourse);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Couldn't retrieve registered course data");
        }
        return registeredCourses;
    }

    @Override
    public void addCourse(int studentId, int courseId) throws CourseNotFoundException {
        // Add a course to the student's registered courses
        try (
            Connection con = DButils.getConnection();
            PreparedStatement checkCourseStmt = con.prepareStatement("SELECT * FROM course WHERE courseid = ?");
            PreparedStatement updateSeatsStmt = con.prepareStatement("UPDATE course SET filledSeats = ? WHERE courseid = ?");
            PreparedStatement addCourseStmt = con.prepareStatement("INSERT INTO registeredcourse (courseId, registeredCourseName, studentId, credit, instructorId) VALUES (?, ?, ?, ?, ?)")
        ) {
            checkCourseStmt.setInt(1, courseId);
            ResultSet rs = checkCourseStmt.executeQuery();

            if (rs.next()) {
                String courseName = rs.getString("courseName");
                int credit = rs.getInt("credit");
                int filledSeats = rs.getInt("filledSeats");
                int instructorId = rs.getInt("instructorId");

                updateSeatsStmt.setInt(1, filledSeats + 1);
                updateSeatsStmt.setInt(2, courseId);
                updateSeatsStmt.executeUpdate();

                addCourseStmt.setInt(1, courseId);
                addCourseStmt.setString(2, courseName);
                addCourseStmt.setInt(3, studentId);
                addCourseStmt.setInt(4, credit);
                addCourseStmt.setInt(5, instructorId);
                addCourseStmt.executeUpdate();

                System.out.println("Course successfully added to the registered courses. course Id : "+courseId+" Course name : "+courseName);
            } else {
                throw new CourseNotFoundException("Course doesn't exist");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Couldn't add the course.");
        }
    }

    @Override
    public void dropCourse(int studentId, int courseId) {
        // Remove a course from the student's registered courses
        try (
            Connection con = DButils.getConnection();
            PreparedStatement checkRegistrationStmt = con.prepareStatement("SELECT * FROM registeredcourse WHERE studentId = ? AND courseId = ?");
            PreparedStatement deleteCourseStmt = con.prepareStatement("DELETE FROM registeredcourse WHERE studentId = ? AND courseId = ?");
            PreparedStatement updateSeatsStmt = con.prepareStatement("UPDATE course SET filledSeats = filledSeats - 1 WHERE courseid = ?")
        ) {
            checkRegistrationStmt.setInt(1, studentId);
            checkRegistrationStmt.setInt(2, courseId);
            ResultSet rs = checkRegistrationStmt.executeQuery();

            if (rs.next()) {
                String courseName = rs.getString("registeredCourseName");
                int credit = rs.getInt("credit");

                deleteCourseStmt.setInt(1, studentId);
                deleteCourseStmt.setInt(2, courseId);
                deleteCourseStmt.executeUpdate();

                updateSeatsStmt.setInt(1, courseId);
                updateSeatsStmt.executeUpdate();

                System.out.printf("Course removed. Details: Course ID: %d, Course Name: %s, Credit: %d\n", courseId, courseName, credit);
            } else {
                System.out.println("The course is not registered by the student.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Couldn't drop the course.");
        }
    }
}
