package ru.home.chernyadieva.model;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Passport")
public class Passport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Column(name = "passport_number")
    private int passport_number;

    public Passport(int passport_number) {
        this.passport_number = passport_number;
    }
}
