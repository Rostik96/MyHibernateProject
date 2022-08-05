package com.rost.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@ToString(includeFieldNames = false)

@Entity
@Table(name = "principal")
public class Principal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "principal")
    @Cascade(CascadeType.SAVE_UPDATE)
    private School school;

    public void setSchool(School school) {
        this.school = school;
        school.setPrincipal(this); //Good practice for Hibernate's cahce
    }

    public Principal(String name, int age, School school) {
        this.name = name;
        this.age = age;
        setSchool(school);
    }
}