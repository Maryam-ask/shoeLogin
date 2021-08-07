package com.model.da;

import com.model.to.IdGenerator;
import com.model.to.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Maryam Askari
 * Date: 5/19/2021
 * Time: 12:51 PM
 * Project: IntelliJ IDEA
 */
public class PersonDAOImpl implements PersonDAO {
    private final DatabaseConnection connection = new DatabaseConnection();
    private PreparedStatement preparedStatement;

    private void close() {
        try {
            preparedStatement.close();
            connection.close();
        }catch (SQLException ex){
            ex.getMessage();
            ex.printStackTrace();
            ex.getCause();
        }
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
        Person person = null;

        try {
            preparedStatement = connection.getConnection().prepareStatement
                    ("select * from person where username='" + userName.toLowerCase() + "'and user_password ='" + password + "'");
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                person = setPerson(resultSet);


            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }finally {
            close();
        }

        return person;
    }

    /**
     * A method for insertin perso into DataBase. this will be used in registration controller.
     *
     * @param person
     */
    @Override
    public void insertRegisteredPerson(Person person) {


        try {
            preparedStatement = connection.getConnection().prepareStatement
                    ("insert into person(id,name,FAMILY,username,user_password," +
                                    "mobilephone,address,age,role) " +
                                    "values(?,?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getFamily());
            preparedStatement.setString(4, person.getUserName().toLowerCase());
            preparedStatement.setString(5, person.getPassword());
            preparedStatement.setString(6, person.getPhone());
            preparedStatement.setString(7, person.getAddress());
            preparedStatement.setInt(8, person.getAge());
            preparedStatement.setString(9, person.getRole());

            preparedStatement.executeUpdate();


        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            e.getCause();
        } finally {
                close();
        }

    }


    /**
     * A method witch read all person table from database and
     * @return a list af exist persons in database
     */

    @Override
    public List<Person> selectPersonList() {
        List<Person> personsList =  new ArrayList<Person>();

        try {
            preparedStatement = connection.getConnection().prepareStatement("select * from person");

            ResultSet resultSet = preparedStatement.executeQuery();


            while (resultSet.next()){
                Person person = setPerson(resultSet);
                personsList.add(person);
            }


        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            e.getCause();
        }finally {
                close();
        }

        return personsList;
    }

    @Override
    public boolean userNameCheck(String username) {

        boolean usernameExist = false;

        try {
            preparedStatement = connection.getConnection().
                    prepareStatement("select * from person where username=?");
            preparedStatement.setString(1, username.toLowerCase().trim());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                usernameExist = true;
            }

        }catch (SQLException ex){
            ex.getCause();
            ex.printStackTrace();
            ex.getMessage();
        }
        return usernameExist;
    }


    /**
     * A method to set person's data in resultSet in database
     * @param resultSet
     * @return person information from database
     * @throws SQLException
     */

    public Person setPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setFamily(resultSet.getString("FAMILY"));
        person.setUserName(resultSet.getString("username"));
        person.setPassword(resultSet.getString("user_password"));
        person.setAddress(resultSet.getString("address"));
        person.setPhone(resultSet.getString("mobilephone"));
        person.setAge(resultSet.getInt("age"));
        person.setRole(resultSet.getString("role"));


        return person;
    }


}
