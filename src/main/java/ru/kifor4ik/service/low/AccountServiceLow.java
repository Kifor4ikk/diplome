package ru.kifor4ik.service.low;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.repository.AccountRepository;
import ru.kifor4ik.service.BaseService;

import java.sql.SQLException;

public class AccountServiceLow extends AbstractLowService<AccountRepository, AccountEntity> {


    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceLow(AccountRepository accountRepository) {
        super(accountRepository);
        this.accountRepository = accountRepository;
    }



}
