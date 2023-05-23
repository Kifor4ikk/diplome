package ru.kifor4ik.service.low;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.BaseEntity;
import ru.kifor4ik.repository.AbonentRepository;

import java.sql.SQLException;

@Component
public class AbonentServiceLow extends AbstractLowService<AbonentRepository, AbonentEntity> {

    @Autowired
    public AbonentServiceLow(AbonentRepository repository) {
        super(repository);
    }

}
