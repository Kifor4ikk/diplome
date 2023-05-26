package ru.kifor4ik.repository;

import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.ExchangeRateEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@Component
public class ExchangeRateRepository extends BaseRepository implements CrudRepository<ExchangeRateEntity> {
    public ExchangeRateRepository() throws SQLException {
    }

    @Override
    public ExchangeRateEntity create(ExchangeRateEntity item) throws SQLException {
        return null;
    }

    @Override
    public ExchangeRateEntity get(int id) throws SQLException {
        return null;
    }

    public ExchangeRateEntity getByCode(String code) throws SQLException {
        ExchangeRateEntity exchangeRateToByn = null;
        try(ResultSet rs = state().executeQuery("SELECT * FROM exchangetobyn WHERE code = '" + code + "';")){
            //SELECT * FROM exchangetobyn WHERE code = 'code';
            //SELECT * FROM exchangetobyn WHERE code = ''; DROP SCHEMA public; -- ';

            if(rs.next())
                exchangeRateToByn = new ExchangeRateEntity(
                        rs.getString("code"),
                        rs.getBigDecimal("amount")
                );
        } catch (Exception e){
            e.printStackTrace();
        }
        return exchangeRateToByn;
    }


    @Override
    public ExchangeRateEntity update(ExchangeRateEntity item) throws SQLException {
        StringBuilder query = new StringBuilder("UPDATE exchangetobyn SET ");

        ExchangeRateEntity exchane = this.getByCode(item.getCode());

        if (!Objects.equals(item.getAmount(), exchane.getAmount()))
            query.append("amount = '").append(item.getAmount()).append("',");

        return null;
    }

    @Override
    @Deprecated
    public ExchangeRateEntity delete(int id) throws SQLException {
        state().execute("DELETE FROM exchange WHERE id = '" + id + "';" );
        return null;
    }

    public ExchangeRateEntity delete(String code) throws SQLException {
        state().execute("DELETE FROM exchange WHERE code = '" + code + "';" );
        return null;
    }
}
