package ru.kifor4ik.repository;

import java.sql.SQLException;

public interface CrudRepository<T> {

    public T create(T item) throws SQLException;
    public T get(int id);
    public T update(T item);
    public T delete(int id);
}
