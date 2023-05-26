package ru.kifor4ik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.repository.AccountRepository;
import ru.kifor4ik.service.low.AbstractLowService;

@Component
public class AccountService extends AbstractLowService<AccountRepository, AccountEntity> {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        super(accountRepository);
        this.accountRepository = accountRepository;
    }



}
