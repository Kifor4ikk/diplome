package ru.kifor4ik.repository;

import com.fasterxml.jackson.databind.ser.Serializers;
import ru.kifor4ik.domain.ExchangeRateToBynEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExchangeRateRepository extends BaseRepository implements CrudRepository<ExchangeRateToBynEntity> {
    public ExchangeRateRepository() throws SQLException {
    }

    @Override
    public ExchangeRateToBynEntity create(ExchangeRateToBynEntity item) throws SQLException {
        return null;
    }

    @Override
    public ExchangeRateToBynEntity get(int id) throws SQLException {
            ExchangeRateToBynEntity exchangeRateToByn = null;
        try(ResultSet rs = state().executeQuery("SELECT * FROM exchangetobyn WHERE id = " + id + ";")){

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
    public ExchangeRateToBynEntity update(ExchangeRateToBynEntity item) {
        return null;
    }

    @Override
    public ExchangeRateToBynEntity delete(int id) {
        return null;
    }
}
