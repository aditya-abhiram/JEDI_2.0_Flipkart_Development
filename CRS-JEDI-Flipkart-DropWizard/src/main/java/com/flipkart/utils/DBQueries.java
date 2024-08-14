package com.flipkart.utils;

public class DBQueries {
	public static final String GET_USER_USERNAME = "SELECT * FROM user WHERE username = ?";
	
	public static final String GET_USER_ID = "SELECT * FROM user WHERE userID = ?";

	public static final String GET_STUDENT_USERID = "SELECT * FROM student WHERE userID = ?";
	
	public static final String GET_PROFESSOR_USERID = "SELECT * FROM professor WHERE userID = ?";

	public static final String VERIFY_USERNAME= "SELECT * FROM user where username = ?";

	public static final String FETCH_IDS= "SELECT userID FROM user";
	
	public static final String FETCH_ROLLNUMS= "SELECT rollNum FROM student";

	public static final String ADD_USER = "insert into User(user_id,Name,role,username,password) values (?,?,?,?,?)";
	
	public static final String ADD_STUDENT = "insert into student(userID,branch,rollNum,approved) values (?,?,?,?)";

	public static final String UPDATE_PASSWORD = "UPDATE user SET password = ? WHERE username = ? and password = ?";
	
	public static final String FETCH_COURSES = "select * from course";
	
	public static final String ADD_COURSE = "INSERT INTO catalog VALUES (?,?,null,?,?)";
	
	public static final String REMOVE_COURSE = "delete from catalog where courseID = ?";
	
	public static final String REMOVE_USER = "delete from user where userID = ?";
	
	public static final String REMOVE_PROFESSOR = "delete from professor where userID=?";
	
	public static final String ADD_PROFESSOR = "insert into professor values (?,?,?)";
	
	public static final String APPROVE_REGISTRATION = "UPDATE student SET approved = 1 where userID = ?";
	
	public static final String VIEW_VACANT_COURSE = "SELECT courseProf from catalog WHERE courseID = ?";
	
	public static final String SELECT_PROF_COURSE = "UPDATE catalog SET courseProf = ? WHERE courseID = ?";
	
	public static final String VIEW_STUDENT_LIST = "SELECT * FROM student JOIN registeredCourse ON student.userID = registeredCourse.studentID JOIN user ON student.userID = user.userID WHERE registeredCourse.courseID = ?"; 
	
	public static final String SET_GRADE = "INSERT INTO reportCard(studentID, courseID, grade) values(?, ?, ?)";
	
	public static final String VIEW_COURSE_CATALOG = "SELECT * FROM crsapp.catalog";
	
	public static final String GET_GRADES = "SELECT * from reportCard WHERE studentID = ?";
	
	public static final String GET_COURSE_ENROLLED="SELECT catalog.courseID, catalog.courseName, catalog.courseProf, catalog.seats FROM student JOIN registeredCourse ON student.userID = registeredCourse.studentID JOIN catalog ON registeredCourse.courseID = catalog.courseID WHERE student.userID = ?";
	
	public static final String GET_BILLING_INFO="SELECT * from billing WHERE studentID = ?";
	
	public static final String GET_COURSE="SELECT * FROM catalog WHERE courseID = ?";

	public static final String DECR_SEATS = "UPDATE catalog SET seats = ? where courseID = ?";
	
	public static final String REGISTER_COURSE = "INSERT INTO registeredCourse(studentID,courseID,date) VALUES (?,?,?)";
	
	public static final String ADD_BILLING = "INSERT INTO billing(studentID,billingID,billAmount,status) VALUES (?,?,?,?)";
	
	public static final String FETCH_BILLINGS= "SELECT billingID FROM billing";

	public static final String GET_PROFESSOR_COURSEID="SELECT courseProf FROM catalog WHERE courseID=?";

	public static final String CHECK_STUDENT_COURSE="SELECT studentID FROM registeredCourse WHERE courseID=? AND studentID=? ";

	public static final String VIEW_COURSE_ENROLLED="SELECT * FROM catalog WHERE courseProf = ?";
	
	public static final String UPDATE_BILLING_INFO = "UPDATE billing SET billamt = ?, status = ?, transactionID = ? WHERE billingID = ?";
	
	public static final String VIEW_UNAPPROVED_STUDENTS ="SELECT * FROM student JOIN user ON student.userID=user.userID WHERE approved=0";
	
	public static final String VIEW_PROF_LIST = "SELECT * FROM professor JOIN user ON professor.userID=user.userID";
	
}
