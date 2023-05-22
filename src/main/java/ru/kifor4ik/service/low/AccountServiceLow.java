package ru.kifor4ik.service.low;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.repository.AccountRepository;
import ru.kifor4ik.service.BaseService;

import java.sql.SQLException;

public class AccountServiceLow implements BaseService<AccountEntity> {


    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceLow(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountEntity create(AccountEntity item) throws SQLException {
        return accountRepository.create(item);
    }

    @Override
    public AccountEntity getById(int id) {
        return accountRepository.get(id);
    }

    @Override
    public AccountEntity update(AccountEntity item) {
        return accountRepository.update(item);
    }

    @Override
    public AccountEntity delete(int id) {
        return accountRepository.delete(id);
    }
}
