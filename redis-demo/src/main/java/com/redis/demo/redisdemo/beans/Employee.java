package com.redis.demo.redisdemo.beans;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Serializable {
    private static final long serialVersionUID = 7156526077883281623L;

    // @Id annotation specifies the primary key of an entity.
    // @GeneratedValue provides the generation strategy specification for the primary key values.
    @Id
    @GeneratedValue
    private Integer id;
    private String firstName;
    private String lastName;
    private String emailAddress;
}
