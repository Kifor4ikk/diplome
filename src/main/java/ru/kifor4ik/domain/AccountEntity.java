package ru.kifor4ik.domain;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountEntity {
    private int id;
    private int user_id;
    private BigDecimal value;
    private String currency_code;

}
