/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javaee7.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Masudul Haque
 */
@Named(value = "studentBean")
@RequestScoped
public class StudentBean {

    private boolean agree;
    private String sub;
    private String[] subject;

    private List<String> subjectList = new ArrayList<>();
    private List<String> subjectRes = new ArrayList<>();

    @PostConstruct
    public void init() {
        subjectList.add("History");
        subjectList.add("Sociology");
        subjectList.add("Biology");
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public List<String> getSubjectList() {
        return subjectList;
    }

    public List<String> getSubjectRes() {
        return subjectRes;
    }

    public void setSubjectRes(List<String> subjectRes) {
        this.subjectRes = subjectRes;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String submit() {
        System.out.println("Select One CheckBox :" + agree);
        System.out.println("Subject : "+sub);
        for (String string : subjectRes) {
            System.out.println("Selected Subject : " + string);
        }
        return null;
    }
}
