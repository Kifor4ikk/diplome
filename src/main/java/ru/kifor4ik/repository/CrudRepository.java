package ru.kifor4ik.repository;

import java.sql.SQLException;

public interface CrudRepository<T> {

    public T create(T item) throws Exception;
    public T get(int id) throws Exception;
    public T update(T item) throws Exception;
    public T delete(int id) throws SQLException;
}
