package ru.kifor4ik.domain;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class    AccountEntity implements BaseEntity{
    private int id;
    private int abonentId;
    private BigDecimal value;
    private String currencyCode;

}
