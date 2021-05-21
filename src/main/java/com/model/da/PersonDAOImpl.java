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
    private DatabaseConnection connection = new DatabaseConnection();
    private PreparedStatement preparedStatement;

    private void close() throws SQLException {
        preparedStatement.close();
        connection.close();
    }

    /**
     * A method to select person from a set username and password and put information from SQL into person.
     * @param userName
     * @param password
     * @return An object of Person
     */
    @Override
    public Person selectValidPerson(String userName, String password){

        try {
            preparedStatement = connection.getConnection().prepareStatement("select * from person where username=''"+userName+"'and password ='"+password+"'");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                if(resultSet.getInt(1)==1){
                    Person person = new Person();
                    person.setName(resultSet.getString("name"));
                    person.setFamily(resultSet.getString("family"));
                    person.setUserName(resultSet.getString("username"));
                    person.setPassword(resultSet.getString("password"));
                    person.setAddress(resultSet.getString("address"));
                    person.setPhone(resultSet.getString("phone"));
                    person.setAge(resultSet.getInt("age"));
                    person.setId(resultSet.getInt("id"));
                    person.setRole(resultSet.getString("role"));

                    close();

                    return person;

                }else {
                    return null;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
        return null;
    }

    /**
     * A method for insertin perso into DataBase. this will be used in registration controller.
     * @param person
     */
    @Override
    public void insertRegisteredPerson(Person person){

        try {
            preparedStatement = connection.getConnection().prepareStatement
                    ("insert into person(id,name,family,username,password,phone,address,age,role) values(?,?,?,?,?,?,?,?,?)");

            preparedStatement.setInt(1,person.getId());
            preparedStatement.setString(2,person.getName());
            preparedStatement.setString(3,person.getFamily());
            preparedStatement.setString(4,person.getUserName());
            preparedStatement.setString(5,person.getPassword());
            preparedStatement.setString(6,person.getPhone());
            preparedStatement.setString(7,person.getAddress());
            preparedStatement.setInt(8,person.getAge());
            preparedStatement.setString(9,person.getRole());

            preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
