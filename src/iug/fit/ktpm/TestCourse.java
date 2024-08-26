/*
 * @ (#) TestCourse.java     1.0     25/08/2024
 *
 *Copyright (c) 2024 IUH. All rights reserved.
 */
package iug.fit.ktpm;


/*
 * @description: This class represents a bank with many bank accounts
 * @author: Anh, Le The Anh
 * @date: 25/08/2024
 * @version: 1.0
 */
/**
 * Lớp TestCourse chứa phương thức main để kiểm thử các chức năng của lớp Course và CourseList.
 */
public class TestCourse {
    public static void main(String[] args) {
        // Tạo các đối tượng Course
        Course course1 = new Course("CSC101", "Computer Science", "Computer Science", 3);
        Course course2 = new Course("CSC102", "Data Structures", "Computer Science", 3);
        Course course3 = new Course("MAT101", "Calculus I", "Mathematics", 2);

        // Tạo một đối tượng CourseList và thêm các khóa học vào danh sách
        CourseList courseList = new CourseList(10);
        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);

        // In ra khoa có nhiều khóa học nhất
        System.out.println("Department with the most courses: " + courseList.findDepartmentWithMostCourses());

        // Tìm khóa học có số tín chỉ lớn nhất và in ra
        System.out.println("Find max credit: " + courseList.findMaxCreditCourse());

        // Xóa một khóa học theo mã và in kết quả
        System.out.println("Remove course: " + courseList.RemoveCourse("CSC101"));

        // Tìm khóa học theo tên và in ra
        System.out.println("Search course: " + courseList.SearchCourse("Calculus I"));

        // Tìm khóa học theo khoa và in ra
        System.out.println("Search course by department: " + courseList.SearchCourseByDepartment("Computer Science"));

        // Tìm khóa học theo mã và in ra
        System.out.println("Search course by id: " + courseList.SearchCourseByID("CSC102"));

        // Sắp xếp các khóa học theo số tín chỉ và in khóa học đầu tiên
        System.out.println("Sort course: " + courseList.SortCourse());
    }
}