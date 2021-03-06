package com.swayam.dms.web.model;

// Generated May 11, 2008 6:39:44 PM by Hibernate Tools 3.2.1.GA

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ComplaintStatus generated by hbm2java
 */
@Entity
@Table(name = "complaint_status", schema = "public")
public class ComplaintStatus implements java.io.Serializable {

    private int complaintStatusId;
    private String status;

    public ComplaintStatus() {
    }

    public ComplaintStatus(int complaintStatusId, String status) {
        this.complaintStatusId = complaintStatusId;
        this.status = status;
    }

    @Id
    @Column(name = "complaint_status_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getComplaintStatusId() {
        return this.complaintStatusId;
    }

    public void setComplaintStatusId(int complaintStatusId) {
        this.complaintStatusId = complaintStatusId;
    }

    @Column(name = "status", nullable = false, length = 10)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
