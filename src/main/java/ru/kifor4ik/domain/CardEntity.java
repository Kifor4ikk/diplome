package ru.kifor4ik.domain;

import lombok.*;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CardEntity  implements BaseEntity{
    private int id;
    private int accountId;
    private Date expired_date;
    private int cvv;
    private String cardNumber;
    private int cardPassword;
}
