package ru.kifor4ik.repository;

import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.ExchangeRateToBynEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AbonentRepository extends BaseRepository implements CrudRepository<AbonentEntity> {

    public AbonentRepository() throws SQLException {
    }
    private AccountRepository accountRepository = new AccountRepository();
    private CardRepository cardRepository = new CardRepository();
    @Override
    public AbonentEntity create(AbonentEntity item) throws SQLException {
        AbonentEntity abonentEntity = null;
        try (ResultSet rs = state().executeQuery("INSERT INTO abonent (login,\"password\",firstname,secondname,thirdname,age,phonenumber,note)\n" +
                "VALUES (' " +
                "', '" + item.getLogin() +
                "', '" + item.getPassword() +
                "', '" + item.getFirstName() +
                "', '" + item.getSecondName() +
                "', '" + item.getThirdName() +
                "', '" + item.getAge() +
                "', '" + item.getPhoneNumber() +
                "', '" + item.getNote() + "')" +
                "RETURNING ID;")
        ) {
            abonentEntity = this.get(rs.getInt("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return abonentEntity;
    }

    @Override
    public AbonentEntity get(int id) throws SQLException {
        AbonentEntity abonentEntity = null;

        try (ResultSet rs = state().executeQuery("SELECT * FROM abonent WHERE id = " + id + ";")) {
            //Info about abonent
            if (rs.next())
                abonentEntity = new AbonentEntity(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("firstname"),
                        rs.getString("secondname"),
                        rs.getString("thirdname"),
                        rs.getInt("age"),
                        rs.getString("phonenumber"),
                        rs.getString("note")
                );

            abonentEntity.setAccounts(accountRepository.getByAbonentId(abonentEntity.getId()));
            abonentEntity.setCards(cardRepository.getByAbonentId(abonentEntity.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return abonentEntity;
    }

    public AbonentEntity getByLogPass(String login, String pass) throws SQLException {
        AbonentEntity abonentEntity = null;



        try (ResultSet rs = state().executeQuery("SELECT * FROM abonent WHERE login = '" + login + "' AND password = '" + pass + "';")) {
            //Info about abonent
            abonentEntity = new AbonentEntity(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("firstname"),
                    rs.getString("secondname"),
                    rs.getString("thirdname"),
                    rs.getInt("age"),
                    rs.getString("phonenumber"),
                    rs.getString("note")
            );
            abonentEntity.setAccounts(accountRepository.getByAbonentId(abonentEntity.getId()));
            abonentEntity.setCards(cardRepository.getByAbonentId(abonentEntity.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return abonentEntity;
    }

    @Override
    public AbonentEntity update(AbonentEntity item) {
        return null;
    }

    @Override
    public AbonentEntity delete(int id) {
        return null;
    }
}
