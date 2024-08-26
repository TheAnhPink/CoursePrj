/*
 * @ (#) CourseList.java     1.0     25/08/2024
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
 * Lớp CourseList quản lý danh sách các khóa học, cung cấp các phương thức để thêm,
 * tìm kiếm, và xóa khóa học, cũng như tìm kiếm khóa học theo các tiêu chí nhất định.
 */
public class CourseList {

    private Course[] courses; // Mảng lưu trữ các khóa học
    private int count = 0;    // Số lượng khóa học hiện tại

    /**
     * Tạo một đối tượng CourseList với số lượng khóa học tối đa.
     *
     * @param n Số lượng khóa học tối đa
     */
    public CourseList(int n) {
        courses = new Course[n];
    }

    /**
     * Lấy mảng các khóa học.
     *
     * @return Mảng các khóa học
     */
    public Course[] getCourses() {
        return courses;
    }

    /**
     * Đặt mảng các khóa học.
     *
     * @param courses Mảng các khóa học mới
     */
    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    /**
     * Lấy số lượng khóa học hiện tại.
     *
     * @return Số lượng khóa học hiện tại
     */
    public int getCount() {
        return count;
    }

    /**
     * Đặt số lượng khóa học hiện tại.
     *
     * @param count Số lượng khóa học mới
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Thêm một khóa học vào danh sách nếu chưa tồn tại và danh sách chưa đầy.
     *
     * @param course Khóa học cần thêm
     * @return true nếu thêm thành công, ngược lại false
     */
    public boolean addCourse(Course course){
        if (courses == null) return false;

        if(isExists(course)) {
            return false;
        }

        if (count < courses.length) {
            courses[count++] = course;
            return true;
        }
        return false;
    }

    /**
     * Kiểm tra khóa học đã tồn tại trong danh sách chưa.
     *
     * @param course Khóa học cần kiểm tra
     * @return true nếu khóa học đã tồn tại, ngược lại false
     */
    private boolean isExists(Course course){
        int len = courses.length;
        for(int i = 0; i < len; i++) {
            Course temp = courses[i];
            if(temp != null && temp.getId().equals(course.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tìm khoa có nhiều khóa học nhất.
     *
     * @return Tên khoa có nhiều khóa học nhất
     */
    public String findDepartmentWithMostCourses(){
        if(courses == null) return null;
        String[] departments = new String[count];
        int[] counts = new int[count];
        int index = 0;
        for(int i = 0; i < count; i++) {
            Course course = courses[i];
            String department = course.getDepartment();
            int pos = findDepartment(departments, department, index);
            if(pos == -1) {
                departments[index] = department;
                counts[index] = 1;
                index++;
            } else {
                counts[pos]++;
            }
        }
        int max = counts[0];
        int pos = 0;
        for(int i = 1; i < index; i++) {
            if(counts[i] > max) {
                max = counts[i];
                pos = i;
            }
        }
        return departments[pos];
    }

    /**
     * Tìm vị trí của một khoa trong mảng khoa.
     *
     * @param departments Mảng khoa
     * @param department Tên khoa cần tìm
     * @param index Số lượng khoa hiện tại trong mảng
     * @return Vị trí của khoa trong mảng nếu tìm thấy, ngược lại -1
     */
    private int findDepartment(String[] departments, String department, int index) {
        for(int i = 0; i < index; i++) {
            if(departments[i].equals(department)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Tìm khóa học có số tín chỉ lớn nhất.
     *
     * @return Khóa học có số tín chỉ lớn nhất
     */
    public Course findMaxCreditCourse(){
        if(courses == null) return null;
        Course maxCreditCourse = courses[0];
        for(int i = 1; i < count; i++) {
            if(courses[i].getCredit() > maxCreditCourse.getCredit()) {
                maxCreditCourse = courses[i];
            }
        }
        return maxCreditCourse;
    }

    /**
     * Xóa khóa học theo mã khóa học.
     *
     * @param id Mã khóa học cần xóa
     * @return true nếu xóa thành công, ngược lại false
     */
    public boolean RemoveCourse(String id){
        if(courses == null) return false;
        for(int i = 0; i < count; i++) {
            if(courses[i].getId().equals(id)) {
                courses[i] = courses[count - 1];
                count--;
                return true;
            }
        }
        return false;
    }

    /**
     * Tìm khóa học theo tên khóa học.
     *
     * @param title Tên khóa học cần tìm
     * @return Khóa học nếu tìm thấy, ngược lại null
     */
    public Course SearchCourse(String title){
        if(courses == null) return null;
        for(int i = 0; i < count; i++) {
            if(courses[i].getTitle().equals(title)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Tìm khóa học theo tên khoa.
     *
     * @param department Tên khoa cần tìm
     * @return Khóa học nếu tìm thấy, ngược lại null
     */
    public Course SearchCourseByDepartment(String department){
        if(courses == null) return null;
        for(int i = 0; i < count; i++) {
            if(courses[i].getDepartment().equals(department)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Tìm khóa học theo mã khóa học.
     *
     * @param id Mã khóa học cần tìm
     * @return Khóa học nếu tìm thấy, ngược lại null
     */
    public Course SearchCourseByID(String id){
        if(courses == null) return null;
        for(int i = 0; i < count; i++) {
            if(courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Sắp xếp các khóa học theo số tín chỉ tăng dần.
     *
     * @return Khóa học có số tín chỉ nhỏ nhất sau khi sắp xếp
     */
    public Course SortCourse(){
        if(courses == null) return null;
        for(int i = 0; i < count - 1; i++) {
            for(int j = i + 1; j < count; j++) {
                if(courses[i].getCredit() > courses[j].getCredit()) {
                    Course temp = courses[i];
                    courses[i] = courses[j];
                    courses[j] = temp;
                }
            }
        }
        return courses[0];
    }
}
