package ru.kifor4ik.service.hard;

import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.repository.prepStatRepo.AbonentRepositoryPrepState;

import javax.swing.*;

public class AccountHardService extends AbstractHardService<AbonentRepositoryPrepState, AbonentEntity> {
    public AccountHardService(AbonentRepositoryPrepState repository) {
        super(repository);
    }


}
