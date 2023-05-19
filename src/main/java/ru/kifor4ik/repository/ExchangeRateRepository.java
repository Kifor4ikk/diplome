package ru.kifor4ik.repository;

import com.fasterxml.jackson.databind.ser.Serializers;
import ru.kifor4ik.domain.ExchangeRateToBynEntity;

import java.sql.SQLException;

public class ExchangeRateRepository extends BaseRepository implements CrudRepository<ExchangeRateToBynEntity> {
    public ExchangeRateRepository() throws SQLException {
    }

    @Override
    public ExchangeRateToBynEntity create(ExchangeRateToBynEntity item) throws SQLException {
        return null;
    }

    @Override
    public ExchangeRateToBynEntity get(int id) throws SQLException {
        return null;
    }

    @Override
    public ExchangeRateToBynEntity update(ExchangeRateToBynEntity item) {
        return null;
    }

    @Override
    public ExchangeRateToBynEntity delete(int id) {
        return null;
    }
}
