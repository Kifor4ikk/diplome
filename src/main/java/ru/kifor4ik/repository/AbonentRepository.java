package ru.kifor4ik.repository;

import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.AccountEntity;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@Component
public class AbonentRepository extends BaseRepository implements CrudRepository<AbonentEntity> {

    public AbonentRepository() throws SQLException {
    }

    private AccountRepository accountRepository = new AccountRepository();
    private CardRepository cardRepository = new CardRepository();

    @Override
    public AbonentEntity create(AbonentEntity item) throws SQLException {

        System.out.println("->" + item.toString());
        AbonentEntity abonentEntity = null;
        try (ResultSet rs = state().executeQuery("INSERT INTO abonent (" +
                "login," +
                "\"password\"," +
                "firstname," +
                "secondname," +
                "thirdname," +
                "age," +
                "phonenumber," +
                "note)\n" +
                "VALUES ('  " + item.getLogin() +
                "', '" + item.getPassword() +
                "', '" + item.getFirstName() +
                "', '" + item.getSecondName() +
                "', '" + item.getThirdName() +
                "', '" + item.getAge() +
                "', '" + item.getPhoneNumber() +
                "', '" + item.getNote() + "')" +
                "RETURNING ID;")
        ) {
            if(rs.next())
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
    public AbonentEntity update(AbonentEntity item) throws SQLException {

        StringBuilder query = new StringBuilder("UPDATE abonent SET ");

        AbonentEntity abonentEntity = this.get(item.getId());

        if (!item.getFirstName().isBlank() && !Objects.equals(abonentEntity.getFirstName(), item.getFirstName()))
            query.append("firstname = '").append(item.getFirstName()).append("',");
        if (!item.getSecondName().isBlank() && !Objects.equals(abonentEntity.getSecondName(), item.getSecondName()))
            query.append("secondname = '").append(item.getSecondName()).append("',");
        if (!item.getThirdName().isBlank() && !Objects.equals(abonentEntity.getThirdName(), item.getThirdName()))
            query.append("thirdname = '").append(item.getThirdName()).append("',");
        if (!item.getPassword().isBlank() && !Objects.equals(abonentEntity.getPassword(), item.getPassword()))
            query.append("password = '").append(item.getPassword()).append("',");
        if (!item.getPhoneNumber().isBlank() && !Objects.equals(abonentEntity.getPhoneNumber(), item.getPhoneNumber()))
            query.append("phonenumber = '").append(item.getPhoneNumber()).append("',");
        if (!Objects.equals(abonentEntity.getAge(), item.getAge()))
            query.append("age = '").append(item.getAge()).append("',");
        if (query.charAt(query.length() - 1) == ',')
            query.setCharAt(query.length() - 1, ' ');

        query.append("WHERE ID = ").append(item.getId()).append(";");
        state().executeUpdate(String.valueOf(query));
        return abonentEntity;
    }

    @Override
    public AbonentEntity delete(int id) throws SQLException {
        state().execute("DELETE FROM abonent WHERE id = " + id + ";");
        return null;
    }


}
