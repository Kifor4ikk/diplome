package ru.kifor4ik.repository.prepStatRepo;

import org.springframework.stereotype.Component;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.repository.AccountRepository;
import ru.kifor4ik.repository.CardRepository;
import ru.kifor4ik.repository.CrudRepository;
import ru.kifor4ik.repository.BaseRepository;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@Component
public class AbonentRepositoryPrepState extends BaseRepository implements CrudRepository<AbonentEntity> {
    private AccountRepository accountRepository = new AccountRepository();
    private CardRepository cardRepository = new CardRepository();

    public AbonentRepositoryPrepState(AccountRepository accountRepository) throws SQLException {
        this.accountRepository = accountRepository;
    }


    @Override
    public AbonentEntity create(AbonentEntity item) throws SQLException {

        try (PreparedStatement preparedStatement = state().getConnection().prepareStatement("INSERT INTO abonent (" +
                        "login," +
                        "\"password\"," +
                        "firstname," +
                        "secondname," +
                        "thirdname," +
                        "age," +
                        "phonenumber," +
                        "note)\n" +
                        "VALUES (?,?,?,?,?,?,?,?)" +
                        "RETURNING ID;")) {

            preparedStatement.setString(1, item.getLogin());
            preparedStatement.setString(2, item.getPassword());
            preparedStatement.setString(3, item.getFirstName());
            preparedStatement.setString(4, item.getSecondName());
            preparedStatement.setString(5, item.getThirdName());
            preparedStatement.setInt(6, item.getAge());
            preparedStatement.setString(7, item.getPhoneNumber());
            preparedStatement.setString(8, item.getNote());

            ResultSet rs = preparedStatement.executeQuery();
            int id = 0;
            if (rs.next())
                id = rs.getInt("id");

            return get(id);
        }
    }

    @Override
    public AbonentEntity get(int id) throws SQLException {
        AbonentEntity abonentEntity = null;

        try (ResultSet rs = state().executeQuery("SELECT * FROM abonent WHERE id = " + id + ";")) {
            //Info about abonent
            if (rs.next()) {
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
            }

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

        try (PreparedStatement preparedStatement = state().getConnection().prepareStatement(
                "UPDATE abonent SET password = ?, firstname = ?, secondname = ?, " +
                "thirdname = ?, phonenumber = ?, age = ?, note = ? WHERE id = ?")) {

            preparedStatement.setString(1, item.getPassword());
            preparedStatement.setString(2, item.getFirstName());
            preparedStatement.setString(3, item.getSecondName());
            preparedStatement.setString(4, item.getThirdName());
            preparedStatement.setString(5, item.getPhoneNumber());
            preparedStatement.setInt(6, item.getAge());
            preparedStatement.setString(7, item.getNote());
            preparedStatement.setInt(8, item.getId());
            int rows = preparedStatement.executeUpdate();

            System.out.println(rows);
        }
        return null;
    }

    @Override
    public AbonentEntity delete(int id) throws SQLException {
        state().execute("DELETE FROM abonent WHERE id = " + id + ";");
        return null;
    }

}
