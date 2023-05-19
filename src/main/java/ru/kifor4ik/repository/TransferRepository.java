package ru.kifor4ik.repository;

import ru.kifor4ik.domain.TransferEntity;

import java.sql.SQLException;

public class TransferRepository extends BaseRepository implements CrudRepository<TransferEntity> {
    public TransferRepository() throws SQLException {
    }

    @Override
    public TransferEntity create(TransferEntity item) throws SQLException {
        return null;
    }

    @Override
    public TransferEntity get(int id) throws SQLException {
        return null;
    }

    @Override
    public TransferEntity update(TransferEntity item) {
        return null;
    }

    @Override
    public TransferEntity delete(int id) {
        return null;
    }
}
