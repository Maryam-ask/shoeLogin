package com.model.da;

import com.model.to.Person;

/**
 * Created by Maryam Askari
 * Date: 5/21/2021
 * Time: 3:01 PM
 * Project: IntelliJ IDEA
 */
public interface PersonDAO {
    public Person selectValidPerson(String userName, String password);
    public int insertRegisteredPerson(Person person);
}
