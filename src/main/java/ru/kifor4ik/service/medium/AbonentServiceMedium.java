package ru.kifor4ik.service.medium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.repository.AbonentRepository;
import ru.kifor4ik.repository.AccountRepository;
import ru.kifor4ik.repository.CardRepository;

import java.math.BigDecimal;
import java.sql.SQLException;

@Component
public class AbonentServiceMedium extends AbstractMediumService<AbonentRepository, AbonentEntity>{

    AbonentRepository abonentRepository;
    AccountRepository accountRepository;
    CardRepository cardRepository;
    @Autowired
    public AbonentServiceMedium(AbonentRepository repository, AccountRepository accountRepository, CardRepository cardRepository) {
        super(repository);
        this.abonentRepository = repository;
        this.accountRepository =accountRepository;
        this.cardRepository = cardRepository;
    }



    @Override
    public AbonentEntity create(AbonentEntity item) throws Exception {
        validateQuery(item.getLogin());
        validateQuery(item.getPassword());

        validateQuery(item.getFirstName());
        validateQuery(item.getSecondName());
        validateQuery(item.getThirdName());

        validateQuery(item.getPhoneNumber());
        validateQuery(item.getNote());

        return super.create(item);
    }

    @Override
    public AbonentEntity getById(int id) throws SQLException {
        return super.getById(id);
    }

    @Override
    public AbonentEntity update(AbonentEntity item) throws Exception {
        validateQuery(item.getLogin());
        validateQuery(item.getPassword());

        validateQuery(item.getFirstName());
        validateQuery(item.getSecondName());
        validateQuery(item.getThirdName());

        validateQuery(item.getPhoneNumber());
        validateQuery(item.getNote());

        return super.update(item);
    }

    @Override
    public AbonentEntity delete(int id) throws SQLException {
        return super.delete(id);
    }

    public boolean transferMoney(String cardSender, int password, String cardReceiver, BigDecimal amount) throws Exception {
        validateQuery(cardSender);
        validateQuery(cardReceiver);

        return accountRepository.transferMoney(
                cardRepository.getByNumberAndPass(cardSender, password).getAccountId(),
                cardRepository.getByNumber(cardReceiver).getAccountId(),
                amount
        );
    }
}
