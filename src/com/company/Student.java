package com.company;

public class Student implements Comparable<Student> {
   private int rollNo;
   private Double gpa;

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
//    public Student(int rollNo, String studentName) {
//        this.rollNo = rollNo;
//        this.studentName = studentName;
//    }

    public Student(String studentName,Double gpa) {
        this.gpa = gpa;
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

    @Override
    public String toString() {
        return "Student{" +
                "gpa=" + gpa +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.getGpa(),o.getGpa());// for ascending
      //  return Double.compare(o.getGpa(),this.getGpa());// for descending
    }
}
