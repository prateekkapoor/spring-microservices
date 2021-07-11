package com.springboot.multimodular.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;

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
