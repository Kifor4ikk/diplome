package ru.kifor4ik.service;

import java.sql.SQLException;

public interface BaseService<T> {

    public T create(T item) throws SQLException;
    public T getById(int id) throws SQLException;
    public T update(T item) throws SQLException;
    public T delete(int id) throws SQLException;
}
