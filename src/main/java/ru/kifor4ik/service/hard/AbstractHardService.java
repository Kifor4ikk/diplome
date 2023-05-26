package ru.kifor4ik.service.hard;

import ru.kifor4ik.domain.BaseEntity;
import ru.kifor4ik.repository.CrudRepository;
import ru.kifor4ik.service.low.AbstractLowService;

public class AbstractHardService <T extends CrudRepository<E>, E extends BaseEntity> extends AbstractLowService<T, E> {

    private T repository;

    public AbstractHardService(T repository) {
        super(repository);
        this.repository = repository;
    }



}
