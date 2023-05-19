package ru.kifor4ik.domain;

import lombok.*;

import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardEntity {
    private int id;
    private int account_id;
    private Date expired_date;
    private long cvv;

}
