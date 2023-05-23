package ru.kifor4ik.domain;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferEntity  implements BaseEntity{
    private int id;
    private int sender_account_id;
    private int receiver_account_id;

    private String sender_currency_code;
    private String receiver_currency_code;
    private BigDecimal amount;

}
