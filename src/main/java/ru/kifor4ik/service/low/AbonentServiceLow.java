package ru.kifor4ik.service.low;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.BaseEntity;
import ru.kifor4ik.repository.AbonentRepository;
import ru.kifor4ik.repository.AccountRepository;
import ru.kifor4ik.repository.CardRepository;

import java.math.BigDecimal;
import java.sql.SQLException;

@Component
public class AbonentServiceLow extends AbstractLowService<AbonentRepository, AbonentEntity> {

    AbonentRepository abonentRepository;
    AccountRepository accountRepository;
    CardRepository cardRepository;
    @Autowired
    public AbonentServiceLow(AbonentRepository repository, AccountRepository accountRepository, CardRepository cardRepository) {
        super(repository);
        this.abonentRepository = repository;
        this.accountRepository =accountRepository;
        this.cardRepository = cardRepository;
    }

    public boolean transferMoney(String cardSender, int password, String cardReceiver, BigDecimal amount) throws Exception {
        return accountRepository.transferMoney(
                cardRepository.getByNumberAndPass(cardSender, password).getAccountId(),
                cardRepository.getByNumber(cardReceiver).getAccountId(),
                amount
        );
    }

}
