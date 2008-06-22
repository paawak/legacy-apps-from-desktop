package com.swayam.dms.db.model;

// Generated May 12, 2008 1:40:30 AM by Hibernate Tools 3.2.1.GA

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * Complainant generated by hbm2java
 */
@Entity
@Table(name = "complainant", schema = "public")
public class Complainant implements java.io.Serializable {

    private int complainantId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private int pinCode;
    private String emailId;
    private String homePhone;
    private String handPhone;
    private Set<Complaint> complaints = new HashSet<Complaint>(0);

    public Complainant() {
    }

    public Complainant(int complainantId, String firstName, String lastName,
            String address, String city, int pinCode) {
        this.complainantId = complainantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
    }

    public Complainant(int complainantId, String firstName, String lastName,
            String address, String city, int pinCode, String emailId,
            String homePhone, String handPhone, Set<Complaint> complaints) {
        this.complainantId = complainantId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.pinCode = pinCode;
        this.emailId = emailId;
        this.homePhone = homePhone;
        this.handPhone = handPhone;
        this.complaints = complaints;
    }

    @Id
    @Column(name = "complainant_id", unique = true, nullable = false)
    @GeneratedValue(generator = "sequence")
    @GenericGenerator(name = "sequence", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "complainant_complainant_id_seq") })
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

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "city", nullable = false, length = 20)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "pin_code", nullable = false)
    public int getPinCode() {
        return this.pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
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
