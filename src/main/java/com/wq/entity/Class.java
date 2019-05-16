package com.wq.entity;

public class Class {
    private String pkid;

    private String className;

    private String majorKey;

    private String departmentKey;

    private String classtutor;

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid == null ? null : pkid.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getMajorKey() {
        return majorKey;
    }

    public void setMajorKey(String majorKey) {
        this.majorKey = majorKey == null ? null : majorKey.trim();
    }

    public String getDepartmentKey() {
        return departmentKey;
    }

    public void setDepartmentKey(String departmentKey) {
        this.departmentKey = departmentKey == null ? null : departmentKey.trim();
    }

    public String getClasstutor() {
        return classtutor;
    }

    public void setClasstutor(String classtutor) {
        this.classtutor = classtutor == null ? null : classtutor.trim();
    }
}