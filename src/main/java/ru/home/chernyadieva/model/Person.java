package ru.home.chernyadieva.model;

import jakarta.persistence.*;
import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Person")
public class Person {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_person_id")
    @SequenceGenerator(name = "generator_person_id", sequenceName = "person_seq", allocationSize = 1)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Person(String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
