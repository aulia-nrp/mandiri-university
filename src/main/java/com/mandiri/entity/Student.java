package com.mandiri.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_student")
public class Student {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Column(length = 200, nullable = false)
    private String name;
    @Column(length = 200, nullable = false)
    private String email;
    @Column(length = 300, nullable = false)
    private String address;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Jakarta")
    private Date birthDate;
    @Column(length = 15, nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private Integer entryYear;

    public Student(String id, String name, String email, String address, Date birthDate, String phoneNumber, Integer entryYear) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.entryYear = entryYear;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getEntryYear() {
        return entryYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", entryYear=" + entryYear +
                '}';
    }
}
