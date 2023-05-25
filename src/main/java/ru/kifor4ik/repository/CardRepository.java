package ru.kifor4ik.repository;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.domain.CardEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
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
                        rs.getInt("card_password")
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
                                rs.getInt("card_password")
                        )
                );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cardEntity;
    }

    @Override
    public CardEntity update(CardEntity item) throws SQLException {

        StringBuilder query = new StringBuilder("UPDATE card SET ");

        CardEntity cardEntity = this.get(item.getId());

        if (!Objects.equals(cardEntity.getCardPassword(), cardEntity.getCardPassword()))
            query.append("cardpassword = '").append(item.getCardPassword()).append("',");

        return cardEntity;
    }

    @Override
    public CardEntity delete(int id) throws SQLException {
        state().execute("DETELE FROM Card where ID = " + id + ";");
        return null;
    }


    public CardEntity getByNumberAndPass(String number, int password) throws SQLException {
        CardEntity cardEntity = null;

        try (ResultSet rs = state().executeQuery("SELECT * FROM card WHERE  card_number = '" + number + "' AND card_password = '" + password + "';")) {

            if (rs.next())
                cardEntity = new CardEntity(
                        rs.getInt("id"),
                        rs.getInt("account_id"),
                        rs.getDate("expire_date"),
                        rs.getInt("CVV"),
                        rs.getString("card_number"),
                        rs.getInt("card_password")
                );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cardEntity;
    }


    public CardEntity getByNumber(String number) throws SQLException {
        CardEntity cardEntity = null;

        try (ResultSet rs = state().executeQuery("SELECT * FROM card WHERE card_number = '" + number + "';")) {

            if (rs.next())
                cardEntity = new CardEntity(
                        rs.getInt("id"),
                        rs.getInt("account_id"),
                        rs.getDate("expire_date"),
                        rs.getInt("CVV"),
                        rs.getString("card_number"),
                        rs.getInt("card_password")
                );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cardEntity;
    }
}
