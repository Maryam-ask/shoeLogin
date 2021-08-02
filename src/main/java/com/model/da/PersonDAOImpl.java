package com.model.da;

import com.model.to.Person;
import java.sql.*;

/**
 * Created by Maryam Askari
 * Date: 5/19/2021
 * Time: 12:51 PM
 * Project: IntelliJ IDEA
 */
public class PersonDAOImpl implements PersonDAO {
    private final DatabaseConnection connection = new DatabaseConnection();
    private PreparedStatement preparedStatement;

    private void close() throws SQLException {
        preparedStatement.close();
        connection.close();
    }

    /**
     * A method to select person from a set username and password and put information from SQL into person.
     *
     * @param userName
     * @param password
     * @return An object of Person
     */
    @Override
    public Person selectValidPerson(String userName, String password) {
        Person person = new Person();

        try {
            preparedStatement = connection.getConnection().prepareStatement
                    ("select * from person where username='" + userName + "'and password ='" + password + "'");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setFamily(resultSet.getString("family"));
                person.setUserName(resultSet.getString("username"));
                person.setPassword(resultSet.getString("password"));
                person.setAddress(resultSet.getString("address"));
                person.setPhone(resultSet.getString("phone"));
                person.setAge(resultSet.getInt("age"));
                person.setRole(resultSet.getString("role"));

                close();



            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
            return null;
        }
        return person;
    }

    /**
     * A method for insertin perso into DataBase. this will be used in registration controller.
     *
     * @param person
     */
    @Override
    public int insertRegisteredPerson(Person person) {

        try {
            preparedStatement = connection.getConnection().prepareStatement
                    ("insert into person(name,family,username,password,phone,address,age,role) values(?,?,?,?,?,?,?,?)"
                            , Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getFamily());
            preparedStatement.setString(3, person.getUserName());
            preparedStatement.setString(4, person.getPassword());
            preparedStatement.setString(5, person.getPhone());
            preparedStatement.setString(6, person.getAddress());
            preparedStatement.setInt(7, person.getAge());
            preparedStatement.setString(8, person.getRole());

            preparedStatement.executeUpdate();

                ResultSet keyResultSet = preparedStatement.getGeneratedKeys();
                if (keyResultSet.next()) {
                    Integer id = keyResultSet.getInt(1);
                    //person.setId(id);
                    // System.out.println(id);
                }

            close();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return 0;
    }

}
