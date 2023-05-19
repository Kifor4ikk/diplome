package ru.kifor4ik;

import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.repository.AbonentRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        AbonentRepository abonentRepository = new AbonentRepository();

        System.out.println(abonentRepository.get(1));
    }
}
