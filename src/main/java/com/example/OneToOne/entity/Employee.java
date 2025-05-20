package com.example.OneToOne.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;
    private String employeeName;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="address_id")
    @JsonManagedReference
    private Address address;

}
