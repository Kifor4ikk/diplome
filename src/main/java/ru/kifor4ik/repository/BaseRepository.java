package ru.kifor4ik.repository;

import org.springframework.stereotype.Component;
import ru.kifor4ik.util.DataBaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class BaseRepository {

    protected final Connection connection = DataBaseConnection.connection();;

    public BaseRepository() throws SQLException {}

    public Statement state() throws SQLException {
        return connection.createStatement();
    }
}
