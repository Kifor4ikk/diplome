package ru.kifor4ik.repository;

import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.TransferEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class TransferRepository extends BaseRepository implements CrudRepository<TransferEntity> {
    public TransferRepository() throws SQLException {}

    @Override
    public TransferEntity create(TransferEntity item) throws SQLException {

        TransferEntity transferEntity = null;
        try (ResultSet rs = state().executeQuery("INSERT INTO transfer (sender,receiver,sender_currency_code," +
                "receiver_currency_code,amount)\n" +
                "VALUES (' " +
                "', '" + item.getSender_account_id() +
                "', '" + item.getReceiver_account_id() +
                "', '" + item.getSender_currency_code() +
                "', '" + item.getReceiver_currency_code() +
                "', '" + item.getAmount()+ "')" +
                "RETURNING ID;")
        ) {
            if(rs.next())
                transferEntity = this.get(rs.getInt("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transferEntity;
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
