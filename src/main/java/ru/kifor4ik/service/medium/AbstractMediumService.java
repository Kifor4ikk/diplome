package ru.kifor4ik.service.medium;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kifor4ik.domain.BaseEntity;
import ru.kifor4ik.repository.CrudRepository;
import ru.kifor4ik.service.BaseService;
import ru.kifor4ik.service.low.AbstractLowService;

import java.sql.SQLException;

public class AbstractMediumService<T extends CrudRepository<E>, E extends BaseEntity> extends AbstractLowService <T, E> {

    private T repository;

    public AbstractMediumService(T repository) {
        super(repository);
        this.repository = repository;
    }

    protected boolean validateQuery(String query) throws Exception {
        if(
                query.toUpperCase().contains("DROP") ||
                        query.toUpperCase().contains("SELECT") ||
                        query.toUpperCase().contains("INSERT") ||
                        query.toUpperCase().contains("SET") ||
                        query.toUpperCase().contains("UPDATE") ||
                        query.toUpperCase().contains("COLUMN") ||
                        query.toUpperCase().contains("CREATEE") ||
                        query.toUpperCase().contains("DATABASE")

        ) throw new Exception("Field contain bad word!");

        return true;
    }
}
