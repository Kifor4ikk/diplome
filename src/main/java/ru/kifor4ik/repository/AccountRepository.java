package ru.kifor4ik.repository;

import ru.kifor4ik.domain.AccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository extends BaseRepository implements CrudRepository<AccountEntity> {


    public AccountRepository() throws SQLException {
    }


    @Override
    public AccountEntity create(AccountEntity item) throws SQLException {
        AccountEntity accountEntity = null;
        try (ResultSet rs = state().executeQuery("INSERT INTO account (abonent_id,currency_code,\"value\")\n" +
                "VALUES (" +
                item.getAbonentId() + ",'" + item.getCurrencyCode() + "', " + 0 + ") RETURNING ID;")) {
            accountEntity = this.get(rs.getInt("id"));

        } catch (Exception e) {
            e.printStackTrace();
        }



        return accountEntity;
    }

    @Override
    public AccountEntity get(int id) {
        AccountEntity accountEntity = null;

        try (ResultSet rs = state().executeQuery("SELECT * FROM account WHERE id = " + id + ";")) {

            if (rs.next())
                accountEntity = new AccountEntity(
                        rs.getInt("id"),
                        rs.getInt("abonent_id"),
                        rs.getBigDecimal("value"),
                        rs.getString("currency_code")
                );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accountEntity;
    }


    public List<AccountEntity> getByAbonentId(int id) {
        List<AccountEntity> accountEntity = new ArrayList<>();

        try (ResultSet rs = state().executeQuery("SELECT * FROM account WHERE abonent_id = " + id + ";")) {
            while (rs.next())
                accountEntity.add(
                        new AccountEntity(
                                rs.getInt("id"),
                                rs.getInt("abonent_id"),
                                rs.getBigDecimal("value"),
                                rs.getString("currency_code")
                        )
                );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accountEntity;
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
