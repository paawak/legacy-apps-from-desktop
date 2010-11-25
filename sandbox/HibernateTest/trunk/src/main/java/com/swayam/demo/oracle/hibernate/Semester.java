/*
 * Semester.java
 *
 * Created on Nov 26, 2010 12:25:36 AM
 *
 * Copyright (c) 2002 - 2008 : Swayam Inc.
 *
 * P R O P R I E T A R Y & C O N F I D E N T I A L
 *
 * The copyright of this document is vested in Swayam Inc. without
 * whose prior written permission its contents must not be published,
 * adapted or reproduced in any form or disclosed or
 * issued to any third party.
 */

package com.swayam.demo.oracle.hibernate;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author paawak
 */
public class Semester implements Serializable {

    private static final long serialVersionUID = -6067841723974478563L;

    @Id
    @Column(name = "semester_id")
    private Long semesterId;

    @Column(name = "semester_name")
    private String semesterName;

    @OneToMany(mappedBy = "semester_id")
    private Set<Subject> subjects;

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

}
