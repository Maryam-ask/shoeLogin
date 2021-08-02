package com.model.da;

import com.model.to.Shoe;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Shoe> selectShoes(){
        List<Shoe> shoeList = new ArrayList<Shoe>();
        try{
            preparedStatement = connection.getConnection().prepareStatement("select * from shoe");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Shoe shoe= new Shoe();
                shoe.setId(resultSet.getLong("ID"));
                shoe.setName(resultSet.getString("NAME"));
                shoe.setColor(resultSet.getString("COLOR"));
                shoe.setType(resultSet.getString("SHOETYPE"));
                shoe.setSize(resultSet.getInt("SHOESIZE"));
                shoe.setBrand(resultSet.getString("BRAND"));
                shoe.setPrise(resultSet.getDouble("PRISE"));
                shoeList.add(shoe);
            }
            close();
        }catch (Exception e){
            e.getStackTrace();
            e.getCause();
        }
        return shoeList;
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
