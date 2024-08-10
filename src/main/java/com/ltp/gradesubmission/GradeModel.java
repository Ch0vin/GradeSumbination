package com.ltp.gradesubmission;

public class GradeModel {
    private String Subject;
    private String score;
    private String name;

    public GradeModel() {
    }

    public GradeModel(String Subject, String score, String name) {
        this.Subject = Subject;
        this.score = score;
        this.name = name;
    }

    public String getSubject() {
        return this.Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
