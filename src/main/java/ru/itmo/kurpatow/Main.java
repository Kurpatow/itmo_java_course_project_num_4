package ru.itmo.kurpatow;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.itmo.kurpatow.object.Group;
import ru.itmo.kurpatow.object.Mountain;
import ru.itmo.kurpatow.object.Mountaineer;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("project4");
        // создается в блоке try с ресурсом или у объекта вызван метод close
        EntityManager manager = factory.createEntityManager();
        // создание менеджера управляющего project4 классами
        Mountaineer mountaineer1 = new Mountaineer("Михаил", "Тбилиси", 25);
        Mountaineer mountaineer2 = new Mountaineer("Екатерина", "Санкт-Петербург", 26);
        Mountaineer mountaineer3 = new Mountaineer("Никита","Санкт-Петербург",25);
        Mountaineer mountaineer4 = new Mountaineer("Дмитрий", "Москва",25);
        Mountaineer mountaineer5 = new Mountaineer("Кристина","Екатеринбург", 24);
        Mountaineer mountaineer6 = new Mountaineer("Максим","Екатеринбург",23);
        Mountaineer mountaineer7 = new Mountaineer("Роберт","Санкт-Петербург",24);

        ArrayList<Mountaineer> mountaineers = new ArrayList<>();
        mountaineers.add(mountaineer1);
        mountaineers.add(mountaineer2);
        mountaineers.add(mountaineer3);
        mountaineers.add(mountaineer4);
        mountaineers.add(mountaineer5);
        mountaineers.add(mountaineer6);
        mountaineers.add(mountaineer7);

        Mountain mountain1 = new Mountain("Эльбрус", "Кавказ", 5642);
        Group group1 = new Group(
                mountaineers,
                mountain1,
                5,
                LocalDateTime.of(
                        2023, Month.JANUARY, 10, 10, 30, 0));

        manager.getTransaction().begin();
        manager.persist(mountaineer1);
        manager.persist(mountain1);
        manager.persist(group1);

        manager.persist(mountaineer3);
        manager.persist(mountain1);
        manager.persist(group1);

        manager.persist(mountaineer4);
        manager.persist(mountain1);
        manager.persist(group1);

        manager.persist(mountaineer7);
        manager.persist(mountain1);
        manager.persist(group1);

        manager.getTransaction().commit();

        Mountain mountain2 = new Mountain("Чо-Ойю", "Гималаи", 8201);
        Group group2 = new Group(
                mountaineers,
                mountain2,
                5,
                LocalDateTime.of(
                        2023, Month.FEBRUARY, 12, 9, 45, 0));

        manager.getTransaction().begin();
        manager.persist(mountaineer1);
        manager.persist(mountain2);
        manager.persist(group2);

        manager.persist(mountaineer2);
        manager.persist(mountain2);
        manager.persist(group2);

        manager.persist(mountaineer3);
        manager.persist(mountain2);
        manager.persist(group2);

        manager.persist(mountaineer4);
        manager.persist(mountain2);
        manager.persist(group2);

        manager.persist(mountaineer5);
        manager.persist(mountain2);
        manager.persist(group2);

        manager.getTransaction().commit();


        Mountain mountain3 = new Mountain("Акаиси", "Япония", 3120);
        Group group3 = new Group(
                mountaineers,
                mountain3,
                5,
                LocalDateTime.of(
                        2023, Month.MAY, 11, 7, 15, 0));

        manager.getTransaction().begin();
        manager.persist(mountaineer2);
        manager.persist(mountain3);
        manager.persist(group3);

        manager.persist(mountaineer3);
        manager.persist(mountain3);
        manager.persist(group3);

        manager.getTransaction().commit();
    }
}