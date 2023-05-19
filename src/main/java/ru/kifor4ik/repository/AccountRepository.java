package ru.kifor4ik.repository;

import ru.kifor4ik.domain.AccountEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository extends BaseRepository implements CrudRepository<AccountEntity> {


    public AccountRepository() throws SQLException {
    }


    @Override
    public AccountEntity create(AccountEntity item) throws SQLException {

        try(ResultSet rs = state().executeQuery("")){

        } catch (Exception e){

        }

        return null;
    }

    @Override
    public AccountEntity get(int id) {
        return null;
    }

    @Override
    public AccountEntity update(AccountEntity item) {
        return null;
    }

    @Override
    public AccountEntity delete(int id) {
        return null;
    }
}
