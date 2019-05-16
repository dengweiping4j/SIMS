package com.wq.entity;

public class Course {
    private String pkid;

    private String courseName;

    private String courseMajorkey;

    private String courseTeacherkey;

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid == null ? null : pkid.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getCourseMajorkey() {
        return courseMajorkey;
    }

    public void setCourseMajorkey(String courseMajorkey) {
        this.courseMajorkey = courseMajorkey == null ? null : courseMajorkey.trim();
    }

    public String getCourseTeacherkey() {
        return courseTeacherkey;
    }

    public void setCourseTeacherkey(String courseTeacherkey) {
        this.courseTeacherkey = courseTeacherkey == null ? null : courseTeacherkey.trim();
    }
}