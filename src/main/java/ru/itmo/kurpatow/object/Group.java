package ru.itmo.kurpatow.object;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "table_group")

public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGroup;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "many_to_many_group_mountaineer")
    private ArrayList<Mountaineer> mountaineer = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mountain")
    private Mountain mountain;
    private Boolean flag;
    private int maxGroup;
    private LocalDateTime dateTime;

    public Group() {}

    public Group(ArrayList<Mountaineer> mountaineer, Mountain mountain, int maxGroup, LocalDateTime dateTime) {
        if(mountain == null) throw new IllegalArgumentException("Ошибка! Значение горы не может быть пустым.");
        if (maxGroup < 1) throw new IllegalArgumentException("Ошибка! Количество участников не может быть меньше одного.");
        if (dateTime.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("Ошибка! Дата введена не корректно.");
        this.mountaineer = mountaineer;
        this.mountain = mountain;
        this.flag = true;
        this.maxGroup = maxGroup;
        this.dateTime = dateTime;
    }

    public ArrayList<Mountaineer> getMountaineer() { return mountaineer; }

    public Mountain getMountain() { return mountain; }

    public Boolean getFlag() { return flag; }

    public int getMaxGroup() { return maxGroup; }

    public LocalDateTime getDateTime() { return dateTime; }

    public void addMountaineer(Mountaineer mountaineer){
        if (flag.equals(false)) throw new IllegalArgumentException("Группа заполнена!");
        if (mountaineer == null) throw new IllegalArgumentException("Ошибка! Значение в графе не может быть пустым.");
        this.mountaineer.add(mountaineer);
        if (this.mountaineer.size() == maxGroup) flag = false;
    }

    @Override
    public String toString() {
        return "Group{" +
                "Номер группы =" + idGroup +
                ", альпинист =" + mountaineer +
                ", гора =" + mountain +
                ", flag =" + flag +
                ", макс число группы =" + maxGroup +
                ", дата+время =" + dateTime +
                '}';
    }
}
