package ru.kifor4ik.service.low;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.repository.AbonentRepository;
import ru.kifor4ik.service.BaseService;

import java.sql.SQLException;

@Component
public class AbonentServiceLow implements BaseService<AbonentEntity> {

    @Autowired
    private AbonentRepository abonentRepository;

    public AbonentServiceLow() {
    }

    @Override
    public AbonentEntity create(AbonentEntity item) throws SQLException {
        return abonentRepository.create(item);
    }

    @Override
    public AbonentEntity getById(int id) throws SQLException {
        return abonentRepository.get(id);
    }

    @Override
    public AbonentEntity update(AbonentEntity item) throws SQLException {
        return abonentRepository.update(item);
    }

    @Override
    public AbonentEntity delete(int id) throws SQLException {
        return abonentRepository.delete(id);
    }
}
