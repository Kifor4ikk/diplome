package ru.kifor4ik.repository;

import com.fasterxml.jackson.databind.ser.Serializers;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.domain.CardEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardRepository extends BaseRepository implements CrudRepository<CardEntity> {

    public CardRepository() throws SQLException {
    }

    @Override
    public CardEntity create(CardEntity item) throws SQLException {
        return null;
    }

    @Override
    public CardEntity get(int id) throws SQLException {
        CardEntity cardEntity = null;

        try (ResultSet rs = state().executeQuery("SELECT * FROM card WHERE id = " + id + ";")) {

            if (rs.next())
                cardEntity = new CardEntity(
                        rs.getInt("id"),
                        rs.getInt("account_id"),
                        rs.getDate("expire_date"),
                        rs.getInt("CVV"),
                        rs.getString("card_number"),
                        rs.getString("card_password")
                );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cardEntity;
    }

    public List<CardEntity> getByAbonentId(int id) throws SQLException {
        List<CardEntity> cardEntity = new ArrayList<>();
        try (ResultSet rs = state().executeQuery("SELECT card.id, card.account_id, card.expire_date" +
                ", cvv, card_password, card_number " +
                "FROM card " +
                "INNER JOIN account ON account.id = card.account_id " +
                "INNER JOIN abonent ON abonent.id = account.abonent_id " +
                "WHERE abonent.id = " + id + ";")) {
            while (rs.next())
                cardEntity.add(new CardEntity(
                                rs.getInt("id"),
                                rs.getInt("account_id"),
                                rs.getDate("expire_date"),
                                rs.getInt("CVV"),
                                rs.getString("card_number"),
                                rs.getString("card_password")
                        )
                );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cardEntity;
    }

    @Override
    public CardEntity update(CardEntity item) {
        return null;
    }

    @Override
    public CardEntity delete(int id) {
        return null;
    }
}
