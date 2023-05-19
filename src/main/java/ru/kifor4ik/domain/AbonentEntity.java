package ru.kifor4ik.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class AbonentEntity {
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private String thirdName;
    private int age;
    private String phoneNumber;
    private String note;
    private List<AccountEntity> accounts = new ArrayList<>();
    private List<CardEntity> cards = new ArrayList<>();

    public AbonentEntity(int id, String login, String password, String name, String secondname, String thirdname, int age, String phonenumber, String note) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = name;
        this.secondName = secondname;
        this.thirdName = thirdname;
        this.age = age;
        this.phoneNumber = phonenumber;
        this.note = note;
    }
}
