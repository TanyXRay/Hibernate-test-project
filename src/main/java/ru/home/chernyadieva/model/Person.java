package ru.home.chernyadieva.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST) // для работы с методом session.persist(object)
    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE) // для работы с методом session.save(object)
    private List<Item> items;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addItem(Item item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
        item.setOwner(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
