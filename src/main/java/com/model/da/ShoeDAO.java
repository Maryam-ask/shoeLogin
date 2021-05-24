package com.model.da;

import com.model.to.Shoe;

import java.util.List;

/**
 * Created by Maryam Askari
 * Date: 5/23/2021
 * Time: 4:43 PM
 * Project: IntelliJ IDEA
 */
public interface ShoeDAO {
    public void insertShoe(Shoe shoe);
    public void deleteShoe(long id);
    public List<Shoe> selectShoes();
}
