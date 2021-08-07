package com.model.da;

import com.model.to.Person;

import java.util.List;

/**
 * Created by Maryam Askari
 * Date: 5/21/2021
 * Time: 3:01 PM
 * Project: IntelliJ IDEA
 */
public interface PersonDAO {
    public Person selectValidPerson(String userName, String password);
    public void insertRegisteredPerson(Person person);
    public List<Person> selectPersonList();
}
