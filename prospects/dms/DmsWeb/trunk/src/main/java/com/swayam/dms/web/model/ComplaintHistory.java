package com.swayam.dms.web.model;

// Generated May 12, 2008 1:40:30 AM by Hibernate Tools 3.2.1.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ComplaintHistory generated by hbm2java
 */
@Entity
@Table(name = "complaint_history", schema = "public")
public class ComplaintHistory implements java.io.Serializable {

    private ComplaintHistoryId id;
    private Complaint complaint;
    private User employee;

    public ComplaintHistory() {
    }

    public ComplaintHistory(ComplaintHistoryId id, Complaint complaint,
            User employee) {
        this.id = id;
        this.complaint = complaint;
        this.employee = employee;
    }

    @EmbeddedId
    @AttributeOverrides( {
            @AttributeOverride(name = "complaintId", column = @Column(name = "complaint_id", nullable = false)),
            @AttributeOverride(name = "changedBy", column = @Column(name = "changed_by", nullable = false)),
            @AttributeOverride(name = "oldState", column = @Column(name = "old_state", nullable = false)),
            @AttributeOverride(name = "newState", column = @Column(name = "new_state", nullable = false)),
            @AttributeOverride(name = "changedAt", column = @Column(name = "changed_at", length = 8)) })
    public ComplaintHistoryId getId() {
        return this.id;
    }

    public void setId(ComplaintHistoryId id) {
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
