package com.model.da;

import com.model.to.Shoe;

/**
 * Created by Maryam Askari
 * Date: 5/23/2021
 * Time: 4:43 PM
 * Project: IntelliJ IDEA
 */
public interface ShoeDAO {
    public void insertShoe(Shoe shoe);
    public void deleteShoe(long id);
}
