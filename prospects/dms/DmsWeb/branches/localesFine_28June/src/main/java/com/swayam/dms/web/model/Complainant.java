package com.swayam.dms.web.model;

// Generated May 12, 2008 1:40:30 AM by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Complainant generated by hbm2java
 */
@Entity
@Table(name = "complainant", schema = "public")
public class Complainant implements java.io.Serializable {

    private int complainantId;
    private String firstName;
    private String lastName;
    private Address address = new Address();
    private String emailId;
    private String homePhone;
    private String handPhone;
    private Set<Complaint> complaints = new HashSet<Complaint>(0);

    public Complainant() {
    }

    public Complainant(int complainantId, String firstName, String lastName,
            Address address) {
        this.complainantId = complainantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Complainant(int complainantId, String firstName, String lastName,
            Address address, String emailId, String homePhone,
            String handPhone, Set<Complaint> complaints) {
        this.complainantId = complainantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;

        this.emailId = emailId;
        this.homePhone = homePhone;
        this.handPhone = handPhone;
        this.complaints = complaints;
    }

    @Id
    @Column(name = "complainant_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getComplainantId() {
        return this.complainantId;
    }

    public void setComplainantId(int complainantId) {
        this.complainantId = complainantId;
    }

    @Column(name = "first_name", nullable = false, length = 30)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 30)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Column(name = "email_id", length = 20)
    public String getEmailId() {
        return this.emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "home_phone", length = 10)
    public String getHomePhone() {
        return this.homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Column(name = "hand_phone", length = 10)
    public String getHandPhone() {
        return this.handPhone;
    }

    public void setHandPhone(String handPhone) {
        this.handPhone = handPhone;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "complainant")
    public Set<Complaint> getComplaints() {
        return this.complaints;
    }

    public void setComplaints(Set<Complaint> complaints) {
        this.complaints = complaints;
    }

}
