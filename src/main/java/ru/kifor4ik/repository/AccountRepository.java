package ru.kifor4ik.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.domain.TransferEntity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class AccountRepository extends BaseRepository implements CrudRepository<AccountEntity> {


    @Autowired
    private ExchangeRateRepository exchangeRate;

    @Autowired
    private TransferRepository transferRepository;
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



        } catch (Exception e) {
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

        query.append("value = '").append(item.getValue()).append("',");

        if (query.charAt(query.length() - 1) == ',')
            query.setCharAt(query.length() - 1, ' ');

        query.append("WHERE ID = ").append(item.getId()).append(";");
        System.out.println(query);
        state().executeUpdate(String.valueOf(query));
        return accountEntity;
    }

    @Override
    public AccountEntity delete(int id) throws SQLException {
        state().execute("DELETE FROM abonent WHERE id = " + id + ";");
        return null;
    }

    public boolean transferMoney(int accountIdSender, int accountIdReceiver, BigDecimal amount) throws Exception {

        AccountEntity sender = get(accountIdSender);
        AccountEntity receiver = get(accountIdReceiver);

        if(sender.getValue().compareTo(amount) < 0)
            throw new Exception("Not enough money");

        else {
            BigDecimal bynSender = exchangeRate.getByCode(sender.getCurrencyCode()).getAmount().multiply(amount);
            BigDecimal bynReceiver = bynSender.divide(exchangeRate.getByCode(receiver.getCurrencyCode()).getAmount(), RoundingMode.DOWN);
            sender.setValue(sender.getValue().subtract(amount));
            receiver.setValue(receiver.getValue().add(bynReceiver));
            update(sender);
            update(receiver);
            transferRepository.create(new TransferEntity(1, sender.getId(), receiver.getId(),
                    sender.getCurrencyCode(), receiver.getCurrencyCode(), amount));
        }
        return true;
    }
}
