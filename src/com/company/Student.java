package com.company;

public class Student {
   private int rollNo;

    public Student(int rollNo, String studentName) {
        this.rollNo = rollNo;
        this.studentName = studentName;
    }

    private String studentName;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Student() {

    }
}
