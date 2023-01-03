package ru.itmo.kurpatow.object;

import jakarta.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "table_mountaineer")

public class Mountaineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMountaineer;
    @Column(name = "mountaineer_name", length = 100, nullable = false)
    private String name;
    private String city;
    private int age;

    @ManyToMany
    private ArrayList<Group> groups;

    public Mountaineer() {}

    public Mountaineer(String name, String address, int age) {
        if (name.length() < 3) throw new IllegalArgumentException("Ошибка! Имя слишком короткое.");
        if (address.length() < 5) throw new IllegalArgumentException("Ошибка! Название города слишком короткое.");
        this.name = name;
        this.city = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Mountaineer{" +
                " Номер альпиниста =" + idMountaineer +
                ", Имя ='" + name + '\'' +
                ", Город ='" + city + '\'' +
                ", Возраст =" + age +
                '}';
    }
}
