package com.rost.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "school")
public class School {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "school_number")
    private int schoolNumber;

    //owning side
    @OneToOne
    @JoinColumn(name = "principal_id", referencedColumnName = "id")
    Principal principal;

    public School(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public String toString() {
        return String.format("school #%d", schoolNumber);
    }
}
