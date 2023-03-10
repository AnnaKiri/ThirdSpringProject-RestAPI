package ru.kirillova.springcourse.ThirdSpringProjectRestAPI.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.*;

@Entity
@Table(name = "Sensor")
public class Sensor implements Serializable {  // реализуем Serializable т.к. взаимодействуем по нечисловому внешнему ключу

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 3, max = 30, message = "Name should be between 3 and 30 characters")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
