package com.swayam.dms.web.model;

// Generated May 12, 2008 1:40:30 AM by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ComplaintPriority generated by hbm2java
 */
@Entity
@Table(name = "complaint_priority")
public class ComplaintPriority implements java.io.Serializable {

    private int complaintPriorityId;
    private String priority;
    private Set<Complaint> complaints = new HashSet<Complaint>(0);

    public ComplaintPriority() {
    }

    @Id
    @Column(name = "complaint_priority_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getComplaintPriorityId() {
        return this.complaintPriorityId;
    }

    public void setComplaintPriorityId(int complaintPriorityId) {
        this.complaintPriorityId = complaintPriorityId;
    }

    @Column(name = "priority", nullable = false, length = 10)
    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "complaintPriority")
    public Set<Complaint> getComplaints() {
        return this.complaints;
    }

    public void setComplaints(Set<Complaint> complaints) {
        this.complaints = complaints;
    }

}
