package com.springboot.multimodular.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="Employee")
@Entity
@Getter
@Setter
public class Employee {
    @Id
    private Long id;
}
