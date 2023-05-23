package ru.kifor4ik.domain;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExchangeRateToBynEntity implements BaseEntity {

    private String code;
    private BigDecimal amount;
}
