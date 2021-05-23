package com.model.da;

import com.model.to.Shoe;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Maryam Askari
 * Date: 5/23/2021
 * Time: 4:31 PM
 * Project: IntelliJ IDEA
 */
public class ShoeDAOImpl implements ShoeDAO{

    private final DatabaseConnection connection = new DatabaseConnection();
    private PreparedStatement preparedStatement;

    private void close() throws SQLException {
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void insertShoe(Shoe shoe){
        try{
            preparedStatement = connection.getConnection().prepareStatement
                    ("insert into shoe(id,name,color,shoetype,shoesize,brand,prise) values (?,?,?,?,?,?,?)");

            preparedStatement.setLong(1,shoe.getId());
            preparedStatement.setString(2,shoe.getName());
            preparedStatement.setString(3,shoe.getColor());
            preparedStatement.setString(4,shoe.getType());
            preparedStatement.setInt(5,shoe.getSize());
            preparedStatement.setString(6,shoe.getBrand());
            preparedStatement.setDouble(7,shoe.getPrise());

            preparedStatement.executeUpdate();

            close();
        }catch (Exception e){
            e.getStackTrace();
            e.getCause();
        }
    }

    @Override
    public void deleteShoe(long id){
        try{
            preparedStatement= connection.getConnection().prepareStatement("delete from shoe where id=?");
            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();
            close();

        }catch (Exception e){
            e.getStackTrace();
            e.getCause();
        }

    }


}
