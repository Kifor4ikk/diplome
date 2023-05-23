package ru.kifor4ik.repository;

import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.AccountEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class AccountRepository extends BaseRepository implements CrudRepository<AccountEntity> {


    public AccountRepository() throws SQLException {
    }


    @Override
    public AccountEntity create(AccountEntity item) throws SQLException {
        AccountEntity accountEntity = null;
        try (ResultSet rs = state().executeQuery("INSERT INTO account (abonent_id,currency_code,\"value\")\n" +
                "VALUES (" +
                item.getAbonentId() + ",'" + item.getCurrencyCode() + "', " + 0 + ") RETURNING ID;")) {

            if(rs.next())
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
    public AccountEntity update(AccountEntity item) throws SQLException {
        StringBuilder query = new StringBuilder("UPDATE account SET ");

        AccountEntity accountEntity = this.get(item.getId());

        if (!item.getCurrencyCode().isBlank() && !Objects.equals(accountEntity.getCurrencyCode(), item.getCurrencyCode()))
            query.append("currencycode = '").append(item.getCurrencyCode()).append("',");

        if (!Objects.equals(accountEntity.getAbonentId(), item.getAbonentId()))
            query.append("abonentid = '").append(item.getAbonentId()).append("',");


        if (query.charAt(query.length() - 1) == ',')
            query.setCharAt(query.length() - 1, ' ');

        query.append("WHERE ID = ").append(item.getId()).append(";");
        state().executeUpdate(String.valueOf(query));

        return accountEntity;
    }

    @Override
    public AccountEntity delete(int id) throws SQLException {
        state().execute("DELETE FROM abonent WHERE id = " + id + ";");
        return null;
    }
}
