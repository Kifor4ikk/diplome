package ru.kifor4ik.service;

import ru.kifor4ik.domain.BaseEntity;
import ru.kifor4ik.repository.CrudRepository;

import java.sql.SQLException;

public interface BaseService<T extends CrudRepository<E>, E extends BaseEntity> {

    public E create(E item) throws SQLException;
    public E getById(int id) throws SQLException;
    public E update(E item) throws SQLException;
    public E delete(int id) throws SQLException;
}
