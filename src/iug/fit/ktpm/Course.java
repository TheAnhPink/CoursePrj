/*
 * @ (#) Course.java     1.0     25/08/2024
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
 * Lớp Course đại diện cho một khóa học với các thông tin như mã khóa học,
 * tên khóa học, khoa và số tín chỉ.
 */
public class Course {

    private String id;         // Mã khóa học
    private String title;      // Tên khóa học
    private String department; // Khoa của khóa học
    private int credit;        // Số tín chỉ của khóa học

    /**
     * Tạo một đối tượng Course mặc định với các giá trị rỗng và 0.
     */
    public Course() {
        this("", "", "", 0);
    }

    /**
     * Tạo một đối tượng Course với thông tin được cung cấp.
     *
     * @param id Mã khóa học
     * @param title Tên khóa học
     * @param department Khoa của khóa học
     * @param credit Số tín chỉ của khóa học
     */
    public Course(String id, String title, String department, int credit) {
        this.id = id;
        this.title = title;
        this.department = department;
        this.credit = credit;
    }

    /**
     * Lấy mã khóa học.
     *
     * @return Mã khóa học
     */
    public String getId() {
        return id;
    }

    /**
     * Đặt mã khóa học.
     *
     * @param id Mã khóa học (phải ít nhất 3 ký tự và chỉ chứa chữ cái hoặc số)
     * @throws IllegalArgumentException nếu mã khóa học không hợp lệ
     */
    public void setId(String id) {
        if(id.length() < 3){
            throw new IllegalArgumentException("ID must be at least 3 characters");
        }
        if(!id.matches("[a-zA-Z0-9]+")) {
            throw new IllegalArgumentException("ID must contain only letters or digits");
        }
        this.id = id;
    }

    /**
     * Lấy tên khóa học.
     *
     * @return Tên khóa học
     */
    public String getTitle() {
        return title;
    }

    /**
     * Đặt tên khóa học.
     *
     * @param title Tên khóa học (không được rỗng)
     * @throws IllegalArgumentException nếu tên khóa học rỗng
     */
    public void setTitle(String title) {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title;
    }

    /**
     * Lấy tên khoa của khóa học.
     *
     * @return Khoa của khóa học
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Đặt tên khoa của khóa học.
     *
     * @param department Khoa của khóa học
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Lấy số tín chỉ của khóa học.
     *
     * @return Số tín chỉ của khóa học
     */
    public int getCredit() {
        return credit;
    }

    /**
     * Đặt số tín chỉ của khóa học.
     *
     * @param credit Số tín chỉ của khóa học (phải lớn hơn hoặc bằng 0)
     * @throws IllegalArgumentException nếu số tín chỉ không hợp lệ
     */
    public void setCredit(int credit) {
        if(credit < 0){
            throw new IllegalArgumentException("Credit must be greater than or equal to 0");
        }
        this.credit = credit;
    }

    /**
     * Trả về chuỗi mô tả thông tin của khóa học.
     *
     * @return Chuỗi mô tả thông tin của khóa học
     */
    @Override
    public String toString() {
        return "Course:  " +
                "id ='" + id + '\'' +
                ", title ='" + title + '\'' +
                ", credit =" + credit +
                ", department ='" + department + '\'';
    }
}