package com.swayam.dms.web.model;

// Generated May 12, 2008 1:40:30 AM by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ComplaintHistory generated by hbm2java
 */
@Entity
@Table(name = "complaint_history")
public class ComplaintHistory implements java.io.Serializable {

    private int id;
    private Complaint complaint;
    private User employee;

    public ComplaintHistory() {
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "complaint_id", nullable = false, insertable = false, updatable = false)
    public Complaint getComplaint() {
        return this.complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "changed_by", nullable = false, insertable = false, updatable = false)
    public User getEmployee() {
        return this.employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

}
