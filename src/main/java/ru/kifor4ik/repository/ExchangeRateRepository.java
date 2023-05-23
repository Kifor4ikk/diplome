package ru.kifor4ik.repository;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.CardEntity;
import ru.kifor4ik.domain.ExchangeRateToBynEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@Component
public class ExchangeRateRepository extends BaseRepository implements CrudRepository<ExchangeRateToBynEntity> {
    public ExchangeRateRepository() throws SQLException {
    }

    @Override
    public ExchangeRateToBynEntity create(ExchangeRateToBynEntity item) throws SQLException {
        return null;
    }

    @Override
    @Deprecated
    public ExchangeRateToBynEntity get(int id) throws SQLException {
        return null;
    }

    public ExchangeRateToBynEntity get(String code) throws SQLException {
            ExchangeRateToBynEntity exchangeRateToByn = null;
        try(ResultSet rs = state().executeQuery("SELECT * FROM exchangetobyn WHERE code = '" + code + "';")){

            if(rs.next())
                exchangeRateToByn = new ExchangeRateToBynEntity(
                        rs.getString("code"),
                        rs.getBigDecimal("amount")
                );
        } catch (Exception e){
                e.printStackTrace();
        }
        return exchangeRateToByn;
    }

    public ExchangeRateToBynEntity getByCode(String code) throws SQLException {
        ExchangeRateToBynEntity exchangeRateToByn = null;
        try(ResultSet rs = state().executeQuery("SELECT * FROM exchangetobyn WHERE code = '" + code + "';")){

            if(rs.next())
                exchangeRateToByn = new ExchangeRateToBynEntity(
                        rs.getString("code"),
                        rs.getBigDecimal("amount")
                );
        } catch (Exception e){
            e.printStackTrace();
        }
        return exchangeRateToByn;
    }


    @Override
    public ExchangeRateToBynEntity update(ExchangeRateToBynEntity item) throws SQLException {
        StringBuilder query = new StringBuilder("UPDATE exchangetobyn SET ");

        ExchangeRateToBynEntity exchane = this.get(item.getCode());

        if (!Objects.equals(item.getAmount(), exchane.getAmount()))
            query.append("amount = '").append(item.getAmount()).append("',");

        return null;
    }

    @Override
    @Deprecated
    public ExchangeRateToBynEntity delete(int id) throws SQLException {
        return null;
    }

    public ExchangeRateToBynEntity delete(String code) throws SQLException {
        state().execute("DELETE FROM exchange WHERE code = '" + code + "';" );
        return null;
    }
}
