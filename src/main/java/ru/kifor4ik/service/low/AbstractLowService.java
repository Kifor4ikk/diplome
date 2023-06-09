package ru.kifor4ik.service.low;

import ru.kifor4ik.domain.BaseEntity;
import ru.kifor4ik.repository.CrudRepository;
import ru.kifor4ik.service.BaseService;

import java.sql.SQLException;

public abstract class AbstractLowService<T extends CrudRepository<E>, E extends BaseEntity> implements BaseService<CrudRepository<E>, E> {

    private T repository;


    public AbstractLowService(T repository) {
        this.repository = repository;
    }

    @Override
    public E create(E item) throws Exception {
        return repository.create(item);
    }

    @Override
    public E getById(int id) throws Exception {
        return repository.get(id);
    }

    @Override
    public E update(E item) throws Exception {
        return repository.update( item);
    }

    @Override
    public E delete(int id) throws SQLException {
        return repository.delete(id);
    }
}
